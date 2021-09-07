package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.GetVoluntarySealResponse;
import com.reintegro.profuturo.app.data.entity.ProcedureEntity;

public class GetVoluntarySealResponseConverter extends ResponseConverter<GetVoluntarySealResponse, ProcedureEntity>{
    @Override
    public ProcedureEntity convert(GetVoluntarySealResponse response) {
        ProcedureEntity procedureEntity = new ProcedureEntity();
        procedureEntity.setVerificationResultSeal(response.getSealInformation().getResultadoVerificacion());
        procedureEntity.setVoluntarySeal(response.getSealInformation().getSelloVerificacion());
        return procedureEntity;
    }
}
