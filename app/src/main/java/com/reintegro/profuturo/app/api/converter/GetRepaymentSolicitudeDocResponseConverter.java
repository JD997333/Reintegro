package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.GetRepaymentSolicitudeDocResponse;

public class GetRepaymentSolicitudeDocResponseConverter extends ResponseConverter<GetRepaymentSolicitudeDocResponse, String>{
    @Override
    public String convert(GetRepaymentSolicitudeDocResponse response) {
        return response.getPdf();
    }
}
