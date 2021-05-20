package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

public class GetAgentInformationRequest {
    public static class AgentNumber {
        @SerializedName("usuario") private String agentNumber;

        public void setAgentNumber(String agentNumber) {
            this.agentNumber = agentNumber;
        }
    }

    @SerializedName("rqt") private AgentNumber agentNumber;

    public void setAgentNumber(AgentNumber agentNumber) {
        this.agentNumber = agentNumber;
    }
}
