package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.GetClientData360Response;
import com.reintegro.profuturo.app.util.Constants;

import java.util.HashMap;

public class GetClientDataOP360ResponseConverter extends ResponseConverter<GetClientData360Response, HashMap<String, String>> {
    @Override
    public HashMap<String, String> convert(GetClientData360Response response) {
        HashMap<String, String> indicatorsResult = new HashMap<>();
        indicatorsResult.put(
            Constants.KEY_BIOMETRIC_STATUS,
            response.getConsultaTrabajadorResponse().getResponse().getExpediente().getResponse().getEstatusEnrolamiento()
        );
        indicatorsResult.put(
            Constants.KEY_IDENTIFICATION_STATUS,
            response.getConsultaTrabajadorResponse().getResponse().getExpediente().getResponse().getEstatusExpedienteIdentificacion()
        );

        return indicatorsResult;
    }
}
