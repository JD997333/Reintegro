package com.reintegro.profuturo.app.util;

import com.reintegro.profuturo.app.data.entity.ClientEntity;

public class ClientUtils {
    public static ClientEntity mergeClientImage(ClientEntity to, ClientEntity from) {
        to.setImage(from.getImage());
        to.setImageId(from.getImageId());

        return to;
    }
}