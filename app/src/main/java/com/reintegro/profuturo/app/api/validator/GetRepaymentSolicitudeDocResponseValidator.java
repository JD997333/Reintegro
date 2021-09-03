package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.GetRepaymentSolicitudeDocResponse;

public class GetRepaymentSolicitudeDocResponseValidator extends ResponseValidator<GetRepaymentSolicitudeDocResponse>{
    @Override
    public boolean validate(GetRepaymentSolicitudeDocResponse response) {
        if (response == null){
            return false;
        }
        if (!response.getStatus().equals("200")){
            return false;
        }
        if (response.getPdf() == null){
            return false;
        }
        if (response.getPdf().isEmpty()){
            return false;
        }
        return true;
    }
}
