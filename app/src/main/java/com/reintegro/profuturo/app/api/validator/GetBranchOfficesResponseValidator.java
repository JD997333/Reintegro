package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.GetBranchOfficesResponse;

public class GetBranchOfficesResponseValidator extends ResponseValidator<GetBranchOfficesResponse> {
    public boolean validate(GetBranchOfficesResponse response) {
        if (response == null) {
            return false;
        }

        if (response.getBranchOffices() == null) {
            return false;
        }

        return true;
    }
}