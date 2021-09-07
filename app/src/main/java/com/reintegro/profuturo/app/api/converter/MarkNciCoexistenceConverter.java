package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.MarkNciCoexistenceResponse;
import com.reintegro.profuturo.app.util.TypeUtils;
import com.reintegro.profuturo.app.vo.CoexistenceResult;

public class MarkNciCoexistenceConverter extends ResponseConverter<MarkNciCoexistenceResponse, CoexistenceResult>{
    @Override
    public CoexistenceResult convert(MarkNciCoexistenceResponse response) {
        CoexistenceResult result = new CoexistenceResult();
        result.setCoexistenceSuccess(TypeUtils.getBooleanValueOrDefault(response.getSuccess()));
        result.setCoexistenceMessage(TypeUtils.getValueOrDefault(response.getDescripcionNoConvivencia()));
        return result;
    }
}
