package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.InsertProcessBinnacleResponse;

public class InsertBinnacleResponseValidator extends ResponseValidator<InsertProcessBinnacleResponse>{
    @Override
    public boolean validate(InsertProcessBinnacleResponse response) {
        if (response == null){
            return false;
        }
        return response.isSuccess();
    }
}
