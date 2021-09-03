package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InsertClientRequest {
    @SerializedName("insertarClienteRequest")
    @Expose
    private InsertClient insertClientRequest;

    public InsertClient getInsertClientRequest() {
        return insertClientRequest;
    }

    public void setInsertClientRequest(InsertClient insertClientRequest) {
        this.insertClientRequest = insertClientRequest;
    }


    public static class InsertClient {

        @SerializedName("apMaternoCte")
        @Expose
        private String surName;

        @SerializedName("apPaternoCte")
        @Expose
        private String lastName;

        @SerializedName("calle")
        @Expose
        private String street;

        @SerializedName("celular")
        @Expose
        private String cellphone;

        @SerializedName("codigoPostal")
        @Expose
        private String zipCode;

        @SerializedName("colonia")
        @Expose
        private String colony;

        @SerializedName("correoElec")
        @Expose
        private String email;

        @SerializedName("curp")
        @Expose
        private String curp;

        @SerializedName("delegMunicipio")
        @Expose
        private String municipality;

        @SerializedName("estado")
        @Expose
        private String state;

        @SerializedName("noExterior")
        @Expose
        private Integer externalNum;

        @SerializedName("noInterior")
        @Expose
        private String internalNum;

        @SerializedName("nombreCte")
        @Expose
        private String name;

        @SerializedName("nss")
        @Expose
        private String nss;

        @SerializedName("numCtaInvdual")
        @Expose
        private Long accountNumber;

        @SerializedName("rfcCte")
        @Expose
        private String rfc;

        @SerializedName("telefono")
        @Expose
        private String phone;

        @SerializedName("usuCre")
        @Expose
        private String usuCre;


        @SerializedName("fehCre")
        @Expose
        private String fehCre;

        @SerializedName("fehAct")
        @Expose
        private String fehAct;

        @SerializedName("usuAct")
        @Expose
        private String usuAct;

        @SerializedName("idPersona")
        @Expose
        private Long idPersona;

        @SerializedName("tipoCliente")
        @Expose
        private Integer typeClient;


        public InsertClient() {
        }

        public String getSurName() {
            return surName;
        }

        public void setSurName(String surName) {
            this.surName = surName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCellphone() {
            return cellphone;
        }

        public void setCellphone(String cellphone) {
            this.cellphone = cellphone;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getColony() {
            return colony;
        }

        public void setColony(String colony) {
            this.colony = colony;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCurp() {
            return curp;
        }

        public void setCurp(String curp) {
            this.curp = curp;
        }

        public String getMunicipality() {
            return municipality;
        }

        public void setMunicipality(String municipality) {
            this.municipality = municipality;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Integer getExternalNum() {
            return externalNum;
        }

        public void setExternalNum(Integer externalNum) {
            this.externalNum = externalNum;
        }

        public String getInternalNum() {
            return internalNum;
        }

        public void setInternalNum(String internalNum) {
            this.internalNum = internalNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNss() {
            return nss;
        }

        public void setNss(String nss) {
            this.nss = nss;
        }

        public Long getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(Long accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getRfc() {
            return rfc;
        }

        public void setRfc(String rfc) {
            this.rfc = rfc;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUsuCre() {
            return usuCre;
        }

        public void setUsuCre(String usuCre) {
            this.usuCre = usuCre;
        }

        public String getFehCre() {
            return fehCre;
        }

        public void setFehCre(String fehCre) {
            this.fehCre = fehCre;
        }

        public String getFehAct() {
            return fehAct;
        }

        public void setFehAct(String fehAct) {
            this.fehAct = fehAct;
        }

        public String getUsuAct() {
            return usuAct;
        }

        public void setUsuAct(String usuAct) {
            this.usuAct = usuAct;
        }

        public Long getIdPersona() {
            return idPersona;
        }

        public void setIdPersona(Long idPersona) {
            this.idPersona = idPersona;
        }

        public Integer getTypeClient() {
            return typeClient;
        }

        public void setTypeClient(Integer typeClient) {
            this.typeClient = typeClient;
        }
    }
}
