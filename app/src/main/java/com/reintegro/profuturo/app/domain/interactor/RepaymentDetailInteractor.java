package com.reintegro.profuturo.app.domain.interactor;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.RepaymentDetailContract;
import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.ProcedureEntity;
import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.data.factory.DataProviderFactory;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.provider.Provider;
import com.reintegro.profuturo.app.data.repository.AgentRepository;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.data.repository.ProcedureRepository;
import com.reintegro.profuturo.app.data.repository.RepaymentEventRepository;
import com.reintegro.profuturo.app.domain.converter.RepaymentConverter;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;

import java.text.NumberFormat;
import java.util.List;

import javax.annotation.Nonnull;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.annotations.NonNull;

public class RepaymentDetailInteractor extends InteractorBase<RepaymentDetailContract.Presenter> implements RepaymentDetailContract.Interactor {
    private RepositoryFactory repositoryFactory;
    private DataProviderFactory dataProviderFactory;

    public RepaymentDetailInteractor(RepositoryFactory repositoryFactory, DataProviderFactory dataProviderFactory) {
        this.repositoryFactory = repositoryFactory;
        this.dataProviderFactory = dataProviderFactory;
    }

    @Override
    public void calculateRepaymentAmount(int weeksNum) {
        Single.
            create((SingleEmitter<RepaymentDto> emitter) -> {
                RepaymentEventRepository repaymentEventRepository = repositoryFactory.createRepaymentEventRepository();
                RepaymentEntity repaymentEntity = repaymentEventRepository.getSelected();
                repaymentEntity.setRequestedWeeks(weeksNum);

                Provider<RepaymentEntity> calculateRepaymentProvider;
                calculateRepaymentProvider = dataProviderFactory.createCalculateRepaymentProvider(repaymentEntity);
                calculateRepaymentProvider.subscribe(new Provider.Subscriber<RepaymentEntity>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(RepaymentEntity result) {
                        repaymentEntity.setCalculatedAmount(result.getCalculatedAmount());
                        repaymentEventRepository.update(repaymentEntity);
                        emitter.onSuccess(RepaymentConverter.convertFromEntity(repaymentEntity));
                    }
                });

                //double repaymentAmount = 0.0;
                //repaymentAmount = weeksNum  * repaymentEntity.getRepaymentValueDay() * 7;
                //repaymentEntity.setCalculatedAmount(repaymentAmount);
                }
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<RepaymentDto>() {
                   @Override
                   public void onSubscribe(@NonNull Disposable d) {

                   }

                   @Override
                   public void onSuccess(@NonNull RepaymentDto repaymentDto) {
                       presenter.onCalculateRepaymentAmountSuccess(repaymentDto);
                   }

                   @Override
                   public void onError(@NonNull Throwable e) {
                       presenter.onCalculateRepaymentAmountError();
                   }
               }
            );
    }

    @Override
    public void calculateRepaymentAmountDummy(int weeksNum) {
        Single.
            create((SingleEmitter<RepaymentDto> emitter) -> {
                    RepaymentEventRepository repaymentEventRepository = repositoryFactory.createRepaymentEventRepository();
                    RepaymentEntity repaymentEntity = repaymentEventRepository.getSelected();

                    double repaymentAmount = 0.0;
                    repaymentAmount = weeksNum  * repaymentEntity.getRepaymentValueDay() * 7;

                    repaymentEntity.setRequestedWeeks(weeksNum);
                    repaymentEntity.setCalculatedAmount(repaymentAmount);
                    repaymentEventRepository.update(repaymentEntity);

                    emitter.onSuccess(RepaymentConverter.convertFromEntity(repaymentEntity));
                }
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<RepaymentDto>() {
                           @Override
                           public void onSubscribe(@NonNull Disposable d) {

                           }

                           @Override
                           public void onSuccess(@NonNull RepaymentDto repaymentDto) {
                               presenter.onCalculateRepaymentAmountSuccess(repaymentDto);
                           }

                           @Override
                           public void onError(@NonNull Throwable e) {

                           }
                       }
            );
    }

    @Override
    public void getRepaymentInformation() {
        Single.
            create((SingleEmitter<RepaymentDto> emitter) -> {
                    RepaymentEventRepository repaymentEventRepository = repositoryFactory.createRepaymentEventRepository();
                    RepaymentEntity repaymentEntity = repaymentEventRepository.getSelected();

                    emitter.onSuccess(RepaymentConverter.convertFromEntity(repaymentEntity));
                }
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<RepaymentDto>() {
                   @Override
                   public void onSubscribe(@NonNull Disposable d) {

                   }

                   @Override
                   public void onSuccess(@NonNull RepaymentDto repaymentDto) {
                       presenter.onGetRepaymentInformationSuccess(repaymentDto);
                   }

                   @Override
                   public void onError(@NonNull Throwable e) {

                   }
               }
            );
    }

    @Override
    public void saveInitialCapture() {
        Single
            .create((SingleEmitter<ProcedureEntity> emitter) -> {
                AgentRepository agentRepository = repositoryFactory.createAgentRepository();
                AgentEntity agentEntity = agentRepository.getFirst();

                ClientRepository clientRepository = repositoryFactory.createClientRepository();
                ClientEntity clientEntity = clientRepository.getSelected();

                RepaymentEventRepository repaymentEventRepository = repositoryFactory.createRepaymentEventRepository();
                RepaymentEntity repaymentEntity = repaymentEventRepository.getSelected();

                ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
                ProcedureEntity procedureEntity = procedureRepository.getFirst();

                Provider<ProcedureEntity> saveInitialCaptureProvider;
                saveInitialCaptureProvider = dataProviderFactory.saveInitialCapture(repaymentEntity, clientEntity, agentEntity, procedureEntity);
                saveInitialCaptureProvider.subscribe(new Provider.Subscriber<ProcedureEntity>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(ProcedureEntity result) {
                        procedureEntity.setBinnacleFolio(result.getBinnacleFolio());
                        procedureEntity.setProcedureFolio(result.getProcedureFolio());
                        emitter.onSuccess(procedureEntity);
                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<ProcedureEntity>() {
                   @Override
                   public void onSubscribe(@Nonnull Disposable d) {

                   }

                   @Override
                   public void onSuccess(@NonNull ProcedureEntity procedureEntity) {
                       updateProcedure(procedureEntity);
                   }

                   @Override
                   public void onError(@Nonnull Throwable e) {
                       presenter.onSaveInitialCaptureError();
                   }
               }
            );
    }

    @Override
    public void updateProcedure(ProcedureEntity procedureEntity) {
        Completable
            .create((CompletableEmitter emitter) ->{
                ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
                procedureRepository.update(procedureEntity);
                emitter.onComplete();
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new CompletableObserver() {
                @Override
                public void onSubscribe(@Nonnull Disposable d) {

                }

                @Override
                public void onComplete() {
                    presenter.onSaveInitialCaptureSuccess();
                }

                @Override
                public void onError(@Nonnull Throwable e) {

                }
            });
    }

    @Override
    public void insertClientData() {
        Completable
            .create((CompletableEmitter emitter) -> {
                ClientRepository clientRepository = repositoryFactory.createClientRepository();
                ClientEntity clientEntity = clientRepository.getSelected();

                AgentRepository agentRepository = repositoryFactory.createAgentRepository();
                AgentEntity agentEntity = agentRepository.getFirst();

                Provider<Boolean> insertClientProvider;
                insertClientProvider = dataProviderFactory.insertClient(clientEntity, agentEntity);
                insertClientProvider.subscribe(new Provider.Subscriber<Boolean>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(Boolean result) {
                        emitter.onComplete();
                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new CompletableObserver() {
                @Override
                public void onSubscribe(@Nonnull Disposable d) {

                }

                @Override
                public void onComplete() {
                    presenter.onInsertClientDataSuccess();
                }

                @Override
                public void onError(@Nonnull Throwable e) {
                    presenter.onInsertClientDataError();
                }
            });
    }
}
