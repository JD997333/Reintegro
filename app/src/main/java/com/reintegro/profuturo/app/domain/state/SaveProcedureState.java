package com.reintegro.profuturo.app.domain.state;

import com.reintegro.profuturo.app.contract.SaveProcedureContract;
import com.reintegro.profuturo.app.domain.dto.NotificationChannelDto;

public class SaveProcedureState implements SaveProcedureContract.State {
    public static final int STEP_VALIDATE_NOTIFICATION_CHANNEL = 0;
    public static final int STEP_MARK_NCI_COEXISTENCE = 1;
    public static final int STEP_SEND_EMAIL = 2;
    public static final int STEP_START_BPM_INSTANCE = 3;
    public static final int STEP_UPLOAD_IMAGES_FILENET = 4;
    public static final int STEP_UPDATE_PROCEDURE = 5;
    public static final int STEP_CLOSE_BINNACLE = 6;

    private NotificationChannelDto notificationChannelDto;
    private int currentStep;

    public SaveProcedureState() {
        currentStep = STEP_VALIDATE_NOTIFICATION_CHANNEL;
    }

    @Override
    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
    }

    @Override
    public int getCurrentStep() {
        return currentStep;
    }

    @Override
    public void setNotificationChannel(NotificationChannelDto notificationChannel) {
        this.notificationChannelDto = notificationChannel;
    }

    @Override
    public NotificationChannelDto getNotificationChannel() {
        return notificationChannelDto;
    }
}
