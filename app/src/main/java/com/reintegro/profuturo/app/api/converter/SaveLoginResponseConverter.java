package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.SaveLoginResponse;

public class SaveLoginResponseConverter extends ResponseConverter<SaveLoginResponse, Boolean> {
    @Override
    public Boolean convert(SaveLoginResponse response) {
        return response.isSuccess();
    }
}
