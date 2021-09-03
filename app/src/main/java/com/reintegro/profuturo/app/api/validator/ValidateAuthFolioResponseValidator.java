package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.ValidateAuthFolioResponse;

public class ValidateAuthFolioResponseValidator extends ResponseValidator<ValidateAuthFolioResponse>{
    @Override
    public boolean validate(ValidateAuthFolioResponse response) {
        if (response.getValidateAuthFolioOut() == null){
            return false;
        }
        if (response.getValidateAuthFolioOut().getResult() == null){
            return false;
        }

        return true;
    }
}
