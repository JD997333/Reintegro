package com.reintegro.profuturo.app.domain.interactor;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.ClientDataContract;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.factory.DataProviderFactory;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.provider.Provider;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.domain.converter.ClientConverter;
import com.reintegro.profuturo.app.util.ClientUtils;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ClientDataInteractor extends InteractorBase<ClientDataContract.Presenter> implements ClientDataContract.Interactor {
    private ClientEntity clientEntity;
    private ClientRepository clientRepository;

    private DataProviderFactory webServiceProviderFactory;

    public ClientDataInteractor(RepositoryFactory repositoryFactory, DataProviderFactory webServiceProviderFactory) {
        this.webServiceProviderFactory = webServiceProviderFactory;

        clientRepository = repositoryFactory.createClientRepository();
    }

    @Override
    public void getClient() {
        Single
            .create((SingleEmitter<ClientEntity> emitter)-> {
                clientEntity = clientRepository.getSelected();

                emitter.onSuccess(clientEntity);

                getClientImage();

            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<ClientEntity>() {
                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onSuccess(ClientEntity clientEntity) {
                    presenter.onGetClientSuccess(ClientConverter.convertFromEntity(clientEntity));
                }
            });
    }

    @Override
    public void getClientImage() {
        Single
            .create((SingleEmitter<ClientEntity> emitter)->{
                Provider<ClientEntity> clientImageProvider;
                clientImageProvider = webServiceProviderFactory.createGetClientImageProvider(clientEntity);
                clientImageProvider.subscribe(new Provider.Subscriber<ClientEntity>() {
                    @Override
                    public void onError(Throwable exception) {

                    }

                    @Override
                    public void onSuccess(ClientEntity result) {
                        clientEntity = ClientUtils.mergeClientImage(clientEntity, result);
                        clientEntity = clientRepository.update(clientEntity);

                        emitter.onSuccess(clientEntity);
                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<ClientEntity>() {
                @Override
                public void onError(Throwable error) {
                    presenter.onGetClientImageError();
                }

                @Override
                public void onSubscribe(Disposable disposable) {

                }

                @Override
                public void onSuccess(ClientEntity clientEntity) {
                    presenter.onGetClientImageSuccess(ClientConverter.convertFromEntity(clientEntity));
                }
            });
    }
}

