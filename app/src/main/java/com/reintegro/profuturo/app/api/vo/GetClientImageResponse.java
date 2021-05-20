package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

public class GetClientImageResponse {
    public class ClientImage {
        @SerializedName("idImagen") private Long imageId;
        @SerializedName("imagen") private String image;

        public Long getImageId() {
            return imageId;
        }

        public String getImage() {
            return image;
        }
    }

    @SerializedName("consultarFotosCliente") private ClientImage image;

    public ClientImage getImage() {
        return image;
    }
}

