package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.InsertInitialRulingResponse;

public class InsertInitialRulingResponseValidator extends ResponseValidator<InsertInitialRulingResponse>{
    @Override
    public boolean validate(InsertInitialRulingResponse response) {
        if (response == null){
            return false;
        }
        if (response.getStartResponse() == null){
            return false;
        }

        return response.getStartResponse().isSuccess();
    }
}
