package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.GreetingContract;
import com.reintegro.profuturo.app.domain.dto.AgentDto;
import com.reintegro.profuturo.app.domain.dto.BranchOfficeDto;

import java.util.List;

public class GreetingPresenter extends PresenterBase<GreetingContract.Interactor, GreetingContract.State, GreetingContract.View> implements GreetingContract.Presenter {

    @Override
    public void resume() {
        interactor.getAgentInformation();
    }

    @Override
    public void onGetAgentInformationSuccess(AgentDto agentDto) {
        interactor.getDeviceLocation();
        view.showAgentInformation(agentDto);
    }

    @Override
    public void onGetAgentAssignedBranchOfficeError() {

    }

    @Override
    public void onGetAgentAssignedBranchOfficeSuccess() {
        interactor.saveLogin();
    }

    @Override
    public void onGetBranchOfficesSuccess(List<BranchOfficeDto> branchOfficeDtos) {
        interactor.validateAgentAssignedBranchOffice(branchOfficeDtos);
        view.showBranchOffices(branchOfficeDtos);
    }

    @Override
    public void onGetBranchOfficesError() {

    }

    @Override
    public void onGetDeviceLocationSuccess() {
        interactor.getAgentAssignedBranchOffice();
    }

    @Override
    public void onGetDeviceLocationError() {
        //interactor.getAgentAssignedBranchOffice();
    }

    @Override
    public void onSaveLoginSuccess() {
        interactor.getBranchOffices();
    }

    @Override
    public void onSaveLoginError() {

    }

    @Override
    public void onValidateAgentAssignedBranchOfficeSuccess(Integer position) {
        view.showAgentAssignedBranchOffice(position);
    }

    @Override
    public void onValidateAgentAssignedBranchOfficeError() {

    }
}
