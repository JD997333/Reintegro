package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.BiometricCaptureContract;
import com.reintegro.profuturo.app.domain.dto.AgentDto;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.FingerPrintDto;

import java.util.List;

public class BiometricCapturePresenter extends PresenterBase<BiometricCaptureContract.Interactor, BiometricCaptureContract.State, BiometricCaptureContract.View> implements BiometricCaptureContract.Presenter {

    @Override
    public void onCancelCLick() {
        view.showCancelDialog();
    }

    @Override
    public void onCaptureClick() {
        view.showLoading();
        interactor.getClientData();
    }

    @Override
    public void onGetRecommendedFingersSuccess(String result) {
        view.pushBiometricMotor(result);
        view.dismissLoading();
    }

    @Override
    public void onGetRecommendedFingersError() {
        view.showGetRecommendedFingersError();
        view.dismissLoading();
    }

    @Override
    public void onGetClientDataSuccess(ClientDto clientDto) {
        view.setClientData(clientDto);
        interactor.getAgentData();
    }

    @Override
    public void onGetAgentDataSuccess(AgentDto agentDto) {
        view.setAgentData(agentDto);
        interactor.getRecommendedFingers();
    }

    @Override
    public void onBiometricEngineResult() {
        view.showLoading();
        interactor.readFingerPrints();
    }

    @Override
    public void onReadFingerPrintsSuccess(List<FingerPrintDto> fingerPrintDtoList) {
        interactor.getVoluntarySeal(fingerPrintDtoList);
    }

    @Override
    public void onReadFingerPrintError() {

    }

    @Override
    public void onGetVoluntarySealError() {
        view.showGetVoluntarySealError();
        view.dismissLoading();
    }

    @Override
    public void onSaveVoluntarySealSuccess() {
        view.pushSaveProcedure();
        view.dismissLoading();
    }

    @Override
    public void onSaveVoluntarySealError() {
        view.showSaveVoluntarySealError();
        view.dismissLoading();
    }
}
