package com.reintegro.profuturo.app.domain.interactor;

import android.os.AsyncTask;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.MainContract;
import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.data.factory.DataProviderFactory;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.provider.Provider;
import com.reintegro.profuturo.app.data.repository.AgentRepository;
import com.reintegro.profuturo.app.domain.converter.AgentConverter;
import com.reintegro.profuturo.app.domain.dto.AgentDto;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainInteractor extends InteractorBase<MainContract.Presenter> implements MainContract.Interactor {
    private DataProviderFactory dataProviderFactory;
    private RepositoryFactory repositoryFactory;

    public MainInteractor(DataProviderFactory dataProviderFactory, RepositoryFactory repositoryFactory) {
        this.dataProviderFactory = dataProviderFactory;
        this.repositoryFactory = repositoryFactory;
    }

    @Override
    public void getAgentInformation(AgentDto agentDto) {
        /*Runnable runnable = () -> {
                Provider<AgentEntity> agentInformationProvider;
                agentInformationProvider = dataProviderFactory.createGetAgentInformationProvider(AgentConverter.convertFromDto(agentDto));
                agentInformationProvider.subscribe(new Provider.Subscriber<AgentEntity>() {
                    @Override
                    public void onError(Throwable exception) {
                        presenter.onGetAgentInformationError();
                    }

                    @Override
                    public void onSuccess(AgentEntity result) {
                        AgentRepository agentRepository = repositoryFactory.createAgentRepository();
                        agentRepository.clear();
                        agentRepository.add(result);

                        presenter.onGetAgentInformationSuccess(AgentConverter.convertFromEntity(result));
                    }
                });
        };
        new Thread(runnable).start();*/
        //new SimpleTask().execute(agentDto);

        Single
            .create((SingleEmitter<AgentEntity> emitter) -> {
                Provider<AgentEntity> agentInformationProvider;
                agentInformationProvider = dataProviderFactory.createGetAgentInformationProvider(AgentConverter.convertFromDto(agentDto));
                agentInformationProvider.subscribe(new Provider.Subscriber<AgentEntity>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(AgentEntity result) {
                        AgentRepository agentRepository = repositoryFactory.createAgentRepository();
                        agentRepository.clear();
                        agentRepository.add(result);
                        emitter.onSuccess(result);

                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<AgentEntity>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull AgentEntity agentEntity) {
                    presenter.onGetAgentInformationSuccess(AgentConverter.convertFromEntity(agentEntity));
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onGetAgentInformationError();
                }
            });


    }

    /*class SimpleTask extends AsyncTask<AgentDto, Void, String>{
        @Override
        protected String doInBackground(AgentDto... agentDtos) {
            Provider<AgentEntity> agentInformationProvider;
            agentInformationProvider = dataProviderFactory.createGetAgentInformationProvider(AgentConverter.convertFromDto(agentDtos.clone()[0]));
            agentInformationProvider.subscribe(new Provider.Subscriber<AgentEntity>() {
                @Override
                public void onError(Throwable exception) {
                    presenter.onGetAgentInformationError();
                }

                @Override
                public void onSuccess(AgentEntity result) {
                    AgentRepository agentRepository = repositoryFactory.createAgentRepository();
                    agentRepository.clear();
                    agentRepository.add(result);

                    presenter.onGetAgentInformationSuccess(AgentConverter.convertFromEntity(result));
                }
            });
            return null;
        }
    }*/
}
