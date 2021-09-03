package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.CalculateRepaymentResponse;

public class CalculateRepaymentResponseValidator extends ResponseValidator<CalculateRepaymentResponse>{
    @Override
    public boolean validate(CalculateRepaymentResponse response) {
        if (response.getCalculateRepaymentResp() == null){
            return false;
        }
        if (!response.getCalculateRepaymentResp().getResultadoOperacion().equals("01")){
            return false;
        }

        return true;
    }
}
