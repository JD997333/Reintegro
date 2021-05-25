package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.GetClientDataResponse;
import com.reintegro.profuturo.app.data.entity.ClientEmailEntity;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.ClientSocialNetworkEntity;
import com.reintegro.profuturo.app.data.entity.ClientSocialNetworkTypeEntity;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.util.TypeUtils;

import java.util.ArrayList;
import java.util.List;

public class GetClientDataResponseConverter extends ResponseConverter<GetClientDataResponse, List<ClientEntity>> {
    @Override
    public List<ClientEntity> convert(GetClientDataResponse response) {
        List<ClientEntity> clientEntities;
        clientEntities = new ArrayList<>();

        for (GetClientDataResponse.Client client : response.getItems()) {
            ClientEntity clientEntity = new ClientEntity();
            clientEntity.setAccountNumber(TypeUtils.getValueOrDefault(client.getAccountNumber()));
            clientEntity.setAccountStatus(TypeUtils.getValueOrDefault(client.getAccountStatus()));
            clientEntity.setAccountValidity(TypeUtils.getValueOrDefault(client.getAccountValidity()));
            clientEntity.setAffiliationOrigin(TypeUtils.getValueOrDefault(client.getAffiliationOrigin()));
            clientEntity.setAffiliationRegime(TypeUtils.getValueOrDefault(client.getAffiliationRegime()));
            clientEntity.setAgreementId(TypeUtils.getValueOrDefault(Long.parseLong(client.getAgreementId())));
            clientEntity.setBirthday(DateResponseConverter.convertFromResponse(client.getBirthday(), Constants.DATE_FORMAT_2));
            clientEntity.setBiometricIndicatorDescription(TypeUtils.getValueOrDefault(client.getBiometricIndicatorDescription()));
            clientEntity.setBiometricIndicatorStatus(TypeUtils.getValueOrDefault(client.getBiometricIndicatorStatus()));
            clientEntity.setBiometricIndicatorValue(TypeUtils.getValueOrDefault(client.getBiometricIndicatorValue()));
            clientEntity.setClientTypeIndicatorDescription(TypeUtils.getValueOrDefault(client.getClientTypeIndicatorDescription()));
            clientEntity.setClientTypeIndicatorValue(TypeUtils.getValueOrDefault(client.getClientTypeIndicatorValue()));
            clientEntity.setClientTypeStatus(TypeUtils.getValueOrDefault(client.getClientTypeStatus()));
            clientEntity.setCurp(TypeUtils.getValueOrDefault(client.getCurp()));
            clientEntity.setFatherLastName(TypeUtils.getValueOrDefault(client.getFatherLastName()));
            clientEntity.setFederalEntity(TypeUtils.getValueOrDefault(client.getFederalEntity()));
            clientEntity.setFullName(TypeUtils.getValueOrDefault(client.getName()) + " " + TypeUtils.getValueOrDefault(client.getFatherLastName()) + " " + TypeUtils.getValueOrDefault(client.getMotherLastName()));
            clientEntity.setIdentificationIndicatorDescription(TypeUtils.getValueOrDefault(client.getIdentificationIndicatorDescription()));
            clientEntity.setIdentificationIndicatorStatus(TypeUtils.getValueOrDefault(client.getIdentificationIndicatorStatus()));
            clientEntity.setIdentificationIndicatorValue(TypeUtils.getValueOrDefault(client.getIdentificationIndicatorValue()));
            clientEntity.setMotherLastName(TypeUtils.getValueOrDefault(client.getMotherLastName()));
            clientEntity.setName(TypeUtils.getValueOrDefault(client.getName()));
            clientEntity.setNeighborhood(TypeUtils.getValueOrDefault(client.getNeighborhood()));
            clientEntity.setNss(TypeUtils.getValueOrDefault(client.getNss()));
            clientEntity.setPersonId(TypeUtils.getValueOrDefault(Long.parseLong(client.getPersonId())));
            clientEntity.setPostalCode(TypeUtils.getValueOrDefault(Long.parseLong(client.getPostalCode())));
            clientEntity.setRfc(TypeUtils.getValueOrDefault(client.getRfc()));
            clientEntity.setSex(TypeUtils.getValueOrDefault(client.getSex()));
            clientEntity.setStatus(TypeUtils.getValueOrDefault(client.getStatus()));
            clientEntity.setStreet(TypeUtils.getValueOrDefault(client.getStreet()));
            clientEntity.setTown(TypeUtils.getValueOrDefault(client.getTown()));

            List<ClientEmailEntity> emailEntities = new ArrayList<>();

            if (client.getEmails() != null) {
                for (GetClientDataResponse.ClientEmail clientEmail : client.getEmails()) {
                    ClientEmailEntity clientEmailEntity = new ClientEmailEntity();
                    clientEmailEntity.setEmail(TypeUtils.getValueOrDefault(clientEmail.getEmail()));
                    clientEmailEntity.setEmailType(TypeUtils.getValueOrDefault(clientEmail.getEmailType()));
                    clientEmailEntity.setPreferential(TypeUtils.getValueOrDefault(Boolean.parseBoolean(clientEmail.getPreferential())));
                    clientEmailEntity.setValidEmail(TypeUtils.getValueOrDefault(Boolean.parseBoolean(clientEmail.getValid())));

                    emailEntities.add(clientEmailEntity);
                }
            }

            clientEntity.setEmails(emailEntities);

            if (client.getPhones() != null) {
                for (GetClientDataResponse.ClientPhone phone : client.getPhones()) {
                    String description = phone.getPhoneType().getDescription();

                    if (description.equals(Constants.PHONE_TYPE_CELL_PHONE)) {
                        clientEntity.setCellPhone(TypeUtils.getValueOrDefault(phone.getPhone()));
                        clientEntity.setCellPhonePreferential(TypeUtils.getValueOrDefault(Boolean.parseBoolean(phone.getPreferential())));
                        clientEntity.setCellPhoneSms(TypeUtils.getValueOrDefault(Boolean.parseBoolean(phone.getSms())));
                        clientEntity.setCellPhoneValid(TypeUtils.getValueOrDefault(Boolean.parseBoolean(phone.getValid())));
                    } else if (description.equals(Constants.PHONE_TYPE_PHONE)) {
                        clientEntity.setPhone(TypeUtils.getValueOrDefault(phone.getPhone()));
                        clientEntity.setPhonePreferential(TypeUtils.getValueOrDefault(Boolean.parseBoolean(phone.getPreferential())));
                        clientEntity.setPhoneSms(TypeUtils.getValueOrDefault(Boolean.parseBoolean(phone.getSms())));
                        clientEntity.setPhoneValid(TypeUtils.getValueOrDefault(Boolean.parseBoolean(phone.getValid())));
                    } else if (description.equals(Constants.PHONE_TYPE_OFFICE)) {
                        clientEntity.setOfficePhone(TypeUtils.getValueOrDefault(phone.getPhone()));
                        clientEntity.setOfficePhonePreferential(TypeUtils.getValueOrDefault(Boolean.parseBoolean(phone.getPreferential())));
                        clientEntity.setOfficePhoneSms(TypeUtils.getValueOrDefault(Boolean.parseBoolean(phone.getSms())));
                        clientEntity.setOfficePhoneValid(TypeUtils.getValueOrDefault(Boolean.parseBoolean(phone.getValid())));
                    }
                }
            }

            List<ClientSocialNetworkEntity> socialNetworkEntities = new ArrayList<>();

            if (client.getSocialNetworks() != null) {
                for (GetClientDataResponse.SocialNetwork socialNetwork : client.getSocialNetworks()) {
                    ClientSocialNetworkEntity clientSocialNetworkEntity;
                    clientSocialNetworkEntity = new ClientSocialNetworkEntity();
                    clientSocialNetworkEntity.setValue(socialNetwork.getValue());
                    clientSocialNetworkEntity.setPreferential(TypeUtils.getBooleanValueOrDefault(socialNetwork.getPreferential()));

                    ClientSocialNetworkTypeEntity clientSocialNetworkTypeEntity;
                    clientSocialNetworkTypeEntity = new ClientSocialNetworkTypeEntity();
                    clientSocialNetworkTypeEntity.setKey(socialNetwork.getSocialNetworkType().getKey());
                    clientSocialNetworkTypeEntity.setDescription(socialNetwork.getSocialNetworkType().getDescription());

                    clientSocialNetworkEntity.setNetworkSocialType(clientSocialNetworkTypeEntity);

                    socialNetworkEntities.add(clientSocialNetworkEntity);
                }
            }

            clientEntity.setSocialNetworks(socialNetworkEntities);

            clientEntities.add(clientEntity);
        }

        return clientEntities;
    }
}
