package com.reintegro.profuturo.app.api.converter;


import com.reintegro.profuturo.app.api.vo.InsertInitialRulingResponse;

public class InsertInitialRulingResponseConverter extends ResponseConverter<InsertInitialRulingResponse, Boolean> {
    @Override
    public Boolean convert(InsertInitialRulingResponse response) {
        return response.isSuccess();
    }

}
