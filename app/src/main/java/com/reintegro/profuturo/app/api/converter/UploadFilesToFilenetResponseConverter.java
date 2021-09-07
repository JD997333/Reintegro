package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.UploadFilesToFileNetResponse;

public class UploadFilesToFilenetResponseConverter extends ResponseConverter<UploadFilesToFileNetResponse, Boolean> {
    @Override
    public Boolean convert(UploadFilesToFileNetResponse response) {
        return response.getResponse().getSuccess();
    }
}