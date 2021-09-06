package com.reintegro.profuturo.app.domain.interactor;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;

import com.reintegro.profuturo.app.BuildConfig;
import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.BiometricCaptureContract;
import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.FingerPrintEntity;
import com.reintegro.profuturo.app.data.entity.ProcedureEntity;
import com.reintegro.profuturo.app.data.factory.DataProviderFactory;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.provider.Provider;
import com.reintegro.profuturo.app.data.repository.AgentRepository;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.data.repository.ProcedureRepository;
import com.reintegro.profuturo.app.domain.converter.AgentConverter;
import com.reintegro.profuturo.app.domain.converter.ClientConverter;
import com.reintegro.profuturo.app.domain.converter.FingerPrintConverter;
import com.reintegro.profuturo.app.domain.converter.ProcedureConverter;
import com.reintegro.profuturo.app.domain.dto.FingerPrintDto;
import com.reintegro.profuturo.app.domain.dto.ProcedureDto;
import com.reintegro.profuturo.app.util.BiometricEngineUtils;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.util.DateUtils;
import com.reintegro.profuturo.app.util.TypeUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BiometricCaptureInteractor extends InteractorBase<BiometricCaptureContract.Presenter> implements BiometricCaptureContract.Interactor {
    private RepositoryFactory repositoryFactory;
    private DataProviderFactory dataProviderFactory;
    private Context context;

    public BiometricCaptureInteractor(RepositoryFactory repositoryFactory, DataProviderFactory dataProviderFactory, Context context) {
        this.repositoryFactory = repositoryFactory;
        this.dataProviderFactory = dataProviderFactory;
        this.context = context;
    }

    @Override
    public void getClientData() {
        ClientRepository clientRepository = repositoryFactory.createClientRepository();
        ClientEntity clientEntity = clientRepository.getSelected();
        presenter.onGetClientDataSuccess(ClientConverter.convertFromEntity(clientEntity));
    }

    @Override
    public void getAgentData() {
        AgentRepository agentRepository = repositoryFactory.createAgentRepository();
        AgentEntity agentEntity = agentRepository.getFirst();
        presenter.onGetAgentDataSuccess(AgentConverter.convertFromEntity(agentEntity));
    }

    @Override
    public void getRecommendedFingers() {
        Single
            .create((SingleEmitter<String> emitter) -> {
                ClientRepository clientRepository = repositoryFactory.createClientRepository();
                Provider<String> getRecommendedFingersProvider;
                getRecommendedFingersProvider = dataProviderFactory.createGetRecommendedFingersProvider(clientRepository.getSelected());

                getRecommendedFingersProvider.subscribe(new Provider.Subscriber<String>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(String result) {
                        emitter.onSuccess(result);
                    }
                });

            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<String>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull String s) {
                    presenter.onGetRecommendedFingersSuccess(s);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onGetRecommendedFingersError();
                }
            });
    }

    @Override
    public void readFingerPrints() {
        Single
            .create((SingleEmitter<List<FingerPrintEntity>> emitter) -> {
                ClientRepository clientRepository = repositoryFactory.createClientRepository();
                ClientEntity clientEntity = clientRepository.getSelected();

                AgentRepository agentRepository = repositoryFactory.createAgentRepository();
                AgentEntity agentEntity = agentRepository.getFirst();

                List<FingerPrintEntity> fingerPrintList = new ArrayList<>();
                FingerPrintEntity fingerPrintEntity;

                Uri uri = BiometricEngineUtils.buildEmployeeWorkerUriQuery(BuildConfig.APPLICATION_ID, Constants.EXTRA_BIOMETRIC_OP_FOUR_FINGERS, clientEntity.getCurp(), agentEntity.getAgentCode());
                Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);

                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    do{
                        fingerPrintEntity = new FingerPrintEntity();
                        String captureDate = cursor.getString(cursor.getColumnIndex(Constants.CONTRACT_BIO_ENGINE_CAPTURE_DATE));
                        Long absenceReasonCode = TypeUtils.getLongValueOrDefault(cursor.getString(cursor.getColumnIndex(Constants.CONTRACT_BIO_ENGINE_ABSENCE_REASON)));
                        DecimalFormat absenceFormat = new DecimalFormat("000");

                        fingerPrintEntity.setAbsenceReason(absenceFormat.format(absenceReasonCode));
                        fingerPrintEntity.setBase64Image(cursor.getString(cursor.getColumnIndex(Constants.CONTRACT_BIO_ENGINE_IMAGE)));
                        fingerPrintEntity.setIsEmployee(cursor.getInt(Constants.CONTRACT_BIO_ENGINE_EMPLOYEE_ID));
                        fingerPrintEntity.setFingerPositionCode(cursor.getInt(cursor.getColumnIndex(Constants.CONTRACT_BIO_ENGINE_FINGER_POSITION)));
                        fingerPrintEntity.setImageHashValue(cursor.getString(cursor.getColumnIndex(Constants.CONTRACT_BIO_ENGINE_ENCRYPTED_WSQ)));
                        fingerPrintEntity.setNistQualityMeasure(cursor.getString(cursor.getColumnIndex(Constants.CONTRACT_BIO_ENGINE_QUALITY)));
                        fingerPrintEntity.setSerialNumber(cursor.getString(cursor.getColumnIndex(Constants.CONTRACT_BIO_ENGINE_SERIAL_NUMBER)));
                        fingerPrintEntity.setCaptureDate(DateUtils.parseDate(Constants.DATE_FORMAT_3, Constants.DATE_FORMAT_7, captureDate));

                        fingerPrintList.add(fingerPrintEntity);
                    }while (cursor.moveToNext());

                    cursor.close();

                    emitter.onSuccess(fingerPrintList);
                }else {
                    emitter.onError(new Throwable());
                }
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<List<FingerPrintEntity>>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull List<FingerPrintEntity> fingerPrintEntityList) {
                    presenter.onReadFingerPrintsSuccess(FingerPrintConverter.convertFromEntities(fingerPrintEntityList));
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onReadFingerPrintError();
                }
            });
    }

    @Override
    public void getVoluntarySeal(List<FingerPrintDto> fingerPrintDtoList) {
        Single
            .create((SingleEmitter<ProcedureEntity> emitter) ->{
                ClientRepository clientRepository = repositoryFactory.createClientRepository();
                ClientEntity clientEntity = clientRepository.getSelected();

                AgentRepository agentRepository = repositoryFactory.createAgentRepository();
                AgentEntity agentEntity = agentRepository.getFirst();

                ProcedureRepository procedureRepository = repositoryFactory.createProcedureRepository();
                ProcedureEntity procedureEntity = procedureRepository.getFirst();

                List<FingerPrintEntity> fingerPrintEntities = FingerPrintConverter.convertFromDtos(fingerPrintDtoList);

                Provider<ProcedureEntity> getVoluntarySealProvider;
                getVoluntarySealProvider = dataProviderFactory.createGetVoluntarySealProvider(clientEntity, agentEntity, procedureEntity, fingerPrintEntities);
                getVoluntarySealProvider.subscribe(new Provider.Subscriber<ProcedureEntity>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(ProcedureEntity procedureResult) {
                        procedureEntity.setVoluntarySeal(procedureResult.getVoluntarySeal());
                        procedureEntity.setIdStatusVoluntarySeal(Constants.REQUEST_BIOMETRIC_VOLUNTARY_SEAL_STATUS);
                        procedureEntity.setVerificationResultSeal(procedureResult.getVerificationResultSeal());
                        procedureRepository.update(procedureEntity);
                        emitter.onSuccess(procedureEntity);
                    }
                });

            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<ProcedureEntity>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull ProcedureEntity procedureEntity) {
                    saveVoluntarySeal(ProcedureConverter.convertFromEntity(procedureEntity));
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    presenter.onGetVoluntarySealError();
                }
            });
    }

    @Override
    public void saveVoluntarySeal(ProcedureDto procedureDto) {
        presenter.onSaveVoluntarySealSuccess();
    }
}
