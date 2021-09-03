package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.ValCoexistenceNCIResponse;

public class ValCoexistenceNciResponseValidator extends ResponseValidator<ValCoexistenceNCIResponse>{
    @Override
    public boolean validate(ValCoexistenceNCIResponse response) {
        if (response.getConsultaConvivenciaCompletaComunNCIResponse() == null){
            return false;
        }
        if (response.getConsultaConvivenciaCompletaComunNCIResponse().getConvive() == null ){
            return false;
        }
        if (response.getConsultaConvivenciaCompletaComunNCIResponse().getConvive().isEmpty()){
            return false;
        }

        return true;
    }
}
