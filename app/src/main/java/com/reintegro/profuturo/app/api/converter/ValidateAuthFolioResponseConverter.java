package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.ValidateAuthFolioResponse;
import com.reintegro.profuturo.app.util.TypeUtils;
import com.reintegro.profuturo.app.vo.ValidateFolioResult;

public class ValidateAuthFolioResponseConverter extends ResponseConverter<ValidateAuthFolioResponse, ValidateFolioResult>{
    @Override
    public ValidateFolioResult convert(ValidateAuthFolioResponse response) {
        ValidateFolioResult result = new ValidateFolioResult();
        result.setSuccess(TypeUtils.getValueOrDefault(response.getValidateAuthFolioOut().getResult()));
        //result.setSuccess(true);
        result.setMessage(TypeUtils.getValueOrDefault(response.getValidateAuthFolioOut().getStatusText()));
        return result;
    }
}
