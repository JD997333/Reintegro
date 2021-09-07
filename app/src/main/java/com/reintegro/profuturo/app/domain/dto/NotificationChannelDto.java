package com.reintegro.profuturo.app.domain.dto;

public class NotificationChannelDto {
    private String cellPhone;
    private String email;
    private int selectedNotificationChannel;

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSelectedNotificationChannel() {
        return selectedNotificationChannel;
    }

    public void setSelectedNotificationChannel(int selectedNotificationChannel) {
        this.selectedNotificationChannel = selectedNotificationChannel;
    }
}