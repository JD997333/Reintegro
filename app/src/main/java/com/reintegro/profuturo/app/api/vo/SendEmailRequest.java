package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendEmailRequest {
    public static class Email {
        @SerializedName("adjunto") private String attachment;
        @SerializedName("asunto") private String subject;
        @SerializedName("datosMensaje") private MessageData messageData;
        @SerializedName("de") private List<From> from;
        @SerializedName("mensaje") private String message;
        @SerializedName("nombreAdjunto") private String attachmentName;
        @SerializedName("para") private List<To> to;

        public void setAttachment(String attachment) {
            this.attachment = attachment;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public void setMessageData(MessageData messageData) {
            this.messageData = messageData;
        }

        public void setFrom(List<From> from) {
            this.from = from;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setAttachmentName(String attachmentName) {
            this.attachmentName = attachmentName;
        }

        public void setTo(List<To> to) {
            this.to = to;
        }
    }

    public static class From {
        @SerializedName("email") private String email;

        public From(String email) {
            this.email = email;
        }
    }

    public static class MessageData {
        @SerializedName("idNotificacion") private String notificationId;
        @SerializedName("parametros") private Params params;

        public void setNotificationId(String notificationId) {
            this.notificationId = notificationId;
        }

        public void setParams(Params params) {
            this.params = params;
        }
    }

    public static class Param {
        @SerializedName("clave") String key;
        @SerializedName("valor") String value;

        public Param(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class Params {
        @SerializedName("parametro") private List<Param> params;

        public Params(List<Param> params) {
            this.params = params;
        }
    }

    public static class To {
        @SerializedName("email") private String email;

        public To(String email) {
            this.email = email;
        }
    }

    @SerializedName("enviarCorreoRequest") private Email email;

    public void setEmail(Email email) {
        this.email = email;
    }
}
