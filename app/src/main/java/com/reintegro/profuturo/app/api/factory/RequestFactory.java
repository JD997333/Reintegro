package com.reintegro.profuturo.app.api.factory;

import com.reintegro.profuturo.app.api.vo.GetAgentAssignedBranchOfficeRequest;
import com.reintegro.profuturo.app.api.vo.GetAgentInformationRequest;
import com.reintegro.profuturo.app.api.vo.GetClientImageRequest;
import com.reintegro.profuturo.app.api.vo.SaveLoginRequest;
import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.util.DateUtils;
import com.reintegro.profuturo.app.util.TypeUtils;

public class RequestFactory {

    public GetAgentInformationRequest createGetAgentInformationRequest(AgentEntity agentEntity) {
        GetAgentInformationRequest.AgentNumber agentNumber;
        agentNumber = new GetAgentInformationRequest.AgentNumber();
        agentNumber.setAgentNumber(TypeUtils.getValueOrDefault(agentEntity.getAgentCode()));

        GetAgentInformationRequest getAgentInformationRequest;
        getAgentInformationRequest = new GetAgentInformationRequest();
        getAgentInformationRequest.setAgentNumber(agentNumber);

        return getAgentInformationRequest;
    }

    public GetAgentAssignedBranchOfficeRequest createGetAgentAssignedBranchOfficeRequest(AgentEntity agentEntity) {
        GetAgentAssignedBranchOfficeRequest.AgentNumber agentNumber;
        agentNumber = new GetAgentAssignedBranchOfficeRequest.AgentNumber();
        agentNumber.setAgentNumber(TypeUtils.getValueOrDefault(agentEntity.getAgentCode()));

        GetAgentAssignedBranchOfficeRequest getAgentAssignedBranchOfficeRequest;
        getAgentAssignedBranchOfficeRequest = new GetAgentAssignedBranchOfficeRequest();
        getAgentAssignedBranchOfficeRequest.setAgentNumber(agentNumber);

        return getAgentAssignedBranchOfficeRequest;
    }

    public SaveLoginRequest createSaveLoginRequest(AgentEntity agentEntity) {
        SaveLoginRequest saveLoginRequest;
        saveLoginRequest = new SaveLoginRequest();
        saveLoginRequest.setAccessDate(DateUtils.parseDate(Constants.DATE_FORMAT_1, Constants.DATE_FORMAT_2, agentEntity.getConsarRegistrationDate().toDate()));
        saveLoginRequest.setAgentNumber(agentEntity.getAgentCode());
        saveLoginRequest.setAssignedBranchOfficeId(String.valueOf(agentEntity.getBranchOfficeNumber()));
        saveLoginRequest.setBranchOfficeName(agentEntity.getBranchOfficeName());
        saveLoginRequest.setConsarAgentNumber(String.valueOf(agentEntity.getConsarKey()));
        saveLoginRequest.setCreationUser("Mobile");
        saveLoginRequest.setCurp(agentEntity.getCurp());
        saveLoginRequest.setEmail(agentEntity.getEmail());
        saveLoginRequest.setFatherLastName(agentEntity.getFatherLastName());
        saveLoginRequest.setMotherLastName(agentEntity.getMotherLastName());
        saveLoginRequest.setName(agentEntity.getName());

        return saveLoginRequest;
    }

    public GetClientImageRequest createGetClientImageRequest(ClientEntity clientEntity) {
        GetClientImageRequest getClientImageRequest;
        getClientImageRequest = new GetClientImageRequest();
        getClientImageRequest.setAccountNumber(Long.parseLong(clientEntity.getAccountNumber()));

        return getClientImageRequest;
    }


}
