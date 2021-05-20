package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.GetAgentInformationResponse;

public class GetAgentInformationResponseValidator extends ResponseValidator<GetAgentInformationResponse>{
    @Override
    public boolean validate(GetAgentInformationResponse response) {
        if (response == null) {
            return false;
        }

        if (response.getAgentInformation() == null) {
            return false;
        }

        return true;
    }
}
