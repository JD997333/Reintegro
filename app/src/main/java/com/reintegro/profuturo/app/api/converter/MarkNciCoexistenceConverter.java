package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.MarkNciCoexistenceResponse;
import com.reintegro.profuturo.app.util.TypeUtils;
import com.reintegro.profuturo.app.vo.CoexistenceResult;

public class MarkNciCoexistenceConverter extends ResponseConverter<MarkNciCoexistenceResponse, CoexistenceResult>{
    @Override
    public CoexistenceResult convert(MarkNciCoexistenceResponse response) {
        CoexistenceResult result = new CoexistenceResult();
        result.setCoexistenceSuccess(TypeUtils.getValueOrDefault(response.getMarkResponse().isSuccess()));
        result.setCoexistenceMessage(TypeUtils.getValueOrDefault(response.getMarkResponse().getMessage()));
        return result;
    }
}
