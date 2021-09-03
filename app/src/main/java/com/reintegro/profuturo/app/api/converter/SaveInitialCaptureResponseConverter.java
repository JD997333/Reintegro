package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.SaveInitialCaptureResponse;
import com.reintegro.profuturo.app.data.entity.ProcedureEntity;

public class SaveInitialCaptureResponseConverter extends ResponseConverter<SaveInitialCaptureResponse, ProcedureEntity>{
    @Override
    public ProcedureEntity convert(SaveInitialCaptureResponse response) {
        ProcedureEntity procedureEntity = new ProcedureEntity();
        procedureEntity.setBinnacleFolio(response.getInitialCaptureResponse().getFolioBitacoraProceso());
        procedureEntity.setProcedureFolio(response.getInitialCaptureResponse().getFolioTramite());

        return procedureEntity;
    }
}
