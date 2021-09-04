package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.GetRecommendedFingersResponse;

public class GetRecommendedFingersResponseConverter extends ResponseConverter<GetRecommendedFingersResponse, String>{
    @Override
    public String convert(GetRecommendedFingersResponse getRecommendedFingersResponse) {
        return getRecommendedFingersResponse.toString();
    }
}
