package com.reintegro.profuturo.app.util;

public class Constants {
    public static final String ACCOUNT_VALIDITY_VALID = "Vigente";

    public static final String DATE_FORMAT_1 = "dd/MM/yyyy";
    public static final String DATE_FORMAT_2 = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_FORMAT_3 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_4 = "yyyy/MM/dd";
    public static final String DATE_FORMAT_5 = "yyyyMMdd";
    public static final String DATE_FORMAT_6 = "yyyy-MM-dd";

    public static final String URL_BASE = "https://www.proinversion.mx";
    public static final String HTTP_HEADER_AUTHORIZATION = "Authorization: Basic cndzcHJheGlzcDpQcjR4MXMjdTVS";

    public static final String PHONE_TYPE_CELL_PHONE = "Celular";
    public static final String PHONE_TYPE_PHONE = "Fijo";
    public static final String PHONE_TYPE_OFFICE = "Oficina";

    public static final String KEY_BIOMETRIC_STATUS = "KEY_BIOMETRIC_STATUS";
    public static final String KEY_IDENTIFICATION_STATUS = "KEY_IDENTIFICATION_STATUS";

    public static final String EXTRA_IMAGE_ENGINE_CLASS_NAME = "mx.com.profuturo.motor.CameraUI";
    public static final String EXTRA_IMAGE_ENGINE_IS_CAMERA = "esCamara";
    public static final String EXTRA_IMAGE_ENGINE_NAME = "nombreDocumento";
    public static final String EXTRA_IMAGE_ENGINE_PACKAGE_NAME = "mx.com.profuturo.motor";
    public static final String EXTRA_IMAGE_ENGINE_PATH = "rutaDestino";
    public static final String EXTRA_IMAGE_ENGINE_RESULT = "rutaImagen";

    public static final String URN_GET_AGENT_ASSIGNED_BRANCH_OFFICE = "/mb/appMovil/rest/cuo/consultaDatosSucursal";
    public static final String URN_GET_AGENT_INFORMATION ="/mb/cusp/rest/consultaInformacionUsuario";
    public static final String URN_GET_BRANCH_OFFICES = "/iib/retiros/utilerias/v1/buscarSucursales";
    public static final String URN_GET_CLIENT_DATA = "/iib/nci/idc/v1/clientes";
    public static final String URN_GET_CLIENT_IMAGE = "/iib/identica/cliente/service/consultarImagencte/v1/obtenerImagenCte";
    public static final String URN_SAVE_LOGIN = "/iib/retiros/accesoRetiros/v1/guardarLogin";
    public static final String URN_SAVE_INITIAL_CAPTURE = "/iib/nci/ReintegroSemanas/CapturaInicial/v1/guardarCapturaInicial";
    public static final String URN_INSERT_CLIENT = "/iib/api/Cliente/v1/insertarCliente";
    public static final String URN_SERVICE_OP360 = "/iib/nci/PortalServicios/OP360/v1/consultarTrabajador";
    public static final String URN_GET_APPLICANT_TYPES = "/iib/profuturo/parciales/solicitanteparciales/v1/tipoSolicitanteRules";
    public static final String URN_VAL_COEXISTENCE = "/iib/api/comun/matriz_convivencia/v1/ConsultaConvivenciaCompletaComunNCI";
    public static final String URN_GET_REPAYMENT_EVENTS = "/iib/nci/ReintegroSemanas/OperacionesProcesar/v1/consultarHistoricos";
    public static final String URN_CALCULATE_REPAYMENT = "/iib/nci/ReintegroSemanas/OperacionesProcesar/v1/calcularReintegro";
    public static final String URN_VALIDATE_AUTH_FOLIO = "/iib/nci/PortalServicios/OP360/v1/validarFolioAutenticacion";
    public static final String URN_GET_DOCUMENTS = "/iib/retiros/reglasRetiros/v1/consultarDocumentoTramite";
    public static final String URN_GET_REPAYMENT_SOLICITUDE_DOC = "/iib/nci/ReintegroSemanas/DocumentosReintegro/v1/consultarSolicitudReintegro";
    public static final String URN_GET_LETTER_REPAYMENT_DOC = "/iib/nci/ReintegroSemanas/DocumentosReintegro/v1/consultarCartaReintegro";
    public static final String URN_INSERT_REINTEGRO_SEMANAS = "/iib/nci/ReintegroSemanas/IniciarDictamen/v1/iniciar";

    public static final int IDENTIFICATION_INDICATOR_STATUS_ACTIVE = 5;
    public static final int BIOMETRIC_INDICATOR_STATUS_NOT_EXIST = 0;
    public static final int BIOMETRIC_INDICATOR_STATUS_EXIST = 1;
    public static final int BIOMETRIC_INDICATOR_STATUS_IN_TRANSIT = 2;

    public static final int LENGTH_ACCOUNT_NUMBER = 10;
    public static final int LENGTH_CURP = 18;
    public static final int LENGTH_NSS = 11;
    public static final int LENGTH_AUTH_FOLIO = 11;

    public static final String RESPONSE_TRUE = "true";
    public static final String RESPONSE_FALSE = "false";
    public static final String REGULAR_EXPRESSION_VALIDATE_CURP = "[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}" + "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])" + "[HM]{1}" + "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)" + "[B-DF-HJ-NP-TV-Z]{3}" + "[0-9A-Z]{1}[0-9]{1}$";
    public static final String PRIVATE_ADVERTISEMENT = "Profuturo AFORE, S.A. de C.V. (en adelante “Profuturo”) con domicilio en Boulevard Adolfo López Mateos N° 2009, Planta Baja, Colonia Los Alpes, Alcaldía Álvaro Obregón, C.P. 01010, Ciudad de México, utilizará estos datos personales proporcionados por usted, con la finalidad de confirmar la información que nos proporciona como Titular de los Datos y realizar la administración de su cuenta individual de ahorro para el retiro en apego a la Ley de los Sistemas de Ahorro para el Retiro, la Ley del Seguro Social, la Ley del Instituto de Seguridad y Servicios Sociales de los Trabajadores del Estado, y las Disposiciones de Carácter General que emita la Comisión Nacional del Sistema de Ahorro para el Retiro y que resulten aplicables. Así mismo usted debe informar a sus beneficiarios o referencias del uso de sus datos personales por Profuturo de acuerdo con este aviso de privacidad. Si desea conocer mayor detalle de los fines para los cuales serán utilizados sus datos, así como ejercer sus derechos ARCO, puede consultar nuestro Aviso de Privacidad Integral a través de www.profuturo.mx , o solicitarlo a la Oficina de Datos Personales, en el teléfono 55580 – 96097 o vía correo electrónico a la dirección: datospersonales@profuturo.com.mx. Agosto 2019.";

    public static final Integer STATUS_SUB_STAGE_PENDING = 3030;
    public static final Integer STATUS_SUB_STAGE_CAPTURED = 3032;
    public static final Integer STATUS_SUB_STAGE_EXP_ACCEPTED = 3036;

    public static final Integer BINNACLE_STATUS_OPEN = 32;
    public static final Integer BINNACLE_STATUS_PROCESS = 32;
    public static final Integer ID_STAGE_RECEPTION = 19;
    public static final Integer ID_SUB_STAGE_CAPTURE = 990;
    public static final Integer ID_PROCESS = 7;
    public static final Integer ID_SUB_PROCESS = 133;
    public static final Integer ID_RESULT_BINNACLE = 29;
    public static final Integer APPLICATION_CHANNEL_ID = 462;
    public static final Integer ID_MOVEMENT_TYPE = 181;
    public static final Integer ID_OWNER_APPLICANT = 3278;
    public static final Integer ID_PROFUTURO_AFORE_KEY = 534;
    public static final Integer ID_PROCESS_AUTH_FOLIO = 9182;

    public static final String DEPOSIT_DATA_CONCEPT = "57822";
    public static final String DEPOSIT_DATA_AGREEMENT = "0682907";
    public static final String DEPOSIT_DATA_WORKDAYS_VALIDITY = "5";

    public static final String ID_EVENT_TYPE_TRD = "06";
    public static final String ID_EVENT_TYPE_REPAYMENT = "66";

    public static final String FILE_EXTENSION_PDF = ".pdf";
    public static final String FILE_EXTENSION_ZIP = ".zip";

    public static final Long ID_BRANCH_CORPORATE = 8000L;
    public static final Long ID_BRANCH_LAUDOS = 9999L;
    public static final Long ID_BRANCH_INFONAVIT = 9997L;
    public static final Long ID_BRANCH_AFOMOV = 3000L;

    public static final int DOCUMENT_TYPE_PDF = 0;
    public static final int DOCUMENT_TYPE_PHOTO = 1;

    public static final int DOCUMENT_KEY_REPAYMENT_SOLICITUDE = 1364;
    public static final int DOCUMENT_KEY_REPAYMENT_LETTER = 1365;
    public static final int DOCUMENT_KEY_OFFICIAL_ID_BACK = 1194;
    public static final int DOCUMENT_KEY_OFFICIAL_ID_FRONT = 1193;
    public static final int DOCUMENT_KEY_LEGAL_OFFICIAL_ID_BACK = 1430;
    public static final int DOCUMENT_KEY_LEGAL_OFFICIAL_ID_FRONT = 1429;
    public static final int DOCUMENT_KEY_POWER_ATTORNEY = 1190;
    public static final int DOCUMENT_KEY_GUARDIAN_OFFICIAL_ID_BACK = 1428;
    public static final int DOCUMENT_KEY_GUARDIAN_OFFICIAL_ID_FRONT = 1427;
    public static final int DOCUMENT_KEY_SENTENCE = 1431;

    public static final String ID_TYPE_INE = "INE";
    public static final String ID_TYPE_PASSPORT = "Pasaporte";
    public static final String ID_TYPE_MILITARY = "Cartilla militar";
    public static final String ID_TYPE_PROFESSIONAL = "Cédula profesional";
    public static final String ID_TYPE_MIGRATION_DOC = "Documento migratorio (FM2/FM3)";

}
