package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.ClientSocialNetworkTypeEntity;
import com.reintegro.profuturo.app.domain.dto.ClientSocialNetworkTypeDto;

public class ClientSocialNetworkTypeConverter {
    public static ClientSocialNetworkTypeDto convertFromEntity(ClientSocialNetworkTypeEntity clientSocialNetworkTypeEntity) {
        ClientSocialNetworkTypeDto clientSocialNetworkTypeDto;
        clientSocialNetworkTypeDto = new ClientSocialNetworkTypeDto();
        clientSocialNetworkTypeDto.setDescription(clientSocialNetworkTypeEntity.getDescription());
        clientSocialNetworkTypeDto.setId(clientSocialNetworkTypeEntity.getId());
        clientSocialNetworkTypeDto.setKey(clientSocialNetworkTypeEntity.getKey());

        return clientSocialNetworkTypeDto;
    }

    public static ClientSocialNetworkTypeEntity convertFromDto(ClientSocialNetworkTypeDto clientSocialNetworkTypeDto) {
        ClientSocialNetworkTypeEntity clientSocialNetworkTypeEntity;
        clientSocialNetworkTypeEntity = new ClientSocialNetworkTypeEntity();
        clientSocialNetworkTypeEntity.setDescription(clientSocialNetworkTypeDto.getDescription());
        clientSocialNetworkTypeEntity.setId(clientSocialNetworkTypeDto.getId());
        clientSocialNetworkTypeEntity.setKey(clientSocialNetworkTypeDto.getKey());

        return clientSocialNetworkTypeEntity;
    }
}
