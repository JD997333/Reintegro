package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.ClientEmailEntity;
import com.reintegro.profuturo.app.domain.dto.ClientEmailDto;

public class ClientEmailConverter {
    public static ClientEmailDto convertFromEntity(ClientEmailEntity clientEmailEntity) {
        ClientEmailDto clientEmailDto;
        clientEmailDto = new ClientEmailDto();
        clientEmailDto.setEmail(clientEmailEntity.getEmail());
        clientEmailDto.setEmailType(clientEmailEntity.getEmailType());
        clientEmailDto.setId(clientEmailEntity.getId());
        clientEmailDto.setPreferential(clientEmailEntity.isPreferential());
        clientEmailDto.setValidEmail(clientEmailEntity.isValidEmail());

        return clientEmailDto;
    }

    public static ClientEmailEntity convertFromDto(ClientEmailDto clientEmailDto) {
        ClientEmailEntity clientEmailEntity;
        clientEmailEntity = new ClientEmailEntity();
        clientEmailEntity.setEmail(clientEmailDto.getEmail());
        clientEmailEntity.setEmailType(clientEmailDto.getEmailType());
        clientEmailEntity.setId(clientEmailDto.getId());
        clientEmailEntity.setPreferential(clientEmailDto.isPreferential());
        clientEmailEntity.setValidEmail(clientEmailDto.isValidEmail());

        return clientEmailEntity;
    }
}