package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.GetRecommendedFingersResponse;

public class GetRecommendedFingersResponseValidator extends ResponseValidator<GetRecommendedFingersResponse>{
    @Override
    public boolean validate(GetRecommendedFingersResponse response) {
        if (response == null){
            return false;
        }
        if (!response.isResult()){
            return false;
        }
        return true;
    }
}
