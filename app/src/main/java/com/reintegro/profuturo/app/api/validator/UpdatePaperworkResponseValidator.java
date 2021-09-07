package com.reintegro.profuturo.app.api.validator;


import com.reintegro.profuturo.app.api.vo.UpdatePaperworkResponse;

public class UpdatePaperworkResponseValidator extends ResponseValidator<UpdatePaperworkResponse>{
    @Override
    public boolean validate(UpdatePaperworkResponse response) {

        return response.isSuccess();
    }
}
