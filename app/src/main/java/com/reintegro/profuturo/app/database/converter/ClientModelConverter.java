package com.reintegro.profuturo.app.database.converter;

import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.database.model.ClientModel;

import java.util.ArrayList;
import java.util.List;

public class ClientModelConverter {
    public static ClientEntity convertFromModel(ClientModel clientModel) {
        ClientEntity clientEntity;
        clientEntity = new ClientEntity();
        clientEntity.setAccountNumber(clientModel.getAccountNumber());
        clientEntity.setAccountStatus(clientModel.getAccountStatus());
        clientEntity.setAccountValidity(clientModel.getAccountValidity());
        clientEntity.setAffiliationOrigin(clientModel.getAffiliationOrigin());
        clientEntity.setAffiliationRegime(clientModel.getAffiliationRegime());
        clientEntity.setAgreementId(clientModel.getAgreementId());
        clientEntity.setBiometricIndicatorDescription(clientModel.getBiometricIndicatorDescription());
        clientEntity.setBiometricIndicatorStatus(clientModel.getBiometricIndicatorStatus());
        clientEntity.setBiometricIndicatorValue(clientModel.getBiometricIndicatorValue());
        clientEntity.setBirthday(DateModelConverter.convertFromModel(clientModel.getBirthday()));
        clientEntity.setCellPhone(clientModel.getCellPhone());
        clientEntity.setCellPhonePreferential(clientModel.isCellPhonePreferential());
        clientEntity.setCellPhoneSms(clientModel.isCellPhoneSms());
        clientEntity.setCellPhoneValid(clientModel.isCellPhoneValid());
        clientEntity.setClientTypeIndicatorDescription(clientModel.getClientTypeIndicatorDescription());
        clientEntity.setClientTypeIndicatorValue(clientModel.getClientTypeIndicatorValue());
        clientEntity.setClientTypeStatus(clientModel.getClientTypeStatus());
        clientEntity.setCurp(clientModel.getCurp());
        clientEntity.setEmails(ClientEmailConverter.convertFromModels(clientModel.getEmails()));
        clientEntity.setFatherLastName(clientModel.getFatherLastName());
        clientEntity.setFederalEntity(clientModel.getFederalEntity());
        clientEntity.setFullName(clientModel.getFullName());
        clientEntity.setId(clientModel.getId());
        clientEntity.setIdentificationIndicatorDescription(clientModel.getIdentificationIndicatorDescription());
        clientEntity.setIdentificationIndicatorStatus(clientModel.getIdentificationIndicatorStatus());
        clientEntity.setIdentificationIndicatorValue(clientModel.getIdentificationIndicatorValue());
        clientEntity.setImage(clientModel.getImage());
        clientEntity.setImageId(clientModel.getImageId());
        clientEntity.setMotherLastName(clientModel.getMotherLastName());
        clientEntity.setName(clientModel.getName());
        clientEntity.setNeighborhood(clientModel.getNeighborhood());
        clientEntity.setNss(clientModel.getNss());
        clientEntity.setOfficePhone(clientModel.getOfficePhone());
        clientEntity.setOfficePhonePreferential(clientModel.isOfficePhonePreferential());
        clientEntity.setOfficePhoneSms(clientModel.isOfficePhoneSms());
        clientEntity.setOfficePhoneValid(clientModel.isOfficePhoneValid());
        clientEntity.setPersonId(clientModel.getPersonId());
        clientEntity.setPhone(clientModel.getPhone());
        clientEntity.setPhonePreferential(clientModel.isPhonePreferential());
        clientEntity.setPhoneSms(clientModel.isPhoneSms());
        clientEntity.setPhoneValid(clientModel.isPhoneValid());
        clientEntity.setPostalCode(clientModel.getPostalCode());
        clientEntity.setRfc(clientModel.getRfc());
        clientEntity.setSelected(clientModel.isSelected());
        clientEntity.setSex(clientModel.getSex());
        clientEntity.setSocialNetworks(ClientSocialNetworkConverter.convertFromModels(clientModel.getSocialNetworks()));
        clientEntity.setStatus(clientModel.getStatus());
        clientEntity.setStreet(clientModel.getStreet());
        clientEntity.setTown(clientModel.getTown());

        return clientEntity;
    }

    public static ClientModel convertFromEntity(ClientEntity clientEntity) {
        ClientModel clientModel;
        clientModel = new ClientModel();
        clientModel.setAccountNumber(clientEntity.getAccountNumber());
        clientModel.setAccountStatus(clientEntity.getAccountStatus());
        clientModel.setAccountValidity(clientEntity.getAccountValidity());
        clientModel.setAffiliationOrigin(clientEntity.getAffiliationOrigin());
        clientModel.setAffiliationRegime(clientEntity.getAffiliationRegime());
        clientModel.setAgreementId(clientEntity.getAgreementId());
        clientModel.setBiometricIndicatorDescription(clientEntity.getBiometricIndicatorDescription());
        clientModel.setBiometricIndicatorStatus(clientEntity.getBiometricIndicatorStatus());
        clientModel.setBiometricIndicatorValue(clientEntity.getBiometricIndicatorValue());
        clientModel.setBirthday(DateModelConverter.convertFromEntity(clientEntity.getBirthday()));
        clientModel.setCellPhone(clientEntity.getCellPhone());
        clientModel.setCellPhonePreferential(clientEntity.isCellPhonePreferential());
        clientModel.setCellPhoneSms(clientEntity.isCellPhoneSms());
        clientModel.setCellPhoneValid(clientEntity.isCellPhoneValid());
        clientModel.setClientTypeIndicatorDescription(clientEntity.getClientTypeIndicatorDescription());
        clientModel.setClientTypeIndicatorValue(clientEntity.getClientTypeIndicatorValue());
        clientModel.setClientTypeStatus(clientEntity.getClientTypeStatus());
        clientModel.setCurp(clientEntity.getCurp());
        clientModel.setEmails(ClientEmailConverter.convertFromEntities(clientEntity.getEmails()));
        clientModel.setFatherLastName(clientEntity.getFatherLastName());
        clientModel.setFederalEntity(clientEntity.getFederalEntity());
        clientModel.setFullName(clientEntity.getFullName());
        clientModel.setIdentificationIndicatorDescription(clientEntity.getIdentificationIndicatorDescription());
        clientModel.setIdentificationIndicatorStatus(clientEntity.getIdentificationIndicatorStatus());
        clientModel.setIdentificationIndicatorValue(clientEntity.getIdentificationIndicatorValue());
        clientModel.setImage(clientEntity.getImage());
        clientModel.setImageId(clientEntity.getImageId());
        clientModel.setMotherLastName(clientEntity.getMotherLastName());
        clientModel.setName(clientEntity.getName());
        clientModel.setNeighborhood(clientEntity.getNeighborhood());
        clientModel.setNss(clientEntity.getNss());
        clientModel.setOfficePhone(clientEntity.getOfficePhone());
        clientModel.setOfficePhonePreferential(clientEntity.isOfficePhonePreferential());
        clientModel.setOfficePhoneSms(clientEntity.isOfficePhoneSms());
        clientModel.setOfficePhoneValid(clientEntity.isOfficePhoneValid());
        clientModel.setPersonId(clientEntity.getPersonId());
        clientModel.setPhone(clientEntity.getPhone());
        clientModel.setPhonePreferential(clientEntity.isPhonePreferential());
        clientModel.setPhoneSms(clientEntity.isPhoneSms());
        clientModel.setPhoneValid(clientEntity.isPhoneValid());
        clientModel.setPostalCode(clientEntity.getPostalCode());
        clientModel.setRfc(clientEntity.getRfc());
        clientModel.setSelected(clientEntity.isSelected());
        clientModel.setSex(clientEntity.getSex());
        clientModel.setSocialNetworks(ClientSocialNetworkConverter.converterFromEntities(clientEntity.getSocialNetworks()));
        clientModel.setStatus(clientEntity.getStatus());
        clientModel.setStreet(clientEntity.getStreet());
        clientModel.setTown(clientEntity.getTown());

        boolean hasId;
        hasId = clientEntity.getId() != null;

        if (hasId) {
            clientModel.setId(clientEntity.getId());
        }

        return clientModel;
    }

    public static List<ClientEntity> convertFromModels(List<ClientModel> clientModels) {
        List<ClientEntity> clientEntities;
        clientEntities = new ArrayList<>();

        for (ClientModel clientModel : clientModels) {
            clientEntities.add(convertFromModel(clientModel));
        }

        return clientEntities;
    }

    public static List<ClientModel> convertFromEntities(List<ClientEntity> clientEntities) {
        List<ClientModel> clientModels;
        clientModels = new ArrayList<>();

        for (ClientEntity clientEntity : clientEntities) {
            clientModels.add(convertFromEntity(clientEntity));
        }

        return clientModels;
    }
}
