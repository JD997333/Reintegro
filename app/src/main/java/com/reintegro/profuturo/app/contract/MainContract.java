package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.domain.dto.AgentDto;

public interface MainContract {
    interface Interactor extends ContractBase.Interactor<Presenter> {
        void getAgentInformation(AgentDto agentDto);
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View> {
        void load(AgentDto agentDto);
        void onGetAgentInformationError();
        void onGetAgentInformationSuccess(AgentDto agentDto);
    }

    interface State extends ContractBase.State{

    }

    interface View extends ContractBase.View{
        void showAgentInformation(AgentDto agentDto);
        void showGetAgentInformationError();
    }

}