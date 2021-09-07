package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.InsertProcessBinnacleResponse;

public class InsertBinnacleResponseConverter extends ResponseConverter<InsertProcessBinnacleResponse, Boolean>{
    @Override
    public Boolean convert(InsertProcessBinnacleResponse response) {
        return response.isSuccess();
    }
}
