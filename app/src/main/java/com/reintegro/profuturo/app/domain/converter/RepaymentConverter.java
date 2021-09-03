package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;

import java.util.ArrayList;
import java.util.List;

public class RepaymentConverter {
    public static RepaymentDto convertFromEntity(RepaymentEntity repaymentEntity){
        RepaymentDto repaymentDto = new RepaymentDto();
        repaymentDto.setId(repaymentEntity.getId());
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
        repaymentDto.setRequestedWeeks(repaymentEntity.getRequestedWeeks());
        repaymentDto.setCalculatedAmount(repaymentEntity.getCalculatedAmount());
        repaymentDto.setSelected(repaymentEntity.isSelected());
        repaymentDto.setWeekAmountValue(repaymentEntity.getWeekAmountValue());
        repaymentDto.setMaxWeeksRepayment(repaymentEntity.getMaxWeeksRepayment());

        return repaymentDto;
    }

    public static RepaymentEntity convertFromDto(RepaymentDto repaymentDto){
        RepaymentEntity repaymentEntity = new RepaymentEntity();
        repaymentEntity.setId(repaymentDto.getId());
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
        repaymentEntity.setRequestedWeeks(repaymentEntity.getRequestedWeeks());
        repaymentEntity.setCalculatedAmount(repaymentEntity.getCalculatedAmount());
        repaymentEntity.setSelected(repaymentDto.isSelected());
        repaymentEntity.setWeekAmountValue(repaymentDto.getWeekAmountValue());
        repaymentEntity.setMaxWeeksRepayment(repaymentDto.getMaxWeeksRepayment());

        return repaymentEntity;
    }

    public static List<RepaymentDto> convertFromEntities(List<RepaymentEntity> repaymentEntities){
        List<RepaymentDto> repaymentDtos = new ArrayList<>();

        for (RepaymentEntity repaymentEntity :  repaymentEntities){
            repaymentDtos.add(convertFromEntity(repaymentEntity));
        }

        return repaymentDtos;
    }

    public static List<RepaymentEntity> convertFromDtos(List<RepaymentDto> repaymentDtos){
        List<RepaymentEntity> repaymentEntities = new ArrayList<>();

        for(RepaymentDto repaymentDto : repaymentDtos){
            repaymentEntities.add(convertFromDto(repaymentDto));
        }

        return repaymentEntities;
    }
}
