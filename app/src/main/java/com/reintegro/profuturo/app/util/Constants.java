package com.reintegro.profuturo.app.util;

public class Constants {
    public static final String ACCOUNT_VALIDITY_VALID = "Vigente";

    public static final String DATE_FORMAT_1 = "dd/MM/yyyy";
    public static final String DATE_FORMAT_2 = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_FORMAT_3 = "yyyy-MM-dd HH:mm:ss";

    public static final String URL_BASE = "https://www.proinversion.mx";

    public static final String HTTP_HEADER_AUTHORIZATION = "Authorization: Basic cndzcHJheGlzcDpQcjR4MXMjdTVS";

    public static final String PHONE_TYPE_CELL_PHONE = "Celular";
    public static final String PHONE_TYPE_PHONE = "Fijo";
    public static final String PHONE_TYPE_OFFICE = "Oficina";

    public static final String URN_GET_AGENT_ASSIGNED_BRANCH_OFFICE = "/mb/appMovil/rest/cuo/consultaDatosSucursal";
    public static final String URN_GET_AGENT_INFORMATION ="/mb/cusp/rest/consultaInformacionUsuario";
    public static final String URN_GET_BRANCH_OFFICES = "/iib/retiros/utilerias/v1/buscarSucursales";
    public static final String URN_GET_CLIENT_DATA = "/iib/nci/idc/v1/clientes";
    public static final String URN_GET_CLIENT_IMAGE = "/iib/identica/cliente/service/consultarImagencte/v1/obtenerImagenCte";
    public static final String URN_SAVE_LOGIN = "/iib/retiros/accesoRetiros/v1/guardarLogin";

    public static final int IDENTIFICATION_INDICATOR_STATUS_ACTIVE = 5;

    public static final int LENGTH_ACCOUNT_NUMBER = 10;
    public static final int LENGTH_CURP = 18;
    public static final int LENGTH_NSS = 11;
}
