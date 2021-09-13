package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.SelectApplicantContract;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.ProcedureDto;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.vo.ApplicantType;
import com.reintegro.profuturo.app.vo.CoexistenceResult;

import java.util.ArrayList;
import java.util.List;

public class SelectApplicantPresenter
        extends PresenterBase<SelectApplicantContract.Interactor, SelectApplicantContract.State, SelectApplicantContract.View>
        implements SelectApplicantContract.Presenter{

    @Override
    public void resume() {
        view.showLoading();
        interactor.saveFirstProcedureData();
    }


    @Override
    public void onSaveFirstProcedureData(ProcedureDto procedureDto) {
        interactor.valCoexistenceNci();
    }

    @Override
    public void onValCoexistenceNciSuccess(CoexistenceResult result) {
        if (result.isCoexistenceSuccess()){
            interactor.getClientDataDB();
        }else {
            view.dismissLoading();
            view.showNoCoexistenceDialog(result.getCoexistenceMessage());
        }

    }

    @Override
    public void onValCoexistenceNciError() {
        view.dismissLoading();
        view.showCoexistenceServiceError();
    }

    @Override
    public void onGetClientDataSuccess(ClientDto clientDto) {
        //TODO set this just for TEST
        //clientDto.setBiometricIndicatorValue(Constants.BIOMETRIC_INDICATOR_STATUS_EXIST);
        //clientDto.setIdentificationIndicatorValue(Constants.IDENTIFICATION_INDICATOR_STATUS_ACTIVE);

        if (clientDto.getBiometricIndicatorValue() == Constants.BIOMETRIC_INDICATOR_STATUS_EXIST){
            view.showBiometricIndicatorTrue();
            state.setBiometricIndicatorEnabled(true);
        }else {
            view.showBiometricIndicatorFalse();
            state.setBiometricIndicatorEnabled(false);
        }

        if (clientDto.getIdentificationIndicatorValue() == Constants.IDENTIFICATION_INDICATOR_STATUS_ACTIVE){
            view.showIdentificationIndicatorTrue();
            state.setExpedientIndicatorEnabled(true);
        }else {
            view.showIdentificationIndicatorFalse();
            state.setExpedientIndicatorEnabled(false);
        }

        if (clientDto.getIdentificationIndicatorValue() == Constants.IDENTIFICATION_INDICATOR_STATUS_ACTIVE){
            view.setClientData(clientDto);
            view.setTitleMsgSuccess();
            interactor.getApplicantTypes();
        }else {
            view.setClientData(clientDto);
            view.setTitleMsgError();
            interactor.getApplicantTypes();
        }
    }

    @Override
    public void onValidateIndicatorsError() {

    }

    @Override
    public void onGetApplicantTypesSuccess(List<ApplicantType> applicantTypes) {
        List<ApplicantType> applicantTypesN = new ArrayList<>();
        applicantTypesN.add(new ApplicantType("",""));
        applicantTypesN.addAll(applicantTypes);

        view.showApplicantTypes(applicantTypes);
        view.dismissLoading();
    }

    @Override
    public void onGetApplicantTypesError() {
        view.showGetApplicantTypesError();
        view.dismissLoading();
    }

    @Override
    public void onRetryGetApplicants() {
        view.showLoading();
        interactor.getApplicantTypes();
    }

    @Override
    public void onApplicantSelected(ApplicantType applicantType, ClientDto clientDto) {
        if (!applicantType.getId().isEmpty()){
            if (applicantType.getId().equals(Constants.ID_OWNER_APPLICANT.toString())){
                view.showCurpTit(clientDto.getCurp());
            }else{
                view.showCurp(clientDto.getCurp());
            }
        }else {
            view.showCurp("");
        }
    }

    @Override
    public void onValCoexistenceRetry() {
        view.showLoading();
        interactor.valCoexistenceNci();
    }

    @Override
    public void onConfirmButtonClicked(String applicantType, String applicantCurp, String authFolio) {
        if (applicantType != null && !applicantType.isEmpty()){
            interactor.updateProcedureData(applicantType, applicantCurp, authFolio);
        }else {
            view.showSelectApplicantNecesaryMsg();
        }
    }

    @Override
    public void onUpdateProcedureSuccess(ProcedureDto procedureDto) {
        if (procedureDto.getIdApplicantType().equals(Constants.ID_OWNER_APPLICANT)){
            if (state.isBiometricIndicatorEnabled() && state.isExpedientIndicatorEnabled()){
                view.showLoading();
                interactor.validateCurp();
            }else {
                view.setTitleMsgError();
                state.setIsOwnerApplicant(true);
                view.showNeedExpedientDialog();
            }
        }else {
            if (state.isExpedientIndicatorEnabled()){
                view.showLoading();
                interactor.validateCurp();
            }else {
                view.setTitleMsgError();
                state.setIsOwnerApplicant(false);
                view.showNeedExpedientDialog();
            }
        }
    }

    @Override
    public void onValidateCurpSuccess(ProcedureDto procedureDto) {
        if (!procedureDto.getIdApplicantType().equals(Constants.ID_OWNER_APPLICANT)){
            if (procedureDto.getAuthFolio() != null && !procedureDto.getAuthFolio().isEmpty()){
                view.showConfirmDialog();
            }else {
                view.showAuthenticationDialog();
            }
        }else {
            view.showConfirmDialog();
        }
        view.dismissLoading();
    }

    @Override
    public void onValidateCurpError() {
        view.showInvalidCurpMessage();
        view.dismissLoading();
    }

    @Override
    public void onNeedExpedientFromProcesar() {
        view.showLoading();
        interactor.getClientDataProcesar();
    }

    @Override
    public void onGetClientDataProcesarSuccess(ClientDto clientDto) {
        if (clientDto.getBiometricIndicatorValue() == Constants.BIOMETRIC_INDICATOR_STATUS_EXIST){
            view.showBiometricIndicatorTrue();
            state.setBiometricIndicatorEnabled(true);
        }else {
            view.showBiometricIndicatorFalse();
            state.setBiometricIndicatorEnabled(false);
        }

        if (clientDto.getIdentificationIndicatorValue() == Constants.IDENTIFICATION_INDICATOR_STATUS_ACTIVE){
            view.showIdentificationIndicatorTrue();
            state.setExpedientIndicatorEnabled(true);
        }else {
            view.showIdentificationIndicatorFalse();
            state.setExpedientIndicatorEnabled(false);
        }

        if (state.isOwnerApplicant()){
            if (clientDto.getBiometricIndicatorValue() == Constants.BIOMETRIC_INDICATOR_STATUS_EXIST
                && clientDto.getIdentificationIndicatorValue() == Constants.IDENTIFICATION_INDICATOR_STATUS_ACTIVE
            ){
                view.setClientData(clientDto);
                view.setTitleMsgSuccess();
                interactor.validateCurp();
            }else {
                view.setTitleMsgError();
                view.setConfirmButtonDisabled();
                view.showNoExpedientFoundMessage();
                view.dismissLoading();
            }
        }else {
            if (clientDto.getIdentificationIndicatorValue() == Constants.IDENTIFICATION_INDICATOR_STATUS_ACTIVE){
                view.setClientData(clientDto);
                view.setTitleMsgSuccess();
                interactor.validateCurp();
            }else {
                view.setTitleMsgError();
                view.setConfirmButtonDisabled();
                view.showNoExpedientFoundMessage();
                view.dismissLoading();
            }
        }
    }

    @Override
    public void onGetClientDataProcesarError() {
        view.setConfirmButtonDisabled();
        view.showNoExpedientFoundMessage();
        view.dismissLoading();
    }

    @Override
    public void onValidateFolioRequired(String folio) {
        if (!folio.isEmpty() && folio.length() == Constants.LENGTH_AUTH_FOLIO){
            view.showLoading();
            interactor.validateAuthFolio(folio);
        }else {
            view.showAuthFolioInvalidMsg();
            view.showAuthenticationDialog();
        }
    }

    @Override
    public void onValidateAuthFolioSuccess(boolean isFolioSuccess, String folio) {
        if (isFolioSuccess){
            interactor.updateAuthFolioDB(folio);
        }else{
            view.showAuthFolioExpiredDialog();
            view.dismissLoading();
        }
    }

    @Override
    public void onValidateAuthFolioError() {
        view.showAuthFolioServiceErrorMsg();
        view.dismissLoading();
    }

    @Override
    public void onConfirmAuthFolioDialog() {
        view.showConfirmDialog();
    }

    @Override
    public void onUpdateAuthFolioDBSuccess() {
        view.showAuthFolioConfirmDialog();
        view.dismissLoading();
    }
}
