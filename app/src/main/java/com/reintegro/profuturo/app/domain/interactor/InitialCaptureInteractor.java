package com.reintegro.profuturo.app.domain.interactor;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.InitialCaptureContract;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.domain.converter.ClientConverter;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.util.Utils;

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
    public void getRepaymentEvents() {
        //TODO: Create dummy structure for simulate data
        presenter.onGetRepaymentEventsSuccess(Utils.getMockRepaymentEvents());
    }
}
