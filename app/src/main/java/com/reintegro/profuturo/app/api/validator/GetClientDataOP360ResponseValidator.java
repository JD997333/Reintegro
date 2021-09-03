package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.GetClientData360Response;

public class GetClientDataOP360ResponseValidator extends ResponseValidator<GetClientData360Response> {
    @Override
    public boolean validate(GetClientData360Response response) {
        if (response.getConsultaTrabajadorResponse() == null){
            return false;
        }

        if (response.getConsultaTrabajadorResponse().getResponse() == null){
            return false;
        }

        if (response.getConsultaTrabajadorResponse().getResponse().getExpediente() == null){
            return false;
        }

        if (response.getConsultaTrabajadorResponse().getResponse().getExpediente().getResponse() == null){
            return false;
        }

        if (response.getConsultaTrabajadorResponse().getResponse().getExpediente().getResponse().getEstatusEnrolamiento() == null){
            return false;
        }

        if (response.getConsultaTrabajadorResponse().getResponse().getExpediente().getResponse().getEstatusEnrolamiento().isEmpty()){
            return false;
        }

        if (response.getConsultaTrabajadorResponse().getResponse().getExpediente().getResponse().getEstatusExpedienteIdentificacion() == null){
            return false;
        }

        if (response.getConsultaTrabajadorResponse().getResponse().getExpediente().getResponse().getEstatusExpedienteIdentificacion().isEmpty()){
            return false;
        }

        return true;
    }
}
