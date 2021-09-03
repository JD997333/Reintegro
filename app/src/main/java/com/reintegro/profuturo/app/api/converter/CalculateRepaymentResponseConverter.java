package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.CalculateRepaymentResponse;
import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.util.TypeUtils;

public class CalculateRepaymentResponseConverter extends ResponseConverter<CalculateRepaymentResponse, RepaymentEntity>{
    @Override
    public RepaymentEntity convert(CalculateRepaymentResponse response) {
        RepaymentEntity repaymentEntity = new RepaymentEntity();
        repaymentEntity.setCalculatedAmount(TypeUtils.getDoubleValueOrDefault(response.getCalculateRepaymentResp().getMontoReintegrar()));
        repaymentEntity.setDiscountedWeeks(TypeUtils.getIntValueOrDefault(response.getCalculateRepaymentResp().getMaxSemanasReintegrar()));
        return repaymentEntity;
    }
}
