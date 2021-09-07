package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.MarkNciCoexistenceResponse;

public class MarkNciCoexistenceValidator extends ResponseValidator<MarkNciCoexistenceResponse>{
    @Override
    public boolean validate(MarkNciCoexistenceResponse response) {
        if (response == null){
            return false;
        }
        return true;
    }
}
