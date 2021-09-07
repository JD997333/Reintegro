package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.GetRepaymentEventsResponse;

public class GetRepaymentEventsResponseValidator extends ResponseValidator<GetRepaymentEventsResponse>{
    @Override
    public boolean validate(GetRepaymentEventsResponse response) {
        if (response.getRepaymentEvents() == null){
            return false;
        }
        if (response.getRepaymentEvents().size() == 0){
            return false;
        }
        if (response.getRepaymentEvents().get(0).getResultadoOperacion() == null){
            return false;
        }
        if (response.getRepaymentEvents().get(0).getResultadoOperacion().equals("02")){
            return false;//TODO change to false before commit TEST
        }
        return true;
    }
}
