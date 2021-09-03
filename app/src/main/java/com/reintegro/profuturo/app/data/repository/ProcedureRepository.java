package com.reintegro.profuturo.app.data.repository;

import com.reintegro.profuturo.app.data.entity.ProcedureEntity;

public interface ProcedureRepository {
    ProcedureEntity add(ProcedureEntity procedureEntity);
    ProcedureEntity getFirst();
    ProcedureEntity update(ProcedureEntity procedureEntity);
    void clear();
}
