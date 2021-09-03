package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.GetRepaymentEventsResponse;
import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.util.TypeUtils;
import com.reintegro.profuturo.app.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class GetRepaymentEventsResponseConverter extends ResponseConverter<GetRepaymentEventsResponse, List<RepaymentEntity>>{
    @Override
    public List<RepaymentEntity> convert(GetRepaymentEventsResponse response) {
        List<RepaymentEntity> repaymentEntities = new ArrayList<>();
        RepaymentEntity repaymentEntity;
        int i = 1;

        for (GetRepaymentEventsResponse.RepaymentEvent event : response.getRepaymentEvents()){
            repaymentEntity = new RepaymentEntity();
            repaymentEntity.setAforeKey(TypeUtils.getValueOrDefault(event.getClaveAforeRetiroReintegro()));
            repaymentEntity.setBenefitType(TypeUtils.getValueOrDefault(event.getTipoPrestacion()));
            repaymentEntity.setDiagnoseProcess(TypeUtils.getValueOrDefault(event.getDiagnosticoProceso()));
            repaymentEntity.setDiscountedWeeks(TypeUtils.getIntValueOrDefault(event.getSemanasDescontadosRecuperadas()));
            repaymentEntity.setEventNumber(i);
            repaymentEntity.setNss(TypeUtils.getValueOrDefault(event.getNssTrabajador()));
            repaymentEntity.setOperationResult(TypeUtils.getValueOrDefault(event.getResultadoOperacion()));
            repaymentEntity.setPreDiscountedWeeks(0);
            repaymentEntity.setPreRepaymentAmount(0.0);
            repaymentEntity.setRepaymentValueDay(TypeUtils.getDoubleValueOrDefault(event.getValorDiaReintegrar()));
            repaymentEntity.setRequestedWeeks(0);
            repaymentEntity.setResolutionNumber(TypeUtils.getValueOrDefault(event.getNumeroResolucion()));
            repaymentEntity.setSelected(false);
            repaymentEntity.setTrdAmount(TypeUtils.getDoubleValueOrDefault(event.getMontoRetiroReintegro()));
            repaymentEntity.setTrdDate(DateResponseConverter.convertFromResponse(event.getFechaRetiroReintegro(), Constants.DATE_FORMAT_5));

            repaymentEntities.add(repaymentEntity);
            i++;
        }

        //TODO delete this code, just for TEST
        /*repaymentEntity = Utils.getRepaymentDummy();
        repaymentEntity.setEventNumber(i);
        repaymentEntities.add(repaymentEntity);
        i++;
        repaymentEntity = Utils.getRepaymentDummy();
        repaymentEntity.setEventNumber(i);
        repaymentEntities.add(repaymentEntity);*/

        return repaymentEntities;
    }
}
