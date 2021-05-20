package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.GetAgentAssignedBranchOfficeResponse;
import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.util.TypeUtils;

public class GetAgentAssignedBranchOfficeResponseConverter extends ResponseConverter<GetAgentAssignedBranchOfficeResponse, AgentEntity> {
    @Override
    public AgentEntity convert(GetAgentAssignedBranchOfficeResponse response) {
        AgentEntity agentEntity;
        agentEntity = new AgentEntity();
        agentEntity.setBranchOfficeName(TypeUtils.getValueOrDefault(response.getBranchOfficeName()));
        agentEntity.setBranchOfficeNumber(TypeUtils.getValueOrDefault(response.getBranchOfficeNumber()));

        return agentEntity;
    }
}