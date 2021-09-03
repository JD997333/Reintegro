package com.reintegro.profuturo.app.domain.interactor;

import androidx.annotation.NonNull;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.DocumentsCaptureContract;
import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.DocumentEntity;
import com.reintegro.profuturo.app.data.entity.ProcedureEntity;
import com.reintegro.profuturo.app.data.factory.DataProviderFactory;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.provider.Provider;
import com.reintegro.profuturo.app.data.repository.AgentRepository;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.data.repository.DocumentRepository;
import com.reintegro.profuturo.app.data.repository.ProcedureRepository;
import com.reintegro.profuturo.app.data.repository.RepaymentEventRepository;
import com.reintegro.profuturo.app.domain.converter.ClientConverter;
import com.reintegro.profuturo.app.domain.converter.DocumentConverter;
import com.reintegro.profuturo.app.domain.dto.DocumentDto;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.util.Utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DocumentsCaptureInteractor extends InteractorBase<DocumentsCaptureContract.Presenter> implements DocumentsCaptureContract.Interactor {
    private RepositoryFactory repositoryFactory;
    private DataProviderFactory dataProviderFactory;

    public DocumentsCaptureInteractor(RepositoryFactory repositoryFactory, DataProviderFactory dataProviderFactory) {
        this.repositoryFactory = repositoryFactory;
        this.dataProviderFactory = dataProviderFactory;
    }


    @Override
    public void getClientData() {
        Single
            .create((SingleEmitter<ClientEntity> emitter) ->{
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
                ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
                ProcedureEntity procedureEntity = procedureRepository.getFirst();

                Provider<List<DocumentEntity>> getDocumentsProvider;
                getDocumentsProvider = dataProviderFactory.createGetDocumentsProvider(procedureEntity.getIdProcess(), procedureEntity.getIdApplicantType(), procedureEntity.getIdSubProcess());
                getDocumentsProvider.subscribe(new Provider.Subscriber<List<DocumentEntity>>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(List<DocumentEntity> result) {
                        AgentEntity agentEntity;
                        agentEntity = repositoryFactory.createAgentRepository().getFirst();

                        ClientEntity clientEntity;
                        clientEntity = repositoryFactory.createClientRepository().getSelected();

                        DocumentRepository documentRepository = repositoryFactory.createDocumentRepository();
                        documentRepository.clear();

                        List<DocumentEntity> documentsResult;
                        documentsResult = documentRepository.addAll(result);

                        HashMap<String,String> signatureHolders;

                        for (DocumentEntity document : documentsResult) {
                            switch (document.getDocumentKey()) {
                                case Constants.DOCUMENT_KEY_REPAYMENT_SOLICITUDE:
                                    signatureHolders = new HashMap<>();
                                    signatureHolders.put(agentEntity.getFullName(), "");
                                    signatureHolders.put(clientEntity.getFullName(), "");

                                    document.setDocumentType(Constants.DOCUMENT_TYPE_PDF);
                                    document.setSignatureHolders(signatureHolders);
                                    break;

                                case Constants.DOCUMENT_KEY_REPAYMENT_LETTER:
                                    signatureHolders = new HashMap<>();
                                    signatureHolders.put(agentEntity.getFullName(), "");
                                    signatureHolders.put(agentEntity.getFullName(), "");

                                    document.setDocumentType(Constants.DOCUMENT_TYPE_PDF);
                                    document.setSignatureHolders(signatureHolders);
                                    break;

                                default:
                                    document.setDocumentType(Constants.DOCUMENT_TYPE_PHOTO);
                                    break;
                            }
                        }
                        emitter.onSuccess(documentsResult);
                    }
                });

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
                    presenter.onGetDocumentsError();
                }
            });
    }

    @Override
    public void buildLetterDocument(DocumentDto documentDto) {
        Single
            .create((SingleEmitter<DocumentEntity> emitter) -> {
                ClientRepository clientRepository = repositoryFactory.createClientRepository();
                ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
                RepaymentEventRepository repaymentEventRepository = repositoryFactory.createRepaymentEventRepository();

                Provider<String> getLetterDocumentProvider;
                getLetterDocumentProvider = dataProviderFactory.createGetLetterRepaymentDocProvider(
                    clientRepository.getSelected(),
                    procedureRepository.getFirst(),
                    repaymentEventRepository.getSelected()
                );

                getLetterDocumentProvider.subscribe(new Provider.Subscriber<String>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(String result) {
                        DocumentEntity documentEntity;
                        documentEntity = DocumentConverter.convertFromDto(documentDto);

                        File file;
                        file= Utils.decodeBase64(result, documentEntity.getDocumentName());
                        documentEntity.setFile(file);
                        emitter.onSuccess(documentEntity);
                    }
                });

            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<DocumentEntity>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull DocumentEntity documentEntity) {
                    documentDto.setFile(documentEntity.getFile());
                    presenter.onBuildLetterDocumentSuccess(documentDto);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onBuildLetterDocumentError();
                }
            });
    }

    @Override
    public void buildSolicitudeDocument(DocumentDto documentDto) {
        Single
            .create((SingleEmitter<DocumentEntity> emitter) -> {
                AgentRepository agentRepository = repositoryFactory.createAgentRepository();
                ClientRepository clientRepository = repositoryFactory.createClientRepository();
                ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
                RepaymentEventRepository repaymentEventRepository = repositoryFactory.createRepaymentEventRepository();

                DocumentEntity documentEntity = DocumentConverter.convertFromDto(documentDto);

                Provider<String> getSolicitudeDocProvider;
                getSolicitudeDocProvider = dataProviderFactory.createGetRepaymentSolicitudeDocProvider(
                    agentRepository.getFirst(),
                    clientRepository.getSelected(),
                    procedureRepository.getFirst(),
                    documentEntity,
                    repaymentEventRepository.getSelected()
                );

                getSolicitudeDocProvider.subscribe(new Provider.Subscriber<String>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(String result) {
                        File file;
                        file= Utils.decodeBase64(result, documentEntity.getDocumentName());
                        documentEntity.setFile(file);
                        emitter.onSuccess(documentEntity);
                    }
                });

            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<DocumentEntity>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull DocumentEntity documentEntity) {
                    documentDto.setFile(documentEntity.getFile());
                    presenter.onBuildSolicitudeDocumentSuccess(documentDto);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onBuildSolicitudeDocumentError();
                }
            });
    }

    @Override
    public void validateRequiredDocuments(List<DocumentDto> documentDtos) {
        Completable
            .create((CompletableEmitter emitter) -> {
                boolean hasRequiredDocuments = true;

                for (DocumentDto documentDto : documentDtos) {
                    if (!documentDto.isCaptured() && documentDto.isRequiredByProfuturo()) {
                        hasRequiredDocuments = false;
                    }
                }

                if (hasRequiredDocuments) {
                    saveDocuments(documentDtos);
                } else {
                    emitter.onError(new Throwable());
                }
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new CompletableObserver() {
                @Override
                public void onComplete() {

                }

                @Override
                public void onError(Throwable exception) {
                    presenter.validateRequiredDocumentError();
                }

                @Override
                public void onSubscribe(Disposable disposable) {

                }
            });
    }

    @Override
    public void saveDocuments(List<DocumentDto> documents) {
        Completable
            .create((CompletableEmitter emitter) -> {
                DocumentRepository documentRepository;
                documentRepository = repositoryFactory.createDocumentRepository();
                documentRepository.updateAll(DocumentConverter.convertFromDtos(documents));

                emitter.onComplete();
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new CompletableObserver() {
                @Override
                public void onComplete() {
                    presenter.onSaveDocumentsSuccess();
                }

                @Override
                public void onError(Throwable exception) {

                }

                @Override
                public void onSubscribe(Disposable disposable) {

                }
            });
    }
}
