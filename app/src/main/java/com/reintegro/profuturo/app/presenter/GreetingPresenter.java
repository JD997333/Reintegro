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
        view.showLoading();
        interactor.getAgentInformation();
    }

    @Override
    public void onBranchOfficeSelected(BranchOfficeDto branchOfficeDto) {
        interactor.updateAgentAssignedBranchOffice(branchOfficeDto);
    }

    @Override
    public void onGetAgentInformationSuccess(AgentDto agentDto) {
        interactor.getDeviceLocation();
        view.showAgentInformation(agentDto);
    }

    @Override
    public void onGetAgentAssignedBranchOfficeError() {
        view.showGetAgentAssignedBranchOfficeError();
    }

    @Override
    public void onGetAgentAssignedBranchOfficeSuccess() {
        interactor.saveLogin();

        //view.dismissLoading();
    }

    @Override
    public void onGetBranchOfficesSuccess(List<BranchOfficeDto> branchOfficeDtos) {
        interactor.validateAgentAssignedBranchOffice(branchOfficeDtos);
        view.showBranchOffices(branchOfficeDtos);
    }

    @Override
    public void onGetBranchOfficesError() {
        view.showGetBranchOfficesError();
    }

    @Override
    public void onGetDeviceLocationSuccess() {
        interactor.getAgentAssignedBranchOffice();
    }

    @Override
    public void onGetDeviceLocationError() {
        view.showGetDeviceLocationError();
    }

    @Override
    public void onSaveLoginSuccess() {
        interactor.getBranchOffices();
    }

    @Override
    public void onSaveLoginError() {
        view.showSaveLoginError();
    }

    @Override
    public void onValidateAgentAssignedBranchOfficeSuccess(Integer position) {
        view.showAgentAssignedBranchOffice(position);
        view.dismissLoading();
    }

    @Override
    public void onValidateAgentAssignedBranchOfficeError() {
        view.dismissLoading();
        view.showValidateAgentAssignedBranchOfficeError();
    }
}
