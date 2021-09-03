package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.ApplicantTypeResponse;
import com.reintegro.profuturo.app.data.entity.ProcedureEntity;
import com.reintegro.profuturo.app.vo.ApplicantType;

import java.util.ArrayList;
import java.util.List;

public class ApplicantTypeResponseConverter extends ResponseConverter<ApplicantTypeResponse, List<ApplicantType>>{
    @Override
    public List<ApplicantType> convert(ApplicantTypeResponse applicantTypeResponse) {
        List<ApplicantType> applicantTypes = new ArrayList<>();
        ApplicantType applicantType;

        for (ApplicantTypeResponse.ApplicantType at : applicantTypeResponse.getTipoSolicitanteResponse().getListaTipoSolicitante()){
            applicantType = new ApplicantType();
            applicantType.setId(at.getId());
            applicantType.setDescription(at.getDescripcion());
            applicantTypes.add(applicantType);
        }

        return applicantTypes;
    }
}
