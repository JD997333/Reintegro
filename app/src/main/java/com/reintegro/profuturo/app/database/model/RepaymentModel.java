package com.reintegro.profuturo.app.database.model;

import com.reintegro.profuturo.app.data.entity.DateEntity;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RepaymentModel extends RealmObject {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    private String aforeKey;
    private String diagnoseProcess;
    private DateModel trdDate;
    private String trdAmount;
    private String nss;
    private String resolutionNumber;
    private String operationResult;
    private String discountedWeeks;
    private String benefitType;
    private String repaymentValueDay;
    private String preRepaymentAmount;
    private Integer eventNumber;
    private Integer preDiscountedWeeks;
    private boolean selected;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAforeKey() {
        return aforeKey;
    }

    public void setAforeKey(String aforeKey) {
        this.aforeKey = aforeKey;
    }

    public String getDiagnoseProcess() {
        return diagnoseProcess;
    }

    public void setDiagnoseProcess(String diagnoseProcess) {
        this.diagnoseProcess = diagnoseProcess;
    }

    public DateModel getTrdDate() {
        return trdDate;
    }

    public void setTrdDate(DateModel trdDate) {
        this.trdDate = trdDate;
    }

    public String getTrdAmount() {
        return trdAmount;
    }

    public void setTrdAmount(String trdAmount) {
        this.trdAmount = trdAmount;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getResolutionNumber() {
        return resolutionNumber;
    }

    public void setResolutionNumber(String resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    public String getDiscountedWeeks() {
        return discountedWeeks;
    }

    public void setDiscountedWeeks(String discountedWeeks) {
        this.discountedWeeks = discountedWeeks;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public String getRepaymentValueDay() {
        return repaymentValueDay;
    }

    public void setRepaymentValueDay(String repaymentValueDay) {
        this.repaymentValueDay = repaymentValueDay;
    }

    public String getPreRepaymentAmount() {
        return preRepaymentAmount;
    }

    public void setPreRepaymentAmount(String preRepaymentAmount) {
        this.preRepaymentAmount = preRepaymentAmount;
    }

    public Integer getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(Integer eventNumber) {
        this.eventNumber = eventNumber;
    }

    public Integer getPreDiscountedWeeks() {
        return preDiscountedWeeks;
    }

    public void setPreDiscountedWeeks(Integer preDiscountedWeeks) {
        this.preDiscountedWeeks = preDiscountedWeeks;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
