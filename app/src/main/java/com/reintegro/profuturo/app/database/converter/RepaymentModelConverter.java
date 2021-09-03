package com.reintegro.profuturo.app.database.converter;

import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.database.model.RepaymentModel;

import java.util.ArrayList;
import java.util.List;

public class RepaymentModelConverter {
    public static RepaymentEntity convertFromModel(RepaymentModel repaymentModel){
        RepaymentEntity repaymentEntity = new RepaymentEntity();
        repaymentEntity.setId(repaymentModel.getId());
        repaymentEntity.setAforeKey(repaymentModel.getAforeKey());
        repaymentEntity.setBenefitType(repaymentModel.getBenefitType());
        repaymentEntity.setDiagnoseProcess(repaymentModel.getDiagnoseProcess());
        repaymentEntity.setDiscountedWeeks(repaymentModel.getDiscountedWeeks());
        repaymentEntity.setEventNumber(repaymentModel.getEventNumber());
        repaymentEntity.setNss(repaymentModel.getNss());
        repaymentEntity.setOperationResult(repaymentModel.getOperationResult());
        repaymentEntity.setPreDiscountedWeeks(repaymentModel.getPreDiscountedWeeks());
        repaymentEntity.setPreRepaymentAmount(repaymentModel.getPreRepaymentAmount());
        repaymentEntity.setRepaymentValueDay(repaymentModel.getRepaymentValueDay());
        repaymentEntity.setResolutionNumber(repaymentModel.getResolutionNumber());
        repaymentEntity.setTrdAmount(repaymentModel.getTrdAmount());
        repaymentEntity.setTrdDate(DateConverter.convertFromModel(repaymentModel.getTrdDate()));
        repaymentEntity.setRequestedWeeks(repaymentModel.getRequestedWeeks());
        repaymentEntity.setCalculatedAmount(repaymentModel.getCalculatedAmount());
        repaymentEntity.setSelected(repaymentModel.isSelected());
        repaymentEntity.setWeekAmountValue(repaymentModel.getWeekAmountValue());
        repaymentEntity.setMaxWeeksRepayment(repaymentModel.getMaxWeeksRepayment());

        return repaymentEntity;
    }

    public static RepaymentModel convertFromEntity(RepaymentEntity repaymentEntity){
        RepaymentModel repaymentModel = new RepaymentModel();
        repaymentModel.setAforeKey(repaymentEntity.getAforeKey());
        repaymentModel.setBenefitType(repaymentEntity.getBenefitType());
        repaymentModel.setDiagnoseProcess(repaymentEntity.getDiagnoseProcess());
        repaymentModel.setDiscountedWeeks(repaymentEntity.getDiscountedWeeks());
        repaymentModel.setEventNumber(repaymentEntity.getEventNumber());
        repaymentModel.setNss(repaymentEntity.getNss());
        repaymentModel.setOperationResult(repaymentEntity.getOperationResult());
        repaymentModel.setPreDiscountedWeeks(repaymentEntity.getPreDiscountedWeeks());
        repaymentModel.setPreRepaymentAmount(repaymentEntity.getPreRepaymentAmount());
        repaymentModel.setRepaymentValueDay(repaymentEntity.getRepaymentValueDay());
        repaymentModel.setResolutionNumber(repaymentEntity.getResolutionNumber());
        repaymentModel.setTrdAmount(repaymentEntity.getTrdAmount());
        repaymentModel.setTrdDate(DateConverter.convertFromEntity(repaymentEntity.getTrdDate()));
        repaymentModel.setRequestedWeeks(repaymentEntity.getRequestedWeeks());
        repaymentModel.setCalculatedAmount(repaymentEntity.getCalculatedAmount());
        repaymentModel.setSelected(repaymentEntity.isSelected());
        repaymentModel.setWeekAmountValue(repaymentEntity.getWeekAmountValue());
        repaymentModel.setMaxWeeksRepayment(repaymentEntity.getMaxWeeksRepayment());

        boolean hasId;
        hasId = repaymentEntity.getId() != null;

        if (hasId){
            repaymentModel.setId(repaymentEntity.getId());
        }

        return repaymentModel;
    }

    public static List<RepaymentModel> convertFromEntities(List<RepaymentEntity> repaymentEntities){
        List<RepaymentModel> repaymentModels = new ArrayList<>();

        for (RepaymentEntity repaymentEntity : repaymentEntities){
            repaymentModels.add(convertFromEntity(repaymentEntity));
        }

        return repaymentModels;
    }

    public static List<RepaymentEntity> convertFromModels(List<RepaymentModel> repaymentModels){
        List<RepaymentEntity> repaymentEntities = new ArrayList<>();

        for (RepaymentModel repaymentModel : repaymentModels){
            repaymentEntities.add(convertFromModel(repaymentModel));
        }

        return repaymentEntities;
    }
}
