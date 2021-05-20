package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.domain.dto.AgentDto;

public class AgentConverter {
    public static AgentDto convertFromEntity(AgentEntity agentEntity) {
        AgentDto agentDto;
        agentDto = new AgentDto();
        agentDto.setAgentCode(agentEntity.getAgentCode());
        agentDto.setBranchOfficeName(agentEntity.getBranchOfficeName());
        agentDto.setBranchOfficeNumber(agentEntity.getBranchOfficeNumber());
        agentDto.setConsarKey(agentEntity.getConsarKey());
        agentDto.setConsarRegistrationDate(DateConverter.convertFromEntity(agentEntity.getConsarRegistrationDate()));
        agentDto.setCostCenter(agentEntity.getCostCenter());
        agentDto.setCurp(agentEntity.getCurp());
        agentDto.setEmail(agentEntity.getEmail());
        agentDto.setFatherLastName(agentEntity.getFatherLastName());
        agentDto.setFullName(agentEntity.getFullName());
        agentDto.setId(agentDto.getId());
        agentDto.setMotherLastName(agentEntity.getMotherLastName());
        agentDto.setName(agentEntity.getName());
        agentDto.setUserId(agentEntity.getUserId());

        return agentDto;
    }

    public static AgentEntity convertFromDto(AgentDto agentDto) {
        AgentEntity agentEntity;
        agentEntity = new AgentEntity();
        agentEntity.setAgentCode(agentDto.getAgentCode());
        agentEntity.setBranchOfficeName(agentDto.getBranchOfficeName());
        agentEntity.setBranchOfficeNumber(agentDto.getBranchOfficeNumber());
        agentEntity.setConsarKey(agentDto.getConsarKey());
        agentEntity.setConsarRegistrationDate(DateConverter.convertFromDto(agentDto.getConsarRegistrationDate()));
        agentEntity.setCostCenter(agentDto.getCostCenter());
        agentEntity.setCurp(agentDto.getCurp());
        agentEntity.setEmail(agentDto.getEmail());
        agentEntity.setFatherLastName(agentDto.getFatherLastName());
        agentEntity.setFullName(agentDto.getFullName());
        agentEntity.setId(agentDto.getId());
        agentEntity.setMotherLastName(agentDto.getMotherLastName());
        agentEntity.setName(agentDto.getName());
        agentEntity.setUserId(agentDto.getUserId());

        return agentEntity;
    }
}

