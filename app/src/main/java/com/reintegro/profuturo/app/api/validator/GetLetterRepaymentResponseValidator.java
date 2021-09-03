package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.GetLetterRepaymentDocResponse;

public class GetLetterRepaymentResponseValidator extends ResponseValidator<GetLetterRepaymentDocResponse>{
    @Override
    public boolean validate(GetLetterRepaymentDocResponse response) {
        if (response == null){
            return false;
        }
        if (response.getPdf() == null){
            return false;
        }
        if (response.getPdf().isEmpty()){
            return false;
        }
        return true;
    }
}
