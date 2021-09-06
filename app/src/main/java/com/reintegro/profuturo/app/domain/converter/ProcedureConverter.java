package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.ProcedureEntity;
import com.reintegro.profuturo.app.domain.dto.ProcedureDto;

public class ProcedureConverter {

    public static ProcedureDto convertFromEntity(ProcedureEntity procedureEntity){
        ProcedureDto procedureDto = new ProcedureDto();
        procedureDto.setAuthFolio(procedureEntity.getAuthFolio());
        procedureDto.setBinnacleFolio(procedureEntity.getBinnacleFolio());
        procedureDto.setId(procedureEntity.getId());
        procedureDto.setIdApplicantType(procedureEntity.getIdApplicantType());
        procedureDto.setIdChannel(procedureEntity.getIdChannel());
        procedureDto.setIdChannelStage(procedureEntity.getIdChannelStage());
        procedureDto.setIdProcess(procedureEntity.getIdProcess());
        procedureDto.setIdStage(procedureEntity.getIdStage());
        procedureDto.setIdStatusVoluntarySeal(procedureEntity.getIdStatusVoluntarySeal());
        procedureDto.setIdSubProcess(procedureEntity.getIdSubProcess());
        procedureDto.setIdSubStage(procedureEntity.getIdSubStage());
        procedureDto.setProcedureDate(DateConverter.convertFromEntity(procedureEntity.getProcedureDate()));
        procedureDto.setProcedureFolio(procedureEntity.getProcedureFolio());
        procedureDto.setApplicantCurp(procedureEntity.getApplicantCurp());
        procedureDto.setVerificationResultSeal(procedureEntity.getVerificationResultSeal());

        return procedureDto;
    }

    public static ProcedureEntity convertFromDto(ProcedureDto procedureDto){
        ProcedureEntity procedureEntity = new ProcedureEntity();
        procedureEntity.setAuthFolio(procedureDto.getAuthFolio());
        procedureEntity.setBinnacleFolio(procedureDto.getBinnacleFolio());
        procedureEntity.setId(procedureDto.getId());
        procedureEntity.setIdApplicantType(procedureDto.getIdApplicantType());
        procedureEntity.setIdChannel(procedureDto.getIdChannel());
        procedureEntity.setIdChannelStage(procedureDto.getIdChannelStage());
        procedureEntity.setIdProcess(procedureDto.getIdProcess());
        procedureEntity.setIdStage(procedureDto.getIdStage());
        procedureEntity.setIdStatusVoluntarySeal(procedureDto.getIdStatusVoluntarySeal());
        procedureEntity.setIdSubProcess(procedureDto.getIdSubProcess());
        procedureEntity.setIdSubStage(procedureDto.getIdSubStage());
        procedureEntity.setProcedureDate(DateConverter.convertFromDto(procedureDto.getProcedureDate()));
        procedureEntity.setProcedureFolio(procedureDto.getProcedureFolio());
        procedureEntity.setApplicantCurp(procedureDto.getApplicantCurp());
        procedureEntity.setVerificationResultSeal(procedureDto.getVerificationResultSeal());

        return procedureEntity;
    }
}
