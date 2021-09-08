package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.UpdatePaperworkResponse;
import com.reintegro.profuturo.app.util.TypeUtils;

public class UpdatePaperworkResponseConverter extends ResponseConverter<UpdatePaperworkResponse, Boolean> {
    @Override
    public Boolean convert(UpdatePaperworkResponse response) {
        return TypeUtils.getBooleanValueOrDefault(response.getActualizarTramiteResponse().getSuccess());
    }

}
