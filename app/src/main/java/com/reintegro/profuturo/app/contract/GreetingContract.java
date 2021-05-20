package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.domain.dto.AgentDto;
import com.reintegro.profuturo.app.domain.dto.BranchOfficeDto;

import java.util.List;

public interface GreetingContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void getAgentInformation();
        void getAgentAssignedBranchOffice();
        void getBranchOffices();
        void getDeviceLocation();
        void saveLogin();
        void validateAgentAssignedBranchOffice(List<BranchOfficeDto> branchOfficeDtos);
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onGetAgentInformationSuccess(AgentDto agentDto);
        void onGetAgentAssignedBranchOfficeError();
        void onGetAgentAssignedBranchOfficeSuccess();
        void onGetBranchOfficesSuccess(List<BranchOfficeDto> branchOfficeDtos);
        void onGetBranchOfficesError();
        void onGetDeviceLocationSuccess();
        void onGetDeviceLocationError();
        void onSaveLoginSuccess();
        void onSaveLoginError();
        void onValidateAgentAssignedBranchOfficeSuccess(Integer position);
        void onValidateAgentAssignedBranchOfficeError();

    }

    interface State extends ContractBase.State{

    }

    interface View extends ContractBase.View{
        void showAgentAssignedBranchOffice(Integer position);
        void showAgentInformation(AgentDto agentDto);
        void showBranchOffices(List<BranchOfficeDto> branchOfficeDtos);
    }
}
