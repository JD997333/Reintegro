package com.reintegro.profuturo.app.data.entity;

public class RepaymentEntity {
    private String id;
    private String aforeKey;
    private String diagnoseProcess;
    private DateEntity trdDate;
    private Double trdAmount;
    private String nss;
    private String resolutionNumber;
    private String operationResult;
    private Integer discountedWeeks;
    private String benefitType;
    private Double repaymentValueDay;
    private Double preRepaymentAmount;
    private Integer eventNumber;
    private Integer preDiscountedWeeks;
    private Integer requestedWeeks;
    private Double calculatedAmount;
    private Double weekAmountValue;
    private Integer maxWeeksRepayment;
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

    public DateEntity getTrdDate() {
        return trdDate;
    }

    public void setTrdDate(DateEntity trdDate) {
        this.trdDate = trdDate;
    }

    public Double getTrdAmount() {
        return trdAmount;
    }

    public void setTrdAmount(Double trdAmount) {
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

    public Integer getDiscountedWeeks() {
        return discountedWeeks;
    }

    public void setDiscountedWeeks(Integer discountedWeeks) {
        this.discountedWeeks = discountedWeeks;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public Double getRepaymentValueDay() {
        return repaymentValueDay;
    }

    public void setRepaymentValueDay(Double repaymentValueDay) {
        this.repaymentValueDay = repaymentValueDay;
    }

    public Double getPreRepaymentAmount() {
        return preRepaymentAmount;
    }

    public void setPreRepaymentAmount(Double preRepaymentAmount) {
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

    public Integer getRequestedWeeks() {
        return requestedWeeks;
    }

    public void setRequestedWeeks(Integer requestedWeeks) {
        this.requestedWeeks = requestedWeeks;
    }

    public Double getCalculatedAmount() {
        return calculatedAmount;
    }

    public void setCalculatedAmount(Double calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }

    public Double getWeekAmountValue() {
        return weekAmountValue;
    }

    public void setWeekAmountValue(Double weekAmountValue) {
        this.weekAmountValue = weekAmountValue;
    }

    public Integer getMaxWeeksRepayment() {
        return maxWeeksRepayment;
    }

    public void setMaxWeeksRepayment(Integer maxWeeksRepayment) {
        this.maxWeeksRepayment = maxWeeksRepayment;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
