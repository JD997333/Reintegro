package com.reintegro.profuturo.app.domain.interactor;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.GreetingContract;
import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.data.entity.BranchOfficeEntity;
import com.reintegro.profuturo.app.data.entity.LocationEntity;
import com.reintegro.profuturo.app.data.factory.DataProviderFactory;
import com.reintegro.profuturo.app.data.factory.LocationProviderFactory;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.provider.Provider;
import com.reintegro.profuturo.app.data.repository.AgentRepository;
import com.reintegro.profuturo.app.data.util.AgentUtils;
import com.reintegro.profuturo.app.domain.converter.AgentConverter;
import com.reintegro.profuturo.app.domain.converter.BranchOfficeConverter;
import com.reintegro.profuturo.app.domain.dto.BranchOfficeDto;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GreetingInteractor extends InteractorBase<GreetingContract.Presenter> implements GreetingContract.Interactor {
    private DataProviderFactory dataProviderFactory;
    private LocationEntity locationEntity;
    private LocationProviderFactory locationProviderFactory;
    private RepositoryFactory repositoryFactory;

    public GreetingInteractor(DataProviderFactory dataProviderFactory, LocationProviderFactory locationProviderFactory, RepositoryFactory repositoryFactory) {
        this.dataProviderFactory = dataProviderFactory;
        this.locationProviderFactory = locationProviderFactory;
        this.repositoryFactory = repositoryFactory;
    }

    @Override
    public void getAgentInformation() {
        Single
            .create((SingleEmitter<AgentEntity> emitter) -> {
                AgentRepository agentRepository;
                agentRepository = repositoryFactory.createAgentRepository();

                emitter.onSuccess(agentRepository.getFirst());
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<AgentEntity>() {
                @Override
                public void onError(Throwable exception) {

                }

                @Override
                public void onSubscribe(Disposable disposable) {

                }

                @Override
                public void onSuccess(AgentEntity agentEntity) {
                    presenter.onGetAgentInformationSuccess(AgentConverter.convertFromEntity(agentEntity));
                }
            });
    }

    @Override
    public void getAgentAssignedBranchOffice() {
        Completable
            .create((CompletableEmitter emitter) -> {
                AgentRepository agentRepository;
                agentRepository = repositoryFactory.createAgentRepository();

                Provider<AgentEntity> agentAssignedBranchOfficeProvider;
                agentAssignedBranchOfficeProvider = dataProviderFactory.createGetAgentAssignedBranchOfficeProvider(agentRepository.getFirst());
                agentAssignedBranchOfficeProvider.subscribe(new Provider.Subscriber<AgentEntity>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(AgentEntity result) {
                        AgentRepository agentRepository;
                        agentRepository = repositoryFactory.createAgentRepository();

                        AgentEntity agentEntity;
                        agentEntity = agentRepository.getFirst();
                        agentEntity = AgentUtils.mergeAgentAssignedBranchOffice(agentEntity, result);

                        agentRepository.update(agentEntity);

                        emitter.onComplete();
                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new CompletableObserver() {
                @Override
                public void onComplete() {
                    presenter.onGetAgentAssignedBranchOfficeSuccess();
                }

                @Override
                public void onError(Throwable exception) {
                    presenter.onGetAgentAssignedBranchOfficeError();
                }

                @Override
                public void onSubscribe(Disposable disposable) {

                }
            });
    }

    @Override
    public void getBranchOffices() {
        Single
            .create((SingleEmitter<List<BranchOfficeEntity>> emitter) -> {
                AgentRepository agentRepository;
                agentRepository = repositoryFactory.createAgentRepository();

                Provider<List<BranchOfficeEntity>> branchOfficeProvider;
                branchOfficeProvider = dataProviderFactory.createGetBranchOfficesProvider(agentRepository.getFirst(), locationEntity);
                branchOfficeProvider.subscribe(new Provider.Subscriber<List<BranchOfficeEntity>>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(List<BranchOfficeEntity> result) {
                        emitter.onSuccess(result);
                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<List<BranchOfficeEntity>>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull List<BranchOfficeEntity> branchOfficeEntities) {
                    presenter.onGetBranchOfficesSuccess(BranchOfficeConverter.convertFromEntities(branchOfficeEntities));
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onGetBranchOfficesError();
                }
            });
    }

    @Override
    public void getDeviceLocation() {
        Completable
            .create((CompletableEmitter emitter) -> {
                Provider<LocationEntity> locationProvider;
                locationProvider = locationProviderFactory.createLocationProvider();
                locationProvider.subscribe(new Provider.Subscriber<LocationEntity>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(LocationEntity result) {
                        locationEntity = result;
                        emitter.onComplete();
                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new CompletableObserver() {
                @Override
                public void onComplete() {
                    presenter.onGetDeviceLocationSuccess();
                }

                @Override
                public void onError(Throwable exception) {
                    presenter.onGetDeviceLocationError();
                }

                @Override
                public void onSubscribe(Disposable disposable) {

                }
            });
    }

    @Override
    public void saveLogin() {
        Completable
            .create((CompletableEmitter emitter) -> {
                AgentRepository agentRepository;
                agentRepository = repositoryFactory.createAgentRepository();

                Provider<Boolean> saveLoginProvider;
                saveLoginProvider = dataProviderFactory.createSaveLogin(agentRepository.getFirst());
                saveLoginProvider.subscribe(new Provider.Subscriber<Boolean>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(Boolean result) {
                        if(result){
                            emitter.onComplete();
                        }else{
                            emitter.onError(new Exception());
                        }
                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new CompletableObserver() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onComplete() {
                    presenter.onSaveLoginSuccess();
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onSaveLoginError();
                }
            });
    }

    @Override
    public void validateAgentAssignedBranchOffice(List<BranchOfficeDto> branchOfficeDtos) {
        Single
            .create((SingleEmitter<Integer> emitter) -> {
                AgentRepository agentRepository;
                agentRepository = repositoryFactory.createAgentRepository();

                for (int position = 0; position <= branchOfficeDtos.size(); position ++ ) {
                    BranchOfficeEntity branchOfficeEntity = BranchOfficeConverter.convertFromDto(branchOfficeDtos.get(position));

                    if (branchOfficeEntity.getBranchOfficeName().equals(agentRepository.getFirst().getBranchOfficeName())) {
                        AgentEntity agentEntity;
                        agentEntity = AgentUtils.mergeAgentAssignedBranchOffice(agentRepository.getFirst(), branchOfficeEntity);

                        agentRepository.update(agentEntity);

                        emitter.onSuccess(position);

                        break;
                    }
                }

                emitter.onError(new Throwable());
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<Integer>() {
                @Override
                public void onError(Throwable exception) {
                    presenter.onValidateAgentAssignedBranchOfficeError();
                }

                @Override
                public void onSubscribe(Disposable disposable) {

                }

                @Override
                public void onSuccess(Integer position) {
                    presenter.onValidateAgentAssignedBranchOfficeSuccess(position);
                }
            });
    }

    @Override
    public void updateAgentAssignedBranchOffice(BranchOfficeDto branchOfficeDto) {
        Completable
            .create((CompletableEmitter emitter) -> {
                AgentRepository agentRepository;
                agentRepository = repositoryFactory.createAgentRepository();

                BranchOfficeEntity branchOfficeEntity;
                branchOfficeEntity = BranchOfficeConverter.convertFromDto(branchOfficeDto);

                AgentEntity agentEntity;
                agentEntity = AgentUtils.mergeAgentAssignedBranchOffice(agentRepository.getFirst(), branchOfficeEntity);

                agentRepository.update(agentEntity);
            })
            .subscribeOn(Schedulers.computation())
            .subscribe();
    }
}
