package com.reintegro.profuturo.app.util;

import com.reintegro.profuturo.app.data.entity.ClientEntity;

public class ClientUtils {
    public static ClientEntity mergeClientImage(ClientEntity to, ClientEntity from) {
        to.setImage(from.getImage());
        to.setImageId(from.getImageId());

        return to;
    }

    public static String cleanAccountNumber(String accountNumber) {
        String cleanedAccountNumber = "";

        for (int index = 0; index < accountNumber.length(); index++) {
            if (accountNumber.charAt(index) != '0') {
                cleanedAccountNumber = accountNumber.substring(index);
                break;
            }
        }

        return cleanedAccountNumber;
    }
}