package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.SaveVoluntarySealResponse;

public class SaveVoluntarySealResponseValidator extends ResponseValidator<SaveVoluntarySealResponse>{
    @Override
    public boolean validate(SaveVoluntarySealResponse response) {
        if (response == null){
            return false;
        }
        if (response.getSaveVoluntarySealRespBody() == null){
            return false;
        }
        if (response.getSaveVoluntarySealRespBody().getEstatus() == null){
            return false;
        }
        return response.getSaveVoluntarySealRespBody().getEstatus();
    }
}
