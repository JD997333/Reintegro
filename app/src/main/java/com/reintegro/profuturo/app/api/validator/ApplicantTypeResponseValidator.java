package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.ApplicantTypeResponse;

public class ApplicantTypeResponseValidator extends ResponseValidator<ApplicantTypeResponse> {
    @Override
    public boolean validate(ApplicantTypeResponse response) {
        if (response.getTipoSolicitanteResponse() == null){
            return false;
        }
        if (response.getTipoSolicitanteResponse().getListaTipoSolicitante() == null){
            return false;
        }
        if (response.getTipoSolicitanteResponse().getListaTipoSolicitante().size() == 0){
            return false;
        }

        return true;
    }
}
