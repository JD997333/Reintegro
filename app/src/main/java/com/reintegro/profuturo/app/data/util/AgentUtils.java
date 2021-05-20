package com.reintegro.profuturo.app.data.util;

import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.data.entity.BranchOfficeEntity;

public class AgentUtils {
    public static AgentEntity mergeAgentInformation(AgentEntity to, AgentEntity from) {
        to.setAgentCode(from.getAgentCode());
        to.setConsarKey(from.getConsarKey());
        to.setConsarRegistrationDate(from.getConsarRegistrationDate());
        to.setCostCenter(from.getCostCenter());
        to.setCurp(from.getCurp());
        to.setEmail(from.getEmail());
        to.setFatherLastName(from.getFatherLastName());
        to.setFullName(from.getFullName());
        to.setMotherLastName(from.getMotherLastName());
        to.setName(from.getName());
        to.setUserId(from.getUserId());

        return to;
    }

    public static AgentEntity mergeAgentAssignedBranchOffice(AgentEntity to, AgentEntity from) {
        to.setBranchOfficeName(from.getBranchOfficeName());
        to.setBranchOfficeNumber(from.getBranchOfficeNumber());

        return to;
    }

    public static AgentEntity mergeAgentAssignedBranchOffice(AgentEntity to, BranchOfficeEntity from) {
        to.setBranchOfficeName(from.getBranchOfficeName());
        to.setBranchOfficeNumber(from.getCostCenterId());

        return to;
    }
}

