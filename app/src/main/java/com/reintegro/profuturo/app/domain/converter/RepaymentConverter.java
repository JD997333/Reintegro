package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;

import java.util.ArrayList;
import java.util.List;

public class RepaymentConverter {
    public static RepaymentDto convertFromEntity(RepaymentEntity repaymentEntity){
        RepaymentDto repaymentDto = new RepaymentDto();
        repaymentDto.setAforeKey(repaymentEntity.getAforeKey());
        repaymentDto.setBenefitType(repaymentEntity.getBenefitType());
        repaymentDto.setDiagnoseProcess(repaymentEntity.getDiagnoseProcess());
        repaymentDto.setDiscountedWeeks(repaymentEntity.getDiscountedWeeks());
        repaymentDto.setEventNumber(repaymentEntity.getEventNumber());
        repaymentDto.setNss(repaymentEntity.getNss());
        repaymentDto.setOperationResult(repaymentEntity.getOperationResult());
        repaymentDto.setPreDiscountedWeeks(repaymentEntity.getPreDiscountedWeeks());
        repaymentDto.setPreRepaymentAmount(repaymentEntity.getPreRepaymentAmount());
        repaymentDto.setRepaymentValueDay(repaymentEntity.getRepaymentValueDay());
        repaymentDto.setResolutionNumber(repaymentEntity.getResolutionNumber());
        repaymentDto.setTrdAmount(repaymentEntity.getTrdAmount());
        repaymentDto.setTrdDate(DateConverter.convertFromEntity(repaymentEntity.getTrdDate()));
        repaymentDto.setSelected(repaymentEntity.isSelected());

        return repaymentDto;
    }

    public static RepaymentEntity convertFromDto(RepaymentDto repaymentDto){
        RepaymentEntity repaymentEntity = new RepaymentEntity();
        repaymentEntity.setAforeKey(repaymentDto.getAforeKey());
        repaymentEntity.setBenefitType(repaymentDto.getBenefitType());
        repaymentEntity.setDiagnoseProcess(repaymentDto.getDiagnoseProcess());
        repaymentEntity.setDiscountedWeeks(repaymentDto.getDiscountedWeeks());
        repaymentEntity.setEventNumber(repaymentDto.getEventNumber());
        repaymentEntity.setNss(repaymentDto.getNss());
        repaymentEntity.setOperationResult(repaymentDto.getOperationResult());
        repaymentEntity.setPreDiscountedWeeks(repaymentDto.getPreDiscountedWeeks());
        repaymentEntity.setPreRepaymentAmount(repaymentDto.getPreRepaymentAmount());
        repaymentEntity.setRepaymentValueDay(repaymentDto.getRepaymentValueDay());
        repaymentEntity.setResolutionNumber(repaymentDto.getResolutionNumber());
        repaymentEntity.setTrdAmount(repaymentDto.getTrdAmount());
        repaymentEntity.setTrdDate(DateConverter.convertFromDto(repaymentDto.getTrdDate()));
        repaymentEntity.setSelected(repaymentDto.isSelected());

        return repaymentEntity;
    }

    public static List<RepaymentDto> convertFromEntities(List<RepaymentEntity> repaymentEntities){
        List<RepaymentDto> repaymentDtos = new ArrayList<>();

        for (RepaymentEntity repaymentEntity :  repaymentEntities){
            repaymentDtos.add(convertFromEntity(repaymentEntity));
        }

        return repaymentDtos;
    }
}
