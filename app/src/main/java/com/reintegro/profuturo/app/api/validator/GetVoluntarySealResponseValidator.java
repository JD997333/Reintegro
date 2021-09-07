package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.GetVoluntarySealResponse;

public class GetVoluntarySealResponseValidator extends ResponseValidator<GetVoluntarySealResponse>{
    @Override
    public boolean validate(GetVoluntarySealResponse response) {
        if (response == null){
            return false;
        }
        if (response.getStatus() != 200){
            return false;
        }
        if (response.getSealInformation() == null){
            return false;
        }
        if (response.getSealInformation().getSelloVerificacion() == null){
            return false;
        }
        if (response.getSealInformation().getSelloVerificacion().isEmpty()){
            return false;
        }
        return true;
    }
}
