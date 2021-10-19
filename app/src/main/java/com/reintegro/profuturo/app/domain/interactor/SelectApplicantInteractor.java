package com.reintegro.profuturo.app.domain.interactor;

import androidx.annotation.NonNull;

import com.reintegro.profuturo.app.api.converter.DateResponseConverter;
import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.SelectApplicantContract;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.ProcedureEntity;
import com.reintegro.profuturo.app.data.factory.DataProviderFactory;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.provider.Provider;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.data.repository.ProcedureRepository;
import com.reintegro.profuturo.app.domain.converter.ClientConverter;
import com.reintegro.profuturo.app.domain.converter.ProcedureConverter;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.ProcedureDto;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.util.DateUtils;
import com.reintegro.profuturo.app.vo.ApplicantType;
import com.reintegro.profuturo.app.vo.CoexistenceResult;
import com.reintegro.profuturo.app.vo.ValidateFolioResult;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SelectApplicantInteractor extends InteractorBase<SelectApplicantContract.Presenter> implements SelectApplicantContract.Interactor {
    private RepositoryFactory repositoryFactory;
    private DataProviderFactory dataProviderFactory;

    public SelectApplicantInteractor(RepositoryFactory repositoryFactory, DataProviderFactory dataProviderFactory){
        this.repositoryFactory = repositoryFactory;
        this.dataProviderFactory = dataProviderFactory;
    }

    @Override
    public void updateProcedureData(String applicantType, String applicantCurp, String authFolio) {
        ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
        ProcedureEntity procedureEntity = procedureRepository.getFirst();

        procedureEntity.setIdApplicantType(Integer.parseInt(applicantType));
        procedureEntity.setApplicantCurp(applicantCurp);
        procedureEntity.setAuthFolio(authFolio);

        procedureEntity = procedureRepository.update(procedureEntity);

        presenter.onUpdateProcedureSuccess(ProcedureConverter.convertFromEntity(procedureEntity));
    }

    @Override
    public void updateAuthFolioDB(String authFolio) {
        ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
        ProcedureEntity procedureEntity = procedureRepository.getFirst();

        procedureEntity.setAuthFolio(authFolio);
        procedureRepository.update(procedureEntity);

        presenter.onUpdateAuthFolioDBSuccess();
    }

    @Override
    public void getClientDataDB() {
        ClientRepository clientRepository = repositoryFactory.createClientRepository();
        ClientEntity clientEntity = clientRepository.getSelected();

        presenter.onGetClientDataSuccess(ClientConverter.convertFromEntity(clientEntity));
    }

    @Override
    public void getApplicantTypes() {
        Single
            .create((SingleEmitter<List<ApplicantType>> emitter) -> {
                ClientRepository clientRepository = repositoryFactory.createClientRepository();
                ClientEntity clientEntity = clientRepository.getSelected();

                ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
                ProcedureEntity procedureEntity = procedureRepository.getFirst();

                Provider<List<ApplicantType>> getApplicantTypesProvider;
                getApplicantTypesProvider = dataProviderFactory.getApplicantTypes(clientEntity, procedureEntity);

                getApplicantTypesProvider.subscribe(new Provider.Subscriber<List<ApplicantType>>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(List<ApplicantType> result) {
                        emitter.onSuccess(result);
                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<List<ApplicantType>>() {
                @Override
                public void onSubscribe(@Nonnull Disposable d) {

                }

                @Override
                public void onSuccess(@Nonnull List<ApplicantType> applicantTypes) {
                    presenter.onGetApplicantTypesSuccess(applicantTypes);
                }

                @Override
                public void onError(@Nonnull Throwable e) {
                    presenter.onGetApplicantTypesError();
                }
            });
    }

    @Override
    public void getClientDataProcesar() {
        Single
            .create((SingleEmitter<ClientEntity> emitter) -> {
                ClientRepository clientRepository = repositoryFactory.createClientRepository();
                ClientEntity clientEntity = clientRepository.getSelected();

                Provider<HashMap<String, String>> getClientProcesarProvider;
                getClientProcesarProvider = dataProviderFactory.getClientDataOP360(clientEntity);
                getClientProcesarProvider.subscribe(new Provider.Subscriber<HashMap<String, String>>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(HashMap<String, String> result) {
                        clientEntity.setBiometricIndicatorValue(Integer.parseInt(result.get(Constants.KEY_BIOMETRIC_STATUS)));
                        clientEntity.setIdentificationIndicatorValue(Integer.parseInt(result.get(Constants.KEY_IDENTIFICATION_STATUS)));
                        emitter.onSuccess(clientEntity);
                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<ClientEntity>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull ClientEntity clientEntity) {
                    presenter.onGetClientDataProcesarSuccess(ClientConverter.convertFromEntity(clientEntity));
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onGetClientDataProcesarError();
                }
            });
    }

    @Override
    public void saveFirstProcedureData() {
        ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
        ProcedureEntity procedureEntity = new ProcedureEntity();

        procedureEntity.setApplicantCurp("");
        procedureEntity.setAuthFolio("");
        procedureEntity.setIdApplicantType(0);
        procedureEntity.setIdChannel(Constants.APPLICATION_CHANNEL_ID.toString());
        procedureEntity.setIdChannelStage(Constants.APPLICATION_CHANNEL_ID);
        procedureEntity.setIdProcess(Constants.ID_PROCESS);
        procedureEntity.setIdStage(Constants.ID_STAGE_RECEPTION);
        procedureEntity.setIdSubProcess(Constants.ID_SUB_PROCESS);
        procedureEntity.setIdSubStage(Constants.ID_SUB_STAGE_CAPTURE);
        procedureEntity.setProcedureDate(DateResponseConverter.convertFromResponse(DateUtils.getToday(), "yyyy-MM-dd"));
        procedureEntity.setProcedureFolio("");
        procedureEntity.setBinnacleFolio("");

        procedureRepository.add(procedureEntity);

        procedureEntity = procedureRepository.getFirst();

        presenter.onSaveFirstProcedureData(ProcedureConverter.convertFromEntity(procedureEntity));
    }

    @Override
    public void valCoexistenceNci() {
        Single
            .create((SingleEmitter<CoexistenceResult> emitter) -> {
                ClientRepository clientRepository = repositoryFactory.createClientRepository();
                ClientEntity clientEntity = clientRepository.getSelected();

                Provider<CoexistenceResult> valCoexistenceProvider = dataProviderFactory.createValCoexistenceNciProvider(clientEntity);
                valCoexistenceProvider.subscribe(new Provider.Subscriber<CoexistenceResult>() {
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
                public void onSubscribe(@Nonnull Disposable d) {

                }

                @Override
                public void onSuccess(@Nonnull CoexistenceResult result) {
                    presenter.onValCoexistenceNciSuccess(result);
                }

                @Override
                public void onError(@Nonnull Throwable e) {
                    presenter.onValCoexistenceNciError();
                }
            });
    }

    @Override
    public void validateCurp() {
        ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
        ProcedureEntity procedureEntity = procedureRepository.getFirst();

        String curp = procedureEntity.getApplicantCurp();

        ClientRepository clientRepository = repositoryFactory.createClientRepository();
        ClientEntity clientEntity = clientRepository.getSelected();

        if (curp != null && !curp.isEmpty() && curp.length() == Constants.LENGTH_CURP){
            Pattern pattern = Pattern.compile(Constants.REGULAR_EXPRESSION_VALIDATE_CURP);
            if (pattern.matcher(curp).matches()){
                if (procedureEntity.getIdApplicantType().equals(Constants.ID_OWNER_APPLICANT)){
                    presenter.onValidateCurpSuccess(ProcedureConverter.convertFromEntity(procedureEntity));
                }else {
                    if (!curp.equals(clientEntity.getCurp())){
                        presenter.onValidateCurpSuccess(ProcedureConverter.convertFromEntity(procedureEntity));
                    }else {
                        presenter.onValidateCurpError();
                    }
                }
            } else{
                presenter.onValidateCurpError();
            }
        }else {
            presenter.onValidateCurpError();
        }
    }

    @Override
    public void validateAuthFolio(String folio) {
        Single
            .create((SingleEmitter<ValidateFolioResult> emitter) ->{
                ClientRepository clientRepository = repositoryFactory.createClientRepository();
                ClientEntity clientEntity = clientRepository.getSelected();

                ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
                ProcedureEntity procedureEntity = procedureRepository.getFirst();
                procedureEntity.setAuthFolio(folio);

                Provider<ValidateFolioResult> validateFolioResultProvider;
                validateFolioResultProvider = dataProviderFactory.createValidateAuthFolioProvider(clientEntity, procedureEntity);
                validateFolioResultProvider.subscribe(new Provider.Subscriber<ValidateFolioResult>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(ValidateFolioResult result) {
                        emitter.onSuccess(result);
                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<ValidateFolioResult>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull ValidateFolioResult validateFolioResult) {
                    presenter.onValidateAuthFolioSuccess(validateFolioResult.isSuccess(), folio);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onValidateAuthFolioError();
                }
            });
    }
}

//aqui se hace toda la logica
