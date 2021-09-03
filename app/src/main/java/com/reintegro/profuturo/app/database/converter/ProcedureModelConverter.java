package com.reintegro.profuturo.app.database.converter;

import com.reintegro.profuturo.app.data.entity.ProcedureEntity;
import com.reintegro.profuturo.app.database.model.ProcedureModel;

public class ProcedureModelConverter {
    public static ProcedureEntity convertFromModel(ProcedureModel procedureModel){
        ProcedureEntity procedureEntity = new ProcedureEntity();
        procedureEntity.setAuthFolio(procedureModel.getAuthFolio());
        procedureEntity.setBinnacleFolio(procedureModel.getBinnacleFolio());
        procedureEntity.setId(procedureModel.getId());
        procedureEntity.setIdApplicantType(procedureModel.getIdApplicantType());
        procedureEntity.setIdChannel(procedureModel.getIdChannel());
        procedureEntity.setIdChannelStage(procedureModel.getIdChannelStage());
        procedureEntity.setIdProcess(procedureModel.getIdProcess());
        procedureEntity.setIdStage(procedureModel.getIdStage());
        procedureEntity.setIdStatusVoluntarySeal(procedureModel.getIdStatusVoluntarySeal());
        procedureEntity.setIdSubProcess(procedureModel.getIdSubProcess());
        procedureEntity.setIdSubStage(procedureModel.getIdSubStage());
        procedureEntity.setProcedureDate(DateConverter.convertFromModel(procedureModel.getProcedureDate()));
        procedureEntity.setProcedureFolio(procedureModel.getProcedureFolio());
        procedureEntity.setApplicantCurp(procedureModel.getApplicantCurp());

        return procedureEntity;
    }

    public static ProcedureModel convertFromEntity(ProcedureEntity procedureEntity){
        ProcedureModel procedureModel = new ProcedureModel();
        procedureModel.setAuthFolio(procedureEntity.getAuthFolio());
        procedureModel.setBinnacleFolio(procedureEntity.getBinnacleFolio());
        procedureModel.setIdApplicantType(procedureEntity.getIdApplicantType());
        procedureModel.setIdChannel(procedureEntity.getIdChannel());
        procedureModel.setIdChannelStage(procedureEntity.getIdChannelStage());
        procedureModel.setIdProcess(procedureEntity.getIdProcess());
        procedureModel.setIdStage(procedureEntity.getIdStage());
        procedureModel.setIdStatusVoluntarySeal(procedureEntity.getIdStatusVoluntarySeal());
        procedureModel.setIdSubProcess(procedureEntity.getIdSubProcess());
        procedureModel.setIdSubStage(procedureEntity.getIdSubStage());
        procedureModel.setProcedureDate(DateConverter.convertFromEntity(procedureEntity.getProcedureDate()));
        procedureModel.setProcedureFolio(procedureEntity.getProcedureFolio());
        procedureModel.setApplicantCurp(procedureEntity.getApplicantCurp());

        boolean hasId;
        hasId = procedureEntity.getId() != null;

        if (hasId) {
            procedureModel.setId(procedureEntity.getId());
        }

        return procedureModel;
    }
}
