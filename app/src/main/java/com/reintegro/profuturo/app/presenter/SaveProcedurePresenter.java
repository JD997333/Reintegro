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

    }

    @Override
    public void onClickConfirmSaveProcedure() {
        if (state.getNotificationChannel().getSelectedNotificationChannel() == Constants.NOTIFICATION_CHANNEL_UNSELECTED){
            view.showUnselectedNotificationError();
        }else {
            switch (state.getCurrentStep()){
                case SaveProcedureState.STEP_VALIDATE_NOTIFICATION_CHANNEL:
                    break;
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
}
