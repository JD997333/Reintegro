package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.ClientSocialNetworkEntity;
import com.reintegro.profuturo.app.domain.dto.ClientSocialNetworkDto;

public class ClientSocialNetworkConverter {
    public static ClientSocialNetworkDto convertFromEntity(ClientSocialNetworkEntity clientSocialNetworkEntity) {
        ClientSocialNetworkDto clientSocialNetworkDto;
        clientSocialNetworkDto = new ClientSocialNetworkDto();
        clientSocialNetworkDto.setId(clientSocialNetworkEntity.getId());
        clientSocialNetworkDto.setNetworkSocialType(ClientSocialNetworkTypeConverter.convertFromEntity(clientSocialNetworkEntity.getNetworkSocialType()));
        clientSocialNetworkDto.setPreferential(clientSocialNetworkEntity.isPreferential());
        clientSocialNetworkDto.setValue(clientSocialNetworkDto.getValue());

        return clientSocialNetworkDto;
    }

    public static ClientSocialNetworkEntity convertFromDto(ClientSocialNetworkDto clientSocialNetworkDto) {
        ClientSocialNetworkEntity clientSocialNetworkEntity;
        clientSocialNetworkEntity = new ClientSocialNetworkEntity();
        clientSocialNetworkEntity.setId(clientSocialNetworkDto.getId());
        clientSocialNetworkEntity.setNetworkSocialType(ClientSocialNetworkTypeConverter.convertFromDto(clientSocialNetworkDto.getNetworkSocialType()));
        clientSocialNetworkEntity.setPreferential(clientSocialNetworkDto.isPreferential());
        clientSocialNetworkEntity.setValue(clientSocialNetworkDto.getValue());

        return clientSocialNetworkEntity;
    }
}
