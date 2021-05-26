package com.reintegro.profuturo.app.domain.dto;

public class RepaymentDto {
    private int eventNumber;
    private int discountedWeeks;
    private int preDiscountedWeeks;
    private Double trdAmount;
    private Double preRepaymentAmount;
    private String trdDate;

    public int getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(int eventNumber) {
        this.eventNumber = eventNumber;
    }

    public int getDiscountedWeeks() {
        return discountedWeeks;
    }

    public void setDiscountedWeeks(int discountedWeeks) {
        this.discountedWeeks = discountedWeeks;
    }

    public int getPreDiscountedWeeks() {
        return preDiscountedWeeks;
    }

    public void setPreDiscountedWeeks(int preDiscountedWeeks) {
        this.preDiscountedWeeks = preDiscountedWeeks;
    }

    public Double getTrdAmount() {
        return trdAmount;
    }

    public void setTrdAmount(Double trdAmount) {
        this.trdAmount = trdAmount;
    }

    public Double getPreRepaymentAmount() {
        return preRepaymentAmount;
    }

    public void setPreRepaymentAmount(Double preRepaymentAmount) {
        this.preRepaymentAmount = preRepaymentAmount;
    }

    public String getTrdDate() {
        return trdDate;
    }

    public void setTrdDate(String trdDate) {
        this.trdDate = trdDate;
    }
}
