package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.GetLetterRepaymentDocResponse;

public class GetLetterRepaymentResponseConverter extends ResponseConverter<GetLetterRepaymentDocResponse, String>{
    @Override
    public String convert(GetLetterRepaymentDocResponse response) {
        return response.getPdf();
    }
}
