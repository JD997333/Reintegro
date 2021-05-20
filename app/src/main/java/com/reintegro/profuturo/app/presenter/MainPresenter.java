package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.MainContract;
import com.reintegro.profuturo.app.domain.dto.AgentDto;

public class MainPresenter extends PresenterBase<MainContract.Interactor, MainContract.State, MainContract.View> implements MainContract.Presenter {
    @Override
    public void load(AgentDto agentDto) {
        interactor.getAgentInformation(agentDto);
    }

    @Override
    public void onGetAgentInformationError() {
        view.showGetAgentInformationError();
    }

    @Override
    public void onGetAgentInformationSuccess(AgentDto agentDto) {
        view.showAgentInformation(agentDto);
    }
}
