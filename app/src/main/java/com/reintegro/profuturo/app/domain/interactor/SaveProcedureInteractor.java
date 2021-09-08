package com.reintegro.profuturo.app.domain.interactor;

import androidx.annotation.NonNull;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.SaveProcedureContract;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.DocumentEntity;
import com.reintegro.profuturo.app.data.factory.DataProviderFactory;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.provider.Provider;
import com.reintegro.profuturo.app.data.repository.AgentRepository;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.data.repository.DocumentRepository;
import com.reintegro.profuturo.app.data.repository.ProcedureRepository;
import com.reintegro.profuturo.app.domain.converter.ClientConverter;
import com.reintegro.profuturo.app.domain.converter.DocumentConverter;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.vo.CoexistenceResult;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
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
        Single
            .create((SingleEmitter<CoexistenceResult> emitter) -> {
                ClientRepository clientRepository = repositoryFactory.createClientRepository();
                ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
                AgentRepository agentRepository = repositoryFactory.createAgentRepository();

                Provider<CoexistenceResult> markCoexistenceProvider;
                markCoexistenceProvider = dataProviderFactory.createMarkNciCoexistenceProvider(clientRepository.getSelected(), agentRepository.getFirst(), procedureRepository.getFirst());
                markCoexistenceProvider.subscribe(new Provider.Subscriber<CoexistenceResult>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(CoexistenceResult result) {
                        emitter.onSuccess(result);
                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<CoexistenceResult>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull CoexistenceResult coexistenceResult) {
                    presenter.onMarkNciCoexistenceSuccess(coexistenceResult);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onMarkNciCoexistenceError();
                }
            });
    }

    @Override
    public void sendEmail() {
        presenter.onSendEmailSuccess();
    }

    @Override
    public void startBpmInstance() {
        Completable
            .create((CompletableEmitter emitter) -> {
                ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();

                Provider<Boolean> startBpmInstanceProvider;
                startBpmInstanceProvider = dataProviderFactory.createStartBpmInstanceProvider(procedureRepository.getFirst());
                startBpmInstanceProvider.subscribe(new Provider.Subscriber<Boolean>() {
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
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onComplete() {
                    presenter.onStartBpmInstanceSuccess();
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onStartBpmInstanceError();
                }
            });
    }

    @Override
    public void uploadImagesFilenet() {
        Completable
            .create((CompletableEmitter emitter) -> {
                ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
                DocumentRepository documentRepository = repositoryFactory.createDocumentRepository();

                List<DocumentEntity> documents = documentRepository.getCaptured();

                Provider<Boolean> uploadImagesFilenetProvider;
                uploadImagesFilenetProvider = dataProviderFactory.createUploadFilesToFileNetProvider(procedureRepository.getFirst(), documents);
                uploadImagesFilenetProvider.subscribe(new Provider.Subscriber<Boolean>() {
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
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onComplete() {
                    presenter.onUploadImageFilenetSuccess();
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onUploadImageFilenetError();
                }
            });
    }

    @Override
    public void updateProcedure() {
        presenter.onUpdateProcedureSuccess();
        /*
        Completable
            .create((CompletableEmitter emitter) -> {
                AgentRepository agentRepository = repositoryFactory.createAgentRepository();
                ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();

                Provider<Boolean> updateProcedureProvider;
                updateProcedureProvider = dataProviderFactory.createUpdateProcedureProvider(agentRepository.getFirst(), procedureRepository.getFirst());
                updateProcedureProvider.subscribe(new Provider.Subscriber<Boolean>() {
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
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onComplete() {
                    presenter.onUpdateProcedureSuccess();
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onUpdateProcedureError();
                }
            });
         */
    }

    @Override
    public void closeBinnacle() {
        Completable
            .create((CompletableEmitter emitter) ->{
                ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
                AgentRepository agentRepository = repositoryFactory.createAgentRepository();

                Provider<Boolean> insertBinnacleProvider;
                insertBinnacleProvider = dataProviderFactory.createInsertBinnacleProvider(agentRepository.getFirst(), procedureRepository.getFirst());
                insertBinnacleProvider.subscribe(new Provider.Subscriber<Boolean>() {
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
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onComplete() {
                    presenter.onCloseBinnacleSuccess();
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onCloseBinnacleError();
                }
            });
    }

    @Override
    public void validateCellPhone(String cellPhone) {
        Completable
            .create((emitter) -> {
                if (cellPhone != null && !cellPhone.isEmpty()) {
                    Pattern pattern;
                    pattern = Pattern.compile(Constants.REGULAR_EXPRESSION_VALIDATE_CELL_PHONE);

                    Matcher matcher;
                    matcher = pattern.matcher(cellPhone);

                    if (matcher.matches()) {
                        emitter.onComplete();
                    } else {
                        emitter.onError(new Throwable());
                    }
                } else {
                    emitter.onError(new Throwable());
                }
            }).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new CompletableObserver() {
                @Override
                public void onComplete() {
                    presenter.onValidateCellPhoneSuccess();
                }

                @Override
                public void onError(Throwable exception) {
                    presenter.onValidateCellPhoneError();
                }

                @Override
                public void onSubscribe(Disposable disposable) {

                }
            });
    }

    @Override
    public void validateEmail(String email) {
        Completable
            .create((CompletableEmitter emitter) -> {
                if (email != null && !email.isEmpty()) {
                    Pattern pattern;
                    pattern = Pattern.compile(Constants.REGULAR_EXPRESSION_VALIDATE_EMAIL);

                    Matcher matcher;
                    matcher = pattern.matcher(email);

                    if (matcher.matches()) {
                        emitter.onComplete();
                    } else {
                        emitter.onError(new Throwable());
                    }
                } else {
                    emitter.onError(new Throwable());
                }

            }).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new CompletableObserver() {
                @Override
                public void onComplete() {
                    presenter.onValidateEmailSuccess();
                }

                @Override
                public void onError(Throwable exception) {
                    presenter.onValidateEmailError();
                }

                @Override
                public void onSubscribe(Disposable disposable) {

                }
            });
    }
}
