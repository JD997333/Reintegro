package com.reintegro.profuturo.app.data.repository;

import com.reintegro.profuturo.app.data.entity.AgentEntity;

public interface AgentRepository {
    AgentEntity add(AgentEntity agentEntity);
    AgentEntity getFirst();
    AgentEntity update(AgentEntity agentEntity);
    void clear();
}
