package com.reintegro.profuturo.app.api.validator;

import com.reintegro.profuturo.app.api.vo.GetDocumentsResponse;

public class GetDocumentsResponseValidator extends ResponseValidator<GetDocumentsResponse>{
    @Override
    public boolean validate(GetDocumentsResponse response) {
        if (response == null) {
            return false;
        }

        if (response.getDocuments() == null) {
            return false;
        }

        return true;
    }
}
