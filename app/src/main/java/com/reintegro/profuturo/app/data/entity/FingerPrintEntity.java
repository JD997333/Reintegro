package com.reintegro.profuturo.app.data.entity;


public class FingerPrintEntity {
    private String absenceReason;
    private String base64Image;
    private String captureDate;
    private int fingerPositionCode;
    private String imageHashValue;
    private String nistQualityMeasure;
    private String serialNumber;
    private int isEmployee;

    public String getAbsenceReason() {
        return absenceReason;
    }

    public void setAbsenceReason(String absenceReason) {
        this.absenceReason = absenceReason;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public String getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(String captureDate) {
        this.captureDate = captureDate;
    }

    public int getFingerPositionCode() {
        return fingerPositionCode;
    }

    public void setFingerPositionCode(int fingerPositionCode) {
        this.fingerPositionCode = fingerPositionCode;
    }

    public String getImageHashValue() {
        return imageHashValue;
    }

    public void setImageHashValue(String imageHashValue) {
        this.imageHashValue = imageHashValue;
    }

    public String getNistQualityMeasure() {
        return nistQualityMeasure;
    }

    public void setNistQualityMeasure(String nistQualityMeasure) {
        this.nistQualityMeasure = nistQualityMeasure;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(int isEmployee) {
        this.isEmployee = isEmployee;
    }
}
