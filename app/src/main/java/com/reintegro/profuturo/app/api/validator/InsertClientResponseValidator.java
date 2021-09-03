package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.InsertClientResponse;

public class InsertClientResponseValidator extends ResponseValidator<InsertClientResponse>{
    @Override
    public boolean validate(InsertClientResponse response) {
        if (response.getInsertClientResponse() == null){
            return false;
        }

        return true;
    }
}
