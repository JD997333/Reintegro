package com.reintegro.profuturo.app.domain.interactor;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.InitialCaptureContract;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.data.repository.RepaymentEventRepository;
import com.reintegro.profuturo.app.domain.converter.ClientConverter;
import com.reintegro.profuturo.app.domain.converter.RepaymentConverter;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;
import com.reintegro.profuturo.app.util.Utils;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class InitialCaptureInteractor extends InteractorBase<InitialCaptureContract.Presenter> implements InitialCaptureContract.Interactor {
    RepositoryFactory repositoryFactory;

    public InitialCaptureInteractor(RepositoryFactory repositoryFactory) {
        this.repositoryFactory = repositoryFactory;
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
        //TODO: Create dummy structure for simulate data, replace this for web service
        //presenter.onGetRepaymentEventsSuccess(Utils.getMockRepaymentEvents());
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
