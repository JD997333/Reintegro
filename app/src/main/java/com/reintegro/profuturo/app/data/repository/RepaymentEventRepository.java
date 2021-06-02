package com.reintegro.profuturo.app.data.repository;

import com.reintegro.profuturo.app.data.entity.RepaymentEntity;

import java.util.List;

public interface RepaymentEventRepository {
    List<RepaymentEntity> addAll(List<RepaymentEntity> repaymentEntities);
    RepaymentEntity update(RepaymentEntity repaymentEntity);
    RepaymentEntity getSelected();
    List<RepaymentEntity> getAll();
    void clear();
}
