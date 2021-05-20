package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

public class GetAgentInformationResponse {
    public class AgentInformation {
        @SerializedName("apellidoMaterno") private String motherLastName;
        @SerializedName("apellidoPaterno") private String fatherLastName;
        @SerializedName("centroCosto") private String costCenter;
        @SerializedName("claveConsar") private String consarKey;
        @SerializedName("curp") private String curp;
        @SerializedName("email") private String email;
        @SerializedName("fechaAltaConsar") private String consarRegistrationDate;
        @SerializedName("nombre") private String name;
        @SerializedName("numeroEmpleado") private String agentNumber;
        @SerializedName("userId") private String userId;

        public String getMotherLastName() {
            return motherLastName;
        }

        public String getFatherLastName() {
            return fatherLastName;
        }

        public String getCostCenter() {
            return costCenter;
        }

        public String getConsarKey() {
            return consarKey;
        }

        public String getCurp() {
            return curp;
        }

        public String getEmail() {
            return email;
        }

        public String getConsarRegistrationDate() {
            return consarRegistrationDate;
        }

        public String getName() {
            return name;
        }

        public String getAgentNumber() {
            return agentNumber;
        }

        public String getUserId() {
            return userId;
        }
    }

    @SerializedName("empleado") private AgentInformation agent;

    public AgentInformation getAgentInformation() {
        return agent;
    }
}
