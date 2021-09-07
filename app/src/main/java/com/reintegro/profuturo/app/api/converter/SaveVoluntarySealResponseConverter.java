package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.SaveVoluntarySealResponse;

public class SaveVoluntarySealResponseConverter extends ResponseConverter<SaveVoluntarySealResponse, Boolean>{
    @Override
    public Boolean convert(SaveVoluntarySealResponse response) {
        return response.getSaveVoluntarySealRespBody().getEstatus();
    }
}
