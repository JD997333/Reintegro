package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.InsertClientResponse;

public class InsertClientResponseConverter extends ResponseConverter<InsertClientResponse, Boolean> {
    @Override
    public Boolean convert(InsertClientResponse response) {
        return response.getInsertClientResponse().getSuccess();
    }
}
