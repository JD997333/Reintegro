package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.NotificationChannelEntity;
import com.reintegro.profuturo.app.domain.dto.NotificationChannelDto;

public class NotificationChannelConverter {
    public static NotificationChannelEntity convertFromDto(NotificationChannelDto notificationChannelDto) {
        NotificationChannelEntity notificationChannelEntity;
        notificationChannelEntity = new NotificationChannelEntity();
        notificationChannelEntity.setCellPhone(notificationChannelDto.getCellPhone());
        notificationChannelEntity.setEmail(notificationChannelDto.getEmail());
        notificationChannelEntity.setSelectedNotificationChannel(notificationChannelDto.getSelectedNotificationChannel());

        return notificationChannelEntity;
    }
}
