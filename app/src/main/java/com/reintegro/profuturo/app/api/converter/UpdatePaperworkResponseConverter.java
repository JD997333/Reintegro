package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.UpdatePaperworkResponse;

public class UpdatePaperworkResponseConverter extends ResponseConverter<UpdatePaperworkResponse, Boolean> {
    @Override
    public Boolean convert(UpdatePaperworkResponse response) {
        return response.isSuccess();
    }

}
