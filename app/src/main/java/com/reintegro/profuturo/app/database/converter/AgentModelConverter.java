package com.reintegro.profuturo.app.database.converter;

import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.database.model.AgentModel;

public class AgentModelConverter {
    public static AgentEntity convertFromModel(AgentModel agentModel) {
        AgentEntity agentEntity;
        agentEntity = new AgentEntity();
        agentEntity.setAgentCode(agentModel.getAgentCode());
        agentEntity.setBranchOfficeName(agentModel.getBranchOfficeName());
        agentEntity.setBranchOfficeNumber(agentModel.getBranchOfficeNumber());
        agentEntity.setConsarKey(agentModel.getConsarKey());
        agentEntity.setConsarRegistrationDate(DateModelConverter.convertFromModel(agentModel.getConsarRegistrationDate()));
        agentEntity.setCurp(agentModel.getCurp());
        agentEntity.setFatherLastName(agentModel.getFatherLastName());
        agentEntity.setFullName(agentModel.getFullName());
        agentEntity.setId(agentModel.getId());
        agentEntity.setMotherLastName(agentModel.getMotherLastName());
        agentEntity.setName(agentModel.getName());

        return agentEntity;
    }

    public static AgentModel convertFromEntity(AgentEntity agentEntity) {
        AgentModel agentModel;
        agentModel = new AgentModel();
        agentModel.setAgentCode(agentEntity.getAgentCode());
        agentModel.setBranchOfficeName(agentEntity.getBranchOfficeName());
        agentModel.setBranchOfficeNumber(agentEntity.getBranchOfficeNumber());
        agentModel.setConsarKey(agentEntity.getConsarKey());
        agentModel.setConsarRegistrationDate(DateModelConverter.convertFromEntity(agentEntity.getConsarRegistrationDate()));
        agentModel.setCurp(agentEntity.getCurp());
        agentModel.setFatherLastName(agentEntity.getFatherLastName());
        agentModel.setFullName(agentEntity.getFullName());
        agentModel.setMotherLastName(agentEntity.getMotherLastName());
        agentModel.setName(agentEntity.getName());

        boolean hasId;
        hasId = agentEntity.getId() != null;

        if (hasId) {
            agentModel.setId(agentEntity.getId());
        }

        return agentModel;
    }
}
