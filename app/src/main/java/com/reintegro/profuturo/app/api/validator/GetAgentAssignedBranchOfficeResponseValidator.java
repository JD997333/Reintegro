package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.GetAgentAssignedBranchOfficeResponse;

public class GetAgentAssignedBranchOfficeResponseValidator extends ResponseValidator<GetAgentAssignedBranchOfficeResponse> {
    public boolean validate(GetAgentAssignedBranchOfficeResponse response) {
        if (response == null) {
            return false;
        }

        if (response.getBranchOfficeName() == null) {
            return false;
        }

        if (response.getBranchOfficeName().isEmpty()) {
            return false;
        }

        if (response.getBranchOfficeNumber() == null) {
            return false;
        }

        return true;
    }
}

