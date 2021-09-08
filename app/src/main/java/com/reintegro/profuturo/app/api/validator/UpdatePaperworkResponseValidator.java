package com.reintegro.profuturo.app.api.validator;


import com.reintegro.profuturo.app.api.vo.UpdatePaperworkResponse;
import com.reintegro.profuturo.app.util.TypeUtils;

public class UpdatePaperworkResponseValidator extends ResponseValidator<UpdatePaperworkResponse>{


    @Override
    public boolean validate(UpdatePaperworkResponse response) {
        if (response == null) {
            return false;
        }

        return TypeUtils.getBooleanValueOrDefault(response.getActualizarTramiteResponse().getSuccess());
    }
}
