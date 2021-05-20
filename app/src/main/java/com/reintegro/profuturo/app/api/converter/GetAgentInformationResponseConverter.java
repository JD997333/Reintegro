package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.GetAgentInformationResponse;
import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.util.TypeUtils;

public class GetAgentInformationResponseConverter extends ResponseConverter<GetAgentInformationResponse, AgentEntity> {
    @Override
    public AgentEntity convert(GetAgentInformationResponse response) {
        GetAgentInformationResponse.AgentInformation agentInformation = response.getAgentInformation();

        AgentEntity agentEntity;
        agentEntity = new AgentEntity();
        agentEntity.setAgentCode(TypeUtils.getValueOrDefault(agentInformation.getAgentNumber()));
        agentEntity.setConsarKey(TypeUtils.getValueOrDefault(Long.parseLong(agentInformation.getConsarKey())));
        agentEntity.setConsarRegistrationDate(DateResponseConverter.convertFromResponse(agentInformation.getConsarRegistrationDate(), Constants.DATE_FORMAT_3));
        agentEntity.setCostCenter(TypeUtils.getValueOrDefault(Long.parseLong(agentInformation.getCostCenter())));
        agentEntity.setCurp(TypeUtils.getValueOrDefault(agentInformation.getCurp()));
        agentEntity.setEmail(TypeUtils.getValueOrDefault(agentInformation.getEmail()));
        agentEntity.setFatherLastName(TypeUtils.getValueOrDefault(agentInformation.getFatherLastName()));
        agentEntity.setFullName(TypeUtils.getValueOrDefault(agentInformation.getName()) + " " + TypeUtils.getValueOrDefault(agentInformation.getFatherLastName()) + " " + TypeUtils.getValueOrDefault(agentInformation.getMotherLastName()));
        agentEntity.setMotherLastName(TypeUtils.getValueOrDefault(agentInformation.getMotherLastName()));
        agentEntity.setName(TypeUtils.getValueOrDefault(agentInformation.getName()));
        agentEntity.setUserId(TypeUtils.getValueOrDefault(agentInformation.getUserId()));

        return agentEntity;
    }
}
