package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.GetClientImageResponse;

public class GetClientImageResponseValidator extends ResponseValidator<GetClientImageResponse> {
    public boolean validate(GetClientImageResponse response) {
        if (response == null) {
            return false;
        }

        if (response.getImage() == null) {
            return false;
        }

        return true;
    }
}
