package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.domain.dto.AgentDto;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.FingerPrintDto;

import java.util.List;

public interface BiometricCaptureContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void getRecommendedFingers();
        void getClientData();
        void getAgentData();
        void readFingerPrints();
        void getVoluntarySeal(List<FingerPrintDto> fingerPrintDtoList);
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onCancelCLick();
        void onCaptureClick();
        void onGetRecommendedFingersSuccess(String result);
        void onGetRecommendedFingersError();
        void onGetClientDataSuccess(ClientDto clientDto);
        void onGetAgentDataSuccess(AgentDto agentDto);
        void onBiometricEngineResult();
        void onReadFingerPrintsSuccess(List<FingerPrintDto> fingerPrintDtoList);
        void onReadFingerPrintError();
    }

    interface State extends ContractBase.State{

    }

    interface View extends ContractBase.View{
        void setClientData(ClientDto clientData);
        void setAgentData(AgentDto agentData);
        void pushBiometricMotor(String fingers);
        void showGetRecommendedFingersError();
    }
}
