package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.GetClientDataResponse;

public class GetClientDataResponseValidator extends ResponseValidator<GetClientDataResponse> {
    public boolean validate(GetClientDataResponse response) {
        if (response == null) {
            return false;
        }

        if (response.getItems() == null) {
            return false;
        }

        if (response.getItems().isEmpty()) {
            return false;
        }

        return true;
    }
}