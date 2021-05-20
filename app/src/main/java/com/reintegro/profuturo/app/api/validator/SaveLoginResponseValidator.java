package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.SaveLoginResponse;

public class SaveLoginResponseValidator extends ResponseValidator<SaveLoginResponse> {
    @Override
    public boolean validate(SaveLoginResponse response) {
        if (response == null) {
            return false;
        }

        if (response == null) {
            return false;
        }

        return true;
    }
}
