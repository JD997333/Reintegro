package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.UploadFilesToFileNetResponse;

public class UploadFilesToFileNetResponseValidator extends ResponseValidator<UploadFilesToFileNetResponse>{
    @Override
    public boolean validate(UploadFilesToFileNetResponse response) {
        if (response == null){
            return false;
        }
        if (response.getResponse() == null){
            return false;
        }
        if (response.getResponse().getSuccess() == null){
            return false;
        }
        return response.getResponse().getSuccess();
    }
}
