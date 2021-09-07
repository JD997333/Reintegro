package com.reintegro.profuturo.app.domain.interactor;

import androidx.annotation.NonNull;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.SaveProcedureContract;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.DocumentEntity;
import com.reintegro.profuturo.app.data.factory.DataProviderFactory;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.data.repository.DocumentRepository;
import com.reintegro.profuturo.app.domain.converter.ClientConverter;
import com.reintegro.profuturo.app.domain.converter.DocumentConverter;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SaveProcedureInteractor extends InteractorBase<SaveProcedureContract.Presenter> implements SaveProcedureContract.Interactor {
    private RepositoryFactory repositoryFactory;
    private DataProviderFactory dataProviderFactory;

    public SaveProcedureInteractor(RepositoryFactory repositoryFactory, DataProviderFactory dataProviderFactory) {
        this.repositoryFactory = repositoryFactory;
        this.dataProviderFactory = dataProviderFactory;
    }

    @Override
    public void getClientData() {
        Single
            .create((SingleEmitter<ClientEntity> emitter) -> {
                ClientRepository clientRepository = repositoryFactory.createClientRepository();
                emitter.onSuccess(clientRepository.getSelected());
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<ClientEntity>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull ClientEntity clientEntity) {
                    presenter.onGetClientDataSuccess(ClientConverter.convertFromEntity(clientEntity));
                }

                @Override
                public void onError(@NonNull Throwable e) {

                }
            });
    }

    @Override
    public void getDocuments() {
        Single
            .create((SingleEmitter<List<DocumentEntity>> emitter) -> {
                DocumentRepository documentRepository = repositoryFactory.createDocumentRepository();
                emitter.onSuccess(documentRepository.getCaptured());
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<List<DocumentEntity>>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull List<DocumentEntity> documentEntities) {
                    presenter.onGetDocumentsSuccess(DocumentConverter.convertFromEntities(documentEntities));
                }

                @Override
                public void onError(@NonNull Throwable e) {

                }
            });
    }

    @Override
    public void markNciCoexistence() {

    }

    @Override
    public void sendEmail() {

    }

    @Override
    public void startBpmInstance() {

    }

    @Override
    public void uploadImagesFilenet() {

    }

    @Override
    public void updateProcedure() {

    }

    @Override
    public void closeBinnacle() {

    }
}
