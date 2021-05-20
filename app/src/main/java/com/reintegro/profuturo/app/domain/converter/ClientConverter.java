package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.ClientEmailEntity;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.ClientSocialNetworkEntity;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.ClientEmailDto;
import com.reintegro.profuturo.app.domain.dto.ClientSocialNetworkDto;

import java.util.ArrayList;
import java.util.List;

public class ClientConverter {
    public static ClientDto convertFromEntity(ClientEntity clientEntity) {
        ClientDto clientDto;
        clientDto = new ClientDto();
        clientDto.setAccountNumber(clientEntity.getAccountNumber());
        clientDto.setAccountStatus(clientEntity.getAccountStatus());
        clientDto.setAccountValidity(clientEntity.getAccountValidity());
        clientDto.setAffiliationOrigin(clientEntity.getAffiliationOrigin());
        clientDto.setAffiliationRegime(clientEntity.getAffiliationRegime());
        clientDto.setAgreementId(clientEntity.getAgreementId());
        clientDto.setBiometricIndicatorDescription(clientEntity.getBiometricIndicatorDescription());
        clientDto.setBiometricIndicatorStatus(clientEntity.getBiometricIndicatorStatus());
        clientDto.setBiometricIndicatorValue(clientEntity.getBiometricIndicatorValue());
        clientDto.setBirthday(DateConverter.convertFromEntity(clientEntity.getBirthday()));
        clientDto.setCellPhone(clientEntity.getCellPhone());
        clientDto.setCellPhonePreferential(clientEntity.isCellPhonePreferential());
        clientDto.setCellPhoneSms(clientEntity.isCellPhoneSms());
        clientDto.setCellPhoneValid(clientEntity.isCellPhoneValid());
        clientDto.setClientTypeIndicatorDescription(clientEntity.getClientTypeIndicatorDescription());
        clientDto.setClientTypeIndicatorValue(clientEntity.getClientTypeIndicatorValue());
        clientDto.setClientTypeStatus(clientEntity.getClientTypeStatus());
        clientDto.setCurp(clientEntity.getCurp());
        clientDto.setFatherLastName(clientEntity.getFatherLastName());
        clientDto.setFederalEntity(clientEntity.getFederalEntity());
        clientDto.setFullName(clientEntity.getFullName());
        clientDto.setId(clientEntity.getId());
        clientDto.setIdentificationIndicatorDescription(clientEntity.getIdentificationIndicatorDescription());
        clientDto.setIdentificationIndicatorStatus(clientEntity.getIdentificationIndicatorStatus());
        clientDto.setIdentificationIndicatorValue(clientEntity.getIdentificationIndicatorValue());
        clientDto.setImage(clientEntity.getImage());
        clientDto.setImageId(clientEntity.getImageId());
        clientDto.setMotherLastName(clientEntity.getMotherLastName());
        clientDto.setName(clientEntity.getName());
        clientDto.setNeighborhood(clientEntity.getNeighborhood());
        clientDto.setNss(clientEntity.getNss());
        clientDto.setOfficePhone(clientEntity.getOfficePhone());
        clientDto.setOfficePhonePreferential(clientEntity.isOfficePhonePreferential());
        clientDto.setOfficePhoneSms(clientEntity.isOfficePhoneSms());
        clientDto.setOfficePhoneValid(clientEntity.isOfficePhoneValid());
        clientDto.setPersonId(clientEntity.getPersonId());
        clientDto.setPhone(clientEntity.getPhone());
        clientDto.setPhonePreferential(clientEntity.isPhonePreferential());
        clientDto.setPhoneSms(clientEntity.isPhoneSms());
        clientDto.setPhoneValid(clientEntity.isPhoneValid());
        clientDto.setPostalCode(clientEntity.getPostalCode());
        clientDto.setRfc(clientEntity.getRfc());
        clientDto.setSelected(clientEntity.isSelected());
        clientDto.setSex(clientEntity.getSex());
        clientDto.setStatus(clientEntity.getStatus());
        clientDto.setStreet(clientEntity.getStreet());
        clientDto.setTown(clientEntity.getTown());

        List<ClientEmailDto> clientEmailDtos = new ArrayList<>();

        if (clientEntity.getEmails() != null) {
            for (ClientEmailEntity clientEmailEntity : clientEntity.getEmails()) {
                clientEmailDtos.add(ClientEmailConverter.convertFromEntity(clientEmailEntity));
            }
        }

        clientDto.setEmails(clientEmailDtos);

        List<ClientSocialNetworkDto> clientSocialNetworkDtos = new ArrayList<>();

        if (clientEntity.getSocialNetworks() != null) {
            for (ClientSocialNetworkEntity clientSocialNetworkEntity : clientEntity.getSocialNetworks()) {
                clientSocialNetworkDtos.add(ClientSocialNetworkConverter.convertFromEntity(clientSocialNetworkEntity));
            }
        }

        clientDto.setSocialNetworks(clientSocialNetworkDtos);

        return clientDto;
    }

    public static ClientEntity convertFromDto(ClientDto clientDto) {
        ClientEntity clientEntity;
        clientEntity = new ClientEntity();
        clientEntity.setAccountNumber(clientDto.getAccountNumber());
        clientEntity.setAccountStatus(clientDto.getAccountStatus());
        clientEntity.setAccountValidity(clientDto.getAccountValidity());
        clientEntity.setAffiliationOrigin(clientDto.getAffiliationOrigin());
        clientEntity.setAffiliationRegime(clientDto.getAffiliationRegime());
        clientEntity.setAgreementId(clientDto.getAgreementId());
        clientEntity.setBiometricIndicatorDescription(clientDto.getBiometricIndicatorDescription());
        clientEntity.setBiometricIndicatorStatus(clientDto.getBiometricIndicatorStatus());
        clientEntity.setBiometricIndicatorValue(clientDto.getBiometricIndicatorValue());
        clientEntity.setBirthday(DateConverter.convertFromDto(clientDto.getBirthday()));
        clientEntity.setCellPhone(clientDto.getCellPhone());
        clientEntity.setCellPhonePreferential(clientDto.isCellPhonePreferential());
        clientEntity.setCellPhoneSms(clientDto.isCellPhoneSms());
        clientEntity.setCellPhoneValid(clientDto.isCellPhoneValid());
        clientEntity.setClientTypeIndicatorDescription(clientDto.getClientTypeIndicatorDescription());
        clientEntity.setClientTypeIndicatorValue(clientDto.getClientTypeIndicatorValue());
        clientEntity.setClientTypeStatus(clientDto.getClientTypeStatus());
        clientEntity.setCurp(clientDto.getCurp());
        clientEntity.setFatherLastName(clientDto.getFatherLastName());
        clientEntity.setFederalEntity(clientDto.getFederalEntity());
        clientEntity.setFullName(clientDto.getFullName());
        clientEntity.setId(clientDto.getId());
        clientEntity.setIdentificationIndicatorDescription(clientDto.getIdentificationIndicatorDescription());
        clientEntity.setIdentificationIndicatorStatus(clientDto.getIdentificationIndicatorStatus());
        clientEntity.setIdentificationIndicatorValue(clientDto.getIdentificationIndicatorValue());
        clientEntity.setImage(clientDto.getImage());
        clientEntity.setImageId(clientDto.getImageId());
        clientEntity.setMotherLastName(clientDto.getMotherLastName());
        clientEntity.setName(clientDto.getName());
        clientEntity.setNeighborhood(clientDto.getNeighborhood());
        clientEntity.setNss(clientDto.getNss());
        clientEntity.setOfficePhone(clientDto.getOfficePhone());
        clientEntity.setOfficePhonePreferential(clientDto.isOfficePhonePreferential());
        clientEntity.setOfficePhoneSms(clientDto.isOfficePhoneSms());
        clientEntity.setOfficePhoneValid(clientDto.isOfficePhoneValid());
        clientEntity.setPersonId(clientDto.getPersonId());
        clientEntity.setPhone(clientDto.getPhone());
        clientEntity.setPhonePreferential(clientDto.isPhonePreferential());
        clientEntity.setPhoneSms(clientDto.isPhoneSms());
        clientEntity.setPhoneValid(clientDto.isPhoneValid());
        clientEntity.setPostalCode(clientDto.getPostalCode());
        clientEntity.setRfc(clientDto.getRfc());
        clientEntity.setSelected(clientDto.isSelected());
        clientEntity.setSex(clientDto.getSex());
        clientEntity.setStatus(clientDto.getStatus());
        clientEntity.setStreet(clientDto.getStreet());
        clientEntity.setTown(clientDto.getTown());

        List<ClientEmailEntity> clientEmailEntities = new ArrayList<>();

        if (clientDto.getEmails() != null) {
            for(ClientEmailDto clientEmailDto : clientDto.getEmails()) {
                clientEmailEntities.add(ClientEmailConverter.convertFromDto(clientEmailDto));
            }
        }

        clientEntity.setEmails(clientEmailEntities);

        List<ClientSocialNetworkEntity> clientSocialNetworkEntities = new ArrayList<>();

        if (clientDto.getSocialNetworks() != null) {
            for (ClientSocialNetworkDto clientSocialNetworkDto : clientDto.getSocialNetworks()) {
                clientSocialNetworkEntities.add(ClientSocialNetworkConverter.convertFromDto(clientSocialNetworkDto));
            }
        }

        clientEntity.setSocialNetworks(clientSocialNetworkEntities);

        return clientEntity;
    }

    public static List<ClientDto> convertFromEntities(List<ClientEntity> clientEntities) {
        List<ClientDto> clientDtos;
        clientDtos = new ArrayList<>();

        for (ClientEntity clientEntity : clientEntities) {
            clientDtos.add(convertFromEntity(clientEntity));
        }

        return clientDtos;
    }
}
