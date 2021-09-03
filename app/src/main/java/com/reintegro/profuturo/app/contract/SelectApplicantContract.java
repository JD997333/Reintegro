package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.ProcedureDto;
import com.reintegro.profuturo.app.vo.ApplicantType;
import com.reintegro.profuturo.app.vo.CoexistenceResult;

import java.util.List;

public interface SelectApplicantContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void updateProcedureData(String applicantType, String applicantCurp, String authFolio);
        void getClientDataDB();
        void getApplicantTypes();
        void getClientDataProcesar(ClientDto clientDto);
        void saveFirstProcedureData();
        void valCoexistenceNci();
        void validateCurp(ProcedureDto procedureDto);
        void validateAuthFolio(String folio);
        void updateAuthFolioDB(String authFolio);
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onConfirmButtonClicked(String applicantType, String applicantCurp, String authFolio);
        void onUpdateProcedureSuccess(ProcedureDto procedureDto);
        void onGetClientDataSuccess(ClientDto clientDto);
        void onValidateIndicatorsError();
        void onGetApplicantTypesSuccess(List<ApplicantType> applicantTypes);
        void onGetApplicantTypesError();
        void onNeedExpedientFromProcesar(ClientDto clientDto);
        void onApplicantSelected(ApplicantType applicantType, ClientDto clientDto);
        void onSaveFirstProcedureData(ProcedureDto procedureDto);
        void onValCoexistenceNciSuccess(CoexistenceResult result);
        void onValCoexistenceNciError();
        void onValCoexistenceRetry();
        void onValidateCurpSuccess(ProcedureDto procedureDto);
        void onValidateCurpError();
        void onGetClientDataProcesarSuccess(ClientDto clientDto);
        void onGetClientDataProcesarError();
        void onValidateFolioRequired(String folio);
        void onValidateAuthFolioSuccess(boolean folioSuccess, String folio);
        void onValidateAuthFolioError();
        void onConfirmAuthFolioDialog();
        void onUpdateAuthFolioDBSuccess();
    }

    interface State extends ContractBase.State{

    }

    interface View extends ContractBase.View{
        void pushInitialCapture();
        void showSaveProcedureSuccessMessage();
        void showBiometricIndicatorTrue();
        void showBiometricIndicatorFalse();
        void showIdentificationIndicatorTrue();
        void showIdentificationIndicatorFalse();
        void showApplicantTypes(List<ApplicantType> applicantTypes);
        void showNeedExpedientDialog(ClientDto clientDto);
        void setClientData(ClientDto clientDto);
        void showCurp(String curp);
        void showCurpTit(String curp);
        void showConfirmDialog();
        void showNoCoexistenceDialog(String noCoexistenceMessage);
        void showCoexistenceServiceError();
        void showInvalidCurpMessage();
        void showNoExpedientFoundMessage();
        void setConfirmButtonDisabled();
        void showSelectApplicantNecesaryMsg();
        void setTitleMsgSuccess();
        void setTitleMsgError();
        void showAuthenticationDialog();
        void showAuthFolioInvalidMsg();
        void showAuthFolioExpiredDialog();
        void showAuthFolioConfirmDialog();
        void showAuthFolioServiceErrorMsg();
    }
}

//aqui se declaran las funciones que se van a ocupar