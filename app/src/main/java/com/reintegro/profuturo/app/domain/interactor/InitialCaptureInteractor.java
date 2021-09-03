package com.reintegro.profuturo.app.domain.interactor;

import androidx.annotation.NonNull;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.InitialCaptureContract;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.data.factory.DataProviderFactory;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.provider.Provider;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.data.repository.RepaymentEventRepository;
import com.reintegro.profuturo.app.domain.converter.ClientConverter;
import com.reintegro.profuturo.app.domain.converter.RepaymentConverter;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.util.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class InitialCaptureInteractor extends InteractorBase<InitialCaptureContract.Presenter> implements InitialCaptureContract.Interactor {
    private RepositoryFactory repositoryFactory;
    private DataProviderFactory dataProviderFactory;

    public InitialCaptureInteractor(RepositoryFactory repositoryFactory, DataProviderFactory dataProviderFactory) {
        this.repositoryFactory = repositoryFactory;
        this.dataProviderFactory = dataProviderFactory;
    }

    @Override
    public void getClientData() {
        Single.
            create((SingleEmitter<ClientDto> emitter) -> {
                ClientRepository clientRepository = repositoryFactory.createClientRepository();

                ClientEntity clientEntity = clientRepository.getSelected();
                emitter.onSuccess(ClientConverter.convertFromEntity(clientEntity));
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<ClientDto>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull ClientDto clientDto) {
                    presenter.onGetClientDataSuccess(clientDto);
                }

                @Override
                public void onError(@NonNull Throwable e) {

                }
            });
    }

    @Override
    public void getRepaymentEvents(ClientDto clientDto) {
        Single
            .create((SingleEmitter<List<RepaymentEntity>> emitter) -> {
                Provider<List<RepaymentEntity>> getRepaymentEventsProvider;
                getRepaymentEventsProvider = dataProviderFactory.createGetRepaymentsProvider(ClientConverter.convertFromDto(clientDto));

                getRepaymentEventsProvider.subscribe(new Provider.Subscriber<List<RepaymentEntity>>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(List<RepaymentEntity> result) {
                        emitter.onSuccess(result);
                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<List<RepaymentEntity>>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull List<RepaymentEntity> repaymentEntities) {
                    validateRepaymentEvents(repaymentEntities);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onGetRepaymentEventsError();
                }
            });
    }

    @Override
    public void validateRepaymentEvents(List<RepaymentEntity> repaymentEntities) {
        Single
            .create((SingleEmitter<List<RepaymentEntity>> emitter) -> {
                List<RepaymentEntity> trdEvents = new ArrayList<>();
                List<RepaymentEntity> repaymentEvents = new ArrayList<>();
                int i = 1;

                for (RepaymentEntity event : repaymentEntities){
                    if (event.getBenefitType().equals(Constants.ID_EVENT_TYPE_TRD)){
                        event.setEventNumber(i);
                        trdEvents.add(event);
                        i++;
                    }else if (event.getBenefitType().equals(Constants.ID_EVENT_TYPE_REPAYMENT)){
                        repaymentEvents.add(event);
                    }
                }

                if (trdEvents.size() >= 1){
                    for (RepaymentEntity trdEvent : trdEvents){
                        for (RepaymentEntity repayment : repaymentEvents){
                            if (trdEvent.getResolutionNumber().equals(repayment.getResolutionNumber())){
                                trdEvent.setPreDiscountedWeeks(trdEvent.getPreDiscountedWeeks() + repayment.getDiscountedWeeks());
                                trdEvent.setPreRepaymentAmount(trdEvent.getPreRepaymentAmount() + repayment.getTrdAmount());
                            }
                        }
                        trdEvent.setMaxWeeksRepayment(trdEvent.getDiscountedWeeks() - trdEvent.getPreDiscountedWeeks());
                        trdEvent.setWeekAmountValue(trdEvent.getRepaymentValueDay() * 7);
                    }
                    emitter.onSuccess(trdEvents);
                }else {
                    emitter.onError(new Throwable());
                }
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<List<RepaymentEntity>>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull List<RepaymentEntity> repaymentEntities) {
                    saveRepaymentEvents(repaymentEntities);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onGetRepaymentEventsError();
                }
            });
    }

    @Override
    public void getRepaymentEventsDummy(ClientDto clientDto) {
        List<RepaymentEntity> repaymentEvents = Utils.getMockRepaymentEvents();
        saveRepaymentEvents(repaymentEvents);
    }

    @Override
    public void saveRepaymentEvents(List<RepaymentEntity> repaymentEvents) {
        Single.
            create((SingleEmitter<List<RepaymentDto>> emitter) -> {
                RepaymentEventRepository repaymentEventRepository = repositoryFactory.createRepaymentEventRepository();
                repaymentEventRepository.clear();
                repaymentEventRepository.addAll(repaymentEvents);

                List<RepaymentEntity> repaymentEntities;
                repaymentEntities = repaymentEventRepository.getAll();
                emitter.onSuccess(RepaymentConverter.convertFromEntities(repaymentEntities));
                }
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<List<RepaymentDto>>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull List<RepaymentDto> repaymentDtos) {
                    presenter.onSaveRepaymentEventsSuccess(repaymentDtos);
                }

                @Override
                public void onError(@NonNull Throwable e) {

                }
            });
    }

    @Override
    public void setSelectedRepaymentEvent(RepaymentDto repaymentDto) {
        Completable
            .create((CompletableEmitter emitter) ->{
                RepaymentEventRepository repaymentEventRepository = repositoryFactory.createRepaymentEventRepository();
                RepaymentEntity repaymentEntity;
                repaymentEntity = RepaymentConverter.convertFromDto(repaymentDto);
                repaymentEntity.setSelected(true);

                repaymentEventRepository.setSelected(repaymentEntity);
                repaymentEntity.setSelected(true);
                emitter.onComplete();
                }
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new CompletableObserver() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onComplete() {
                    presenter.onSetSelectedRepaymentEventSuccess();
                }

                @Override
                public void onError(@NonNull Throwable e) {

                }
            });
    }
}
