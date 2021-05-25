package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetClientDataResponse {
    public class Client {
        @SerializedName("apellidoMaterno") private String motherLastName;
        @SerializedName("apellidoPaterno") private String fatherLastName;
        @SerializedName("calle") private String street;
        @SerializedName("codigoPostal") private String postalCode;
        @SerializedName("colonia") private String neighborhood;
        @SerializedName("correos") private List<ClientEmail> emails;
        @SerializedName("cuentaVigente") private String accountValidity;
        @SerializedName("curp") private String curp;
        @SerializedName("descripcionIndicadorBiometrico") private String biometricIndicatorDescription;
        @SerializedName("descripcionIndicadorExpediente") private String identificationIndicatorDescription;
        @SerializedName("descripcionIndicadorTipoCliente") private String clientTypeIndicatorDescription;
        @SerializedName("entidadFederativa") private String federalEntity;
        @SerializedName("estatus") private String status;
        @SerializedName("estatusCuenta") private String accountStatus;
        @SerializedName("estatusIndicadorBiometrico") private String  biometricIndicatorStatus;
        @SerializedName("estatusIndicadorExpediente") private String identificationIndicatorStatus;
        @SerializedName("estatusTipoCliente") private String clientTypeStatus;
        @SerializedName("fechaNacimiento") private String birthday;
        @SerializedName("idContrato") private String agreementId;
        @SerializedName("idPersona") private  String personId;
        @SerializedName("municipio") private String town;
        @SerializedName("nombre") private String name;
        @SerializedName("nss") private String nss;
        @SerializedName("numeroCuenta") private String accountNumber;
        @SerializedName("origenAfiliacion") private String affiliationOrigin;
        @SerializedName("redesSociales") private List<SocialNetwork> socialNetworks;
        @SerializedName("regimenAfiliacion") private String affiliationRegime;
        @SerializedName("rfc") private String rfc;
        @SerializedName("sexo") private String sex;
        @SerializedName("telefonos") private List<ClientPhone> phones;
        @SerializedName("valorIndicadorBiometrico") private Integer biometricIndicatorValue;
        @SerializedName("valorIndicadorExpediente") private Long identificationIndicatorValue;
        @SerializedName("valorIndicadorTipoCliente") private Long clientTypeIndicatorValue;

        public String getMotherLastName() {
            return motherLastName;
        }

        public String getFatherLastName() {
            return fatherLastName;
        }

        public String getStreet() {
            return street;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public String getNeighborhood() {
            return neighborhood;
        }

        public List<ClientEmail> getEmails() {
            return emails;
        }

        public String getAccountValidity() {
            return accountValidity;
        }

        public String getCurp() {
            return curp;
        }

        public String getBiometricIndicatorDescription() {
            return biometricIndicatorDescription;
        }

        public String getIdentificationIndicatorDescription() {
            return identificationIndicatorDescription;
        }

        public String getClientTypeIndicatorDescription() {
            return clientTypeIndicatorDescription;
        }

        public String getFederalEntity() {
            return federalEntity;
        }

        public String getStatus() {
            return status;
        }

        public String getAccountStatus() {
            return accountStatus;
        }

        public String getBiometricIndicatorStatus() {
            return biometricIndicatorStatus;
        }

        public String getIdentificationIndicatorStatus() {
            return identificationIndicatorStatus;
        }

        public String getClientTypeStatus() {
            return clientTypeStatus;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getAgreementId() {
            return agreementId;
        }

        public String getPersonId() {
            return personId;
        }

        public String getTown() {
            return town;
        }

        public String getName() {
            return name;
        }

        public String getNss() {
            return nss;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAffiliationOrigin() {
            return affiliationOrigin;
        }

        public List<SocialNetwork> getSocialNetworks() {
            return socialNetworks;
        }

        public String getAffiliationRegime() {
            return affiliationRegime;
        }

        public String getRfc() {
            return rfc;
        }

        public String getSex() {
            return sex;
        }

        public List<ClientPhone> getPhones() {
            return phones;
        }

        public Integer getBiometricIndicatorValue() {
            return biometricIndicatorValue;
        }

        public Long getIdentificationIndicatorValue() {
            return identificationIndicatorValue;
        }

        public Long getClientTypeIndicatorValue() {
            return clientTypeIndicatorValue;
        }
    }

    public class ClientEmail {
        @SerializedName("email") private String email;
        @SerializedName("preferente") private String preferential;
        @SerializedName("tipoMail") private String emailType;
        @SerializedName("valido") private String valid;

        public String getEmail() {
            return email;
        }

        public String getPreferential() {
            return preferential;
        }

        public String getEmailType() {
            return emailType;
        }

        public String getValid() {
            return valid;
        }
    }

    public class ClientPhone {
        @SerializedName("lada") private String lada;
        @SerializedName("numero") private String phone;
        @SerializedName("preferente") private String preferential;
        @SerializedName("sms") private String sms;
        @SerializedName("tipoTelefono") private PhoneType phoneType;
        @SerializedName("valido") private String valid;

        public String getLada() {
            return lada;
        }

        public String getPhone() {
            return phone;
        }

        public String getPreferential() {
            return preferential;
        }

        public String getSms() {
            return sms;
        }

        public PhoneType getPhoneType() {
            return phoneType;
        }

        public String getValid() {
            return valid;
        }
    }

    public class PhoneType {
        @SerializedName("clave") public String key;
        @SerializedName("descripcion") public String description;

        public String getKey() {
            return key;
        }

        public String getDescription() {
            return description;
        }
    }

    public class SocialNetwork {
        @SerializedName("preferente") private String preferential;
        @SerializedName("tipoRedSocial") private SocialNetworkType socialNetworkType;
        @SerializedName("valor") private String value;

        public String getPreferential() {
            return preferential;
        }

        public SocialNetworkType getSocialNetworkType() {
            return socialNetworkType;
        }

        public String getValue() {
            return value;
        }
    }

    public class SocialNetworkType {
        @SerializedName("clave") private String key;
        @SerializedName("descripcion") private String description;

        public String getKey() {
            return key;
        }

        public String getDescription() {
            return description;
        }
    }

    @SerializedName("clientes") private List<Client> items;

    public List<Client> getItems() {
        return items;
    }
}

