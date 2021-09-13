package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.SaveProcedureContract;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.ClientEmailDto;
import com.reintegro.profuturo.app.domain.dto.DocumentDto;
import com.reintegro.profuturo.app.domain.dto.NotificationChannelDto;
import com.reintegro.profuturo.app.domain.state.SaveProcedureState;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.util.Utils;
import com.reintegro.profuturo.app.vo.CoexistenceResult;

import java.util.List;

public class SaveProcedurePresenter extends PresenterBase<SaveProcedureContract.Interactor, SaveProcedureContract.State, SaveProcedureContract.View> implements SaveProcedureContract.Presenter {

    @Override
    public void resume() {
        interactor.getClientData();
        interactor.getDocuments();
    }

    @Override
    public void onGetClientDataSuccess(ClientDto clientDto) {
        view.showClientData(clientDto.getFullName() + " • " + Utils.formatClientAccountNumber(clientDto.getAccountNumber()));

        state.getNotificationChannel().setCellPhone(clientDto.getCellPhone());
        view.showCellPhone(clientDto.getCellPhone());

        for (ClientEmailDto clientEmail : clientDto.getEmails()) {
            if (clientEmail.isPreferential()) {
                state.getNotificationChannel().setEmail(clientEmail.getEmail());
                view.showEmail(clientEmail.getEmail());
                break;
            }
        }
    }

    @Override
    public void onGetDocumentsSuccess(List<DocumentDto> documents) {
        view.showDocuments(documents);
    }

    @Override
    public void setState(SaveProcedureContract.State state) {
        super.setState(state);
        state.setNotificationChannel(new NotificationChannelDto());
    }

    @Override
    public void onClickCancel() {
        view.showCancelDialog();
    }

    @Override
    public void onClickSaveProcedure() {
        view.showConfirmSaveDialog();
    }

    @Override
    public void onClickModifyNotification() {
        view.showModifyNotificationChannel(state.getNotificationChannel());
    }

    @Override
    public void onNotificationChannelModified(NotificationChannelDto notificationChannelDto) {
        state.setNotificationChannel(notificationChannelDto);
        interactor.validateCellPhone(notificationChannelDto.getCellPhone());
    }

    @Override
    public void onNotificationChannelSelected(NotificationChannelDto notificationChannel) {
        state.setNotificationChannel(notificationChannel);
    }

    @Override
    public void onClickConfirmSaveProcedure() {
        if (state.getNotificationChannel().getSelectedNotificationChannel() == Constants.NOTIFICATION_CHANNEL_UNSELECTED) {
            view.showUnselectedNotificationError();
        } else {
            view.showLoading();
            switch (state.getCurrentStep()) {
                case SaveProcedureState.STEP_MARK_NCI_COEXISTENCE:
                    interactor.markNciCoexistence();
                    break;
                case SaveProcedureState.STEP_SEND_EMAIL:
                    interactor.sendEmail();
                    break;
                case SaveProcedureState.STEP_START_BPM_INSTANCE:
                    interactor.startBpmInstance();
                    break;
                case SaveProcedureState.STEP_UPLOAD_IMAGES_FILENET:
                    interactor.uploadImagesFilenet();
                    break;
                case SaveProcedureState.STEP_UPDATE_PROCEDURE:
                    interactor.updateProcedure();
                    break;
                case SaveProcedureState.STEP_CLOSE_BINNACLE:
                    interactor.closeBinnacle();
                    break;
            }
        }
    }

    @Override
    public void onMarkNciCoexistenceSuccess(CoexistenceResult result) {
        if (result.isCoexistenceSuccess()) {
            state.setCurrentStep(SaveProcedureState.STEP_SEND_EMAIL);
            if (state.getNotificationChannel().getSelectedNotificationChannel() != Constants.NOTIFICATION_CHANNEL_NO_NOTIFY) {
                interactor.sendEmail();
            } else {
                onSendEmailSuccess();
            }
        } else {
            view.showNoCoexistenceDialog(result.getCoexistenceMessage());
            view.dismissLoading();
        }
    }

    @Override
    public void onMarkNciCoexistenceError() {
        view.showSaveProcedureError();
        view.dismissLoading();
    }

    @Override
    public void onSendEmailSuccess() {
        state.setCurrentStep(SaveProcedureState.STEP_START_BPM_INSTANCE);
        interactor.startBpmInstance();
    }

    @Override
    public void onSendEmailError() {
        view.showSaveProcedureError();
        view.dismissLoading();
    }

    @Override
    public void onStartBpmInstanceSuccess() {
        state.setCurrentStep(SaveProcedureState.STEP_UPLOAD_IMAGES_FILENET);
        interactor.uploadImagesFilenet();
    }

    @Override
    public void onStartBpmInstanceError() {
        view.showSaveProcedureError();
        view.dismissLoading();
    }

    @Override
    public void onUploadImageFilenetSuccess() {
        state.setCurrentStep(SaveProcedureState.STEP_UPDATE_PROCEDURE);
        interactor.updateProcedure();
    }

    @Override
    public void onUploadImageFilenetError() {
        view.showSaveProcedureError();
        view.dismissLoading();
    }

    @Override
    public void onUpdateProcedureSuccess() {
        state.setCurrentStep(SaveProcedureState.STEP_CLOSE_BINNACLE);
        interactor.closeBinnacle();
    }

    @Override
    public void onUpdateProcedureError() {
        view.showSaveProcedureError();
        view.dismissLoading();
    }

    @Override
    public void onCloseBinnacleSuccess() {
        view.showSaveProcedureSuccess();
        view.dismissLoading();
    }

    @Override
    public void onCloseBinnacleError() {
        view.showSaveProcedureError();
        view.dismissLoading();
    }

    @Override
    public void onCancelCloseBinnacleSuccess() {
        view.pushSearchClientScreen();
    }

    @Override
    public void onCancelCloseBinnacleError() {
        view.showBinnacleError();
    }

    @Override
    public void oncloseCancelBinnacle() {
        interactor.closeCancelBinnacle();
    }


    @Override
    public void onValidateCellPhoneSuccess() {
        interactor.validateEmail(state.getNotificationChannel().getEmail());
    }

    @Override
    public void onValidateCellPhoneError() {
        view.showCellPhoneError();
    }

    @Override
    public void onValidateEmailSuccess() {
        view.setEmailRadioButtonCheck(false);
        view.setNoNotifyRadioButtonCheck(false);
        view.setSmsRadioButtonCheck(false);
        view.showCellPhone(state.getNotificationChannel().getCellPhone());
        view.showEmail(state.getNotificationChannel().getEmail());
        state.getNotificationChannel().setSelectedNotificationChannel(Constants.NOTIFICATION_CHANNEL_UNSELECTED);
    }

    @Override
    public void onValidateEmailError() {
        view.showEmailError();
    }
}
