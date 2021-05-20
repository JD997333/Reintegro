package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.GetClientImageResponse;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.util.TypeUtils;

public class GetClientImageResponseConverter extends ResponseConverter<GetClientImageResponse, ClientEntity> {
    @Override
    public ClientEntity convert(GetClientImageResponse response) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setImage(response.getImage().getImage());
        clientEntity.setImageId(TypeUtils.getValueOrDefault(response.getImage().getImageId()));

        return clientEntity;
    }
}
