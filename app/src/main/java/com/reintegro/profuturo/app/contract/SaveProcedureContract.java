package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.DocumentDto;
import com.reintegro.profuturo.app.domain.dto.NotificationChannelDto;
import com.reintegro.profuturo.app.vo.CoexistenceResult;

import java.util.List;

public interface SaveProcedureContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void getClientData();
        void getDocuments();
        void markNciCoexistence();
        void sendEmail();
        void startBpmInstance();
        void uploadImagesFilenet();
        void updateProcedure();
        void closeBinnacle();
        void closeCancelBinnacle();
        void validateCellPhone(String cellPhone);
        void validateEmail(String email);
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onClickCancel();
        void onClickSaveProcedure();
        void onClickConfirmSaveProcedure();
        void onClickModifyNotification();
        void onGetClientDataSuccess(ClientDto clientDto);
        void onGetDocumentsSuccess(List<DocumentDto> documents);
        void onNotificationChannelSelected(NotificationChannelDto notificationChannel);
        void onNotificationChannelModified(NotificationChannelDto notificationChannelDto);
        void onMarkNciCoexistenceSuccess(CoexistenceResult result);
        void onMarkNciCoexistenceError();
        void onSendEmailSuccess();
        void onSendEmailError();
        void onStartBpmInstanceSuccess();
        void onStartBpmInstanceError();
        void onUploadImageFilenetSuccess();
        void onUploadImageFilenetError();
        void onUpdateProcedureSuccess();
        void onUpdateProcedureError();
        void onCloseBinnacleSuccess();
        void onCloseBinnacleError();
        void onCancelCloseBinnacleSuccess();
        void onCancelCloseBinnacleError();
        void oncloseCancelBinnacle();
        void onValidateCellPhoneSuccess();
        void onValidateCellPhoneError();
        void onValidateEmailSuccess();
        void onValidateEmailError();
    }

    interface State extends ContractBase.State{
        void setCurrentStep(int currentStep);
        int getCurrentStep();
        void setNotificationChannel(NotificationChannelDto notificationChannel);
        NotificationChannelDto getNotificationChannel();
    }

    interface View extends ContractBase.View{
        void showCancelDialog();
        void showConfirmSaveDialog();
        void showUnselectedNotificationError();
        void showClientData(String data);
        void showCellPhone(String cellPhone);
        void showEmail(String email);
        void showDocuments(List<DocumentDto> documents);
        void showModifyNotificationChannel(NotificationChannelDto notificationChannelDto);
        void setEmailRadioButtonCheck(boolean checked);
        void setNoNotifyRadioButtonCheck(boolean checked);
        void setSmsRadioButtonCheck(boolean checked);
        void showCellPhoneError();
        void showEmailError();
        void pushSearchClientScreen();
        void showSaveProcedureSuccess();
        void showNoCoexistenceDialog(String msg);
        void showSaveProcedureError();
        void showBinnacleError();
    }
}
