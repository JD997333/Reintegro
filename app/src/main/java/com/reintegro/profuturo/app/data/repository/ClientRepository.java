package com.reintegro.profuturo.app.data.repository;

import com.reintegro.profuturo.app.data.entity.ClientEntity;

import java.util.List;

public interface ClientRepository {
    ClientEntity getSelected();
    ClientEntity update(ClientEntity clientEntity);
    List<ClientEntity> addAll(List<ClientEntity> clientEntities);
    List<ClientEntity> getAll();
    void clear();
}
