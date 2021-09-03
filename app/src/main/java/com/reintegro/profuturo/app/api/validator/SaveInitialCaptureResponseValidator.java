package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.SaveInitialCaptureResponse;
import com.reintegro.profuturo.app.util.Constants;

public class SaveInitialCaptureResponseValidator extends ResponseValidator<SaveInitialCaptureResponse>{
    @Override
    public boolean validate(SaveInitialCaptureResponse response) {
        if (response == null){
            return false;
        }

        if (response.getInitialCaptureResponse() == null){
            return false;
        }

        if (response.getInitialCaptureResponse().getResponseSuccessful() == null){
            return false;
        }

        if (response.getInitialCaptureResponse().getResponseSuccessful().getSuccess().equals(Constants.RESPONSE_FALSE)){
            return false;
        }

        if (response.getInitialCaptureResponse().getFolioBitacoraProceso() == null){
            return false;
        }

        if (response.getInitialCaptureResponse().getFolioTramite() == null){
            return false;
        }

        if (response.getInitialCaptureResponse().getFolioBitacoraProceso().isEmpty()){
            return false;
        }

        if (response.getInitialCaptureResponse().getFolioTramite().isEmpty()){
            return false;
        }

        return true;
    }
}
