package com.reintegro.profuturo.app.domain.dto;

import java.util.List;

public class ClientDto {
    private DateDto birthday;
    private List<ClientEmailDto> emails;
    private List<ClientSocialNetworkDto> socialNetworks;
    private String accountNumber;
    private String accountStatus;
    private String accountValidity;
    private String affiliationOrigin;
    private String affiliationRegime;
    private String biometricIndicatorDescription;
    private String biometricIndicatorStatus;
    private String cellPhone;
    private String clientTypeIndicatorDescription;
    private String clientTypeStatus;
    private String curp;
    private String fatherLastName;
    private String federalEntity;
    private String fullName;
    private String id;
    private String identificationIndicatorDescription;
    private String identificationIndicatorStatus;
    private String image;
    private String motherLastName;
    private String name;
    private String neighborhood;
    private String nss;
    private String officePhone;
    private String phone;
    private String rfc;
    private String sex;
    private String status;
    private String street;
    private String town;
    private boolean cellPhonePreferential;
    private boolean cellPhoneSms;
    private boolean cellPhoneValid;
    private boolean officePhonePreferential;
    private boolean officePhoneSms;
    private boolean officePhoneValid;
    private boolean phonePreferential;
    private boolean phoneSms;
    private boolean phoneValid;
    private boolean selected;
    private long agreementId;
    private int biometricIndicatorValue;
    private long clientTypeIndicatorValue;
    private long identificationIndicatorValue;
    private long imageId;
    private long personId;
    private long postalCode;

    public DateDto getBirthday() {
        return birthday;
    }

    public void setBirthday(DateDto birthday) {
        this.birthday = birthday;
    }

    public List<ClientEmailDto> getEmails() {
        return emails;
    }

    public void setEmails(List<ClientEmailDto> emails) {
        this.emails = emails;
    }

    public List<ClientSocialNetworkDto> getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(List<ClientSocialNetworkDto> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountValidity() {
        return accountValidity;
    }

    public void setAccountValidity(String accountValidity) {
        this.accountValidity = accountValidity;
    }

    public String getAffiliationOrigin() {
        return affiliationOrigin;
    }

    public void setAffiliationOrigin(String affiliationOrigin) {
        this.affiliationOrigin = affiliationOrigin;
    }

    public String getAffiliationRegime() {
        return affiliationRegime;
    }

    public void setAffiliationRegime(String affiliationRegime) {
        this.affiliationRegime = affiliationRegime;
    }

    public String getBiometricIndicatorDescription() {
        return biometricIndicatorDescription;
    }

    public void setBiometricIndicatorDescription(String biometricIndicatorDescription) {
        this.biometricIndicatorDescription = biometricIndicatorDescription;
    }

    public String getBiometricIndicatorStatus() {
        return biometricIndicatorStatus;
    }

    public void setBiometricIndicatorStatus(String biometricIndicatorStatus) {
        this.biometricIndicatorStatus = biometricIndicatorStatus;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getClientTypeIndicatorDescription() {
        return clientTypeIndicatorDescription;
    }

    public void setClientTypeIndicatorDescription(String clientTypeIndicatorDescription) {
        this.clientTypeIndicatorDescription = clientTypeIndicatorDescription;
    }

    public String getClientTypeStatus() {
        return clientTypeStatus;
    }

    public void setClientTypeStatus(String clientTypeStatus) {
        this.clientTypeStatus = clientTypeStatus;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getFatherLastName() {
        return fatherLastName;
    }

    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    public String getFederalEntity() {
        return federalEntity;
    }

    public void setFederalEntity(String federalEntity) {
        this.federalEntity = federalEntity;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentificationIndicatorDescription() {
        return identificationIndicatorDescription;
    }

    public void setIdentificationIndicatorDescription(String identificationIndicatorDescription) {
        this.identificationIndicatorDescription = identificationIndicatorDescription;
    }

    public String getIdentificationIndicatorStatus() {
        return identificationIndicatorStatus;
    }

    public void setIdentificationIndicatorStatus(String identificationIndicatorStatus) {
        this.identificationIndicatorStatus = identificationIndicatorStatus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public boolean isCellPhonePreferential() {
        return cellPhonePreferential;
    }

    public void setCellPhonePreferential(boolean cellPhonePreferential) {
        this.cellPhonePreferential = cellPhonePreferential;
    }

    public boolean isCellPhoneSms() {
        return cellPhoneSms;
    }

    public void setCellPhoneSms(boolean cellPhoneSms) {
        this.cellPhoneSms = cellPhoneSms;
    }

    public boolean isCellPhoneValid() {
        return cellPhoneValid;
    }

    public void setCellPhoneValid(boolean cellPhoneValid) {
        this.cellPhoneValid = cellPhoneValid;
    }

    public boolean isOfficePhonePreferential() {
        return officePhonePreferential;
    }

    public void setOfficePhonePreferential(boolean officePhonePreferential) {
        this.officePhonePreferential = officePhonePreferential;
    }

    public boolean isOfficePhoneSms() {
        return officePhoneSms;
    }

    public void setOfficePhoneSms(boolean officePhoneSms) {
        this.officePhoneSms = officePhoneSms;
    }

    public boolean isOfficePhoneValid() {
        return officePhoneValid;
    }

    public void setOfficePhoneValid(boolean officePhoneValid) {
        this.officePhoneValid = officePhoneValid;
    }

    public boolean isPhonePreferential() {
        return phonePreferential;
    }

    public void setPhonePreferential(boolean phonePreferential) {
        this.phonePreferential = phonePreferential;
    }

    public boolean isPhoneSms() {
        return phoneSms;
    }

    public void setPhoneSms(boolean phoneSms) {
        this.phoneSms = phoneSms;
    }

    public boolean isPhoneValid() {
        return phoneValid;
    }

    public void setPhoneValid(boolean phoneValid) {
        this.phoneValid = phoneValid;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public long getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(long agreementId) {
        this.agreementId = agreementId;
    }

    public int getBiometricIndicatorValue() {
        return biometricIndicatorValue;
    }

    public void setBiometricIndicatorValue(int biometricIndicatorValue) {
        this.biometricIndicatorValue = biometricIndicatorValue;
    }

    public long getClientTypeIndicatorValue() {
        return clientTypeIndicatorValue;
    }

    public void setClientTypeIndicatorValue(long clientTypeIndicatorValue) {
        this.clientTypeIndicatorValue = clientTypeIndicatorValue;
    }

    public long getIdentificationIndicatorValue() {
        return identificationIndicatorValue;
    }

    public void setIdentificationIndicatorValue(long identificationIndicatorValue) {
        this.identificationIndicatorValue = identificationIndicatorValue;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(long postalCode) {
        this.postalCode = postalCode;
    }
}

