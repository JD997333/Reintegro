package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendEmailResponse {
    public static class Message {
        @SerializedName("codigo") private String code;
        @SerializedName("descripcion") private String description;

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

    public static class Messages {
        @SerializedName("mensaje") private List<Message> messages;

        public List<Message> getMessages() {
            return messages;
        }
    }

    public static class Email {
        @SerializedName("mensajes") private Messages messages;

        public Messages getMessages() {
            return messages;
        }
    }

    @SerializedName("enviarCorreoResponse") private Email Email;

    public Email getEmail() {
        return Email;
    }
}
