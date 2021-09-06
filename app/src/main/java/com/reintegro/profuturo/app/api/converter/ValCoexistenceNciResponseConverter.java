package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.ValCoexistenceNCIResponse;
import com.reintegro.profuturo.app.vo.CoexistenceResult;

public class ValCoexistenceNciResponseConverter extends ResponseConverter<ValCoexistenceNCIResponse, CoexistenceResult> {

    @Override
    public CoexistenceResult convert(ValCoexistenceNCIResponse response) {
        CoexistenceResult result = new CoexistenceResult();
        result.setCoexistenceSuccess(Boolean.parseBoolean(response.getConsultaConvivenciaCompletaComunNCIResponse().getConvive()));
        //result.setCoexistenceSuccess(true);//TODO delete this just for TEST
        result.setCoexistenceMessage(response.getConsultaConvivenciaCompletaComunNCIResponse().getDescNoConvivencia());
        return result;
    }
}
