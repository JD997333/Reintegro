package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.DocumentDto;
import com.reintegro.profuturo.app.domain.dto.NotificationChannelDto;

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
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onClickCancel();
        void onClickSaveProcedure();
        void onClickConfirmSaveProcedure();
        void onClickModifyNotification();
        void onGetClientDataSuccess(ClientDto clientDto);
        void onGetDocumentsSuccess(List<DocumentDto> documents);
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
    }
}
