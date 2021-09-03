package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetClientData360Response {

    @SerializedName("consultaTrabajadorResponse")
    @Expose
    private ConsultaTrabajadorResponse consultaTrabajadorResponse;

    public ConsultaTrabajadorResponse getConsultaTrabajadorResponse() {
        return consultaTrabajadorResponse;
    }

    public void setConsultaTrabajadorResponse(ConsultaTrabajadorResponse consultaTrabajadorResponse) {
        this.consultaTrabajadorResponse = consultaTrabajadorResponse;
    }


    public static class ConsultaTrabajadorResponse {

        @SerializedName("success")
        @Expose
        private Boolean success;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("response")
        @Expose
        private Response response;

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Response getResponse() {
            return response;
        }

        public void setResponse(Response response) {
            this.response = response;
        }

    }

    public static class Afore {

        @SerializedName("activo")
        @Expose
        private String activo;
        @SerializedName("claveAfore")
        @Expose
        private String claveAfore;
        @SerializedName("descripcionAfore")
        @Expose
        private String descripcionAfore;
        @SerializedName("telefonoAfore")
        @Expose
        private String telefonoAfore;
        @SerializedName("tipoAdministracion")
        @Expose
        private String tipoAdministracion;

        public String getActivo() {
            return activo;
        }

        public void setActivo(String activo) {
            this.activo = activo;
        }

        public String getClaveAfore() {
            return claveAfore;
        }

        public void setClaveAfore(String claveAfore) {
            this.claveAfore = claveAfore;
        }

        public String getDescripcionAfore() {
            return descripcionAfore;
        }

        public void setDescripcionAfore(String descripcionAfore) {
            this.descripcionAfore = descripcionAfore;
        }

        public String getTelefonoAfore() {
            return telefonoAfore;
        }

        public void setTelefonoAfore(String telefonoAfore) {
            this.telefonoAfore = telefonoAfore;
        }

        public String getTipoAdministracion() {
            return tipoAdministracion;
        }

        public void setTipoAdministracion(String tipoAdministracion) {
            this.tipoAdministracion = tipoAdministracion;
        }

    }



    public static class Beneficiario {

        @SerializedName("apellidoMaterno")
        @Expose
        private String apellidoMaterno;
        @SerializedName("apellidoPaterno")
        @Expose
        private String apellidoPaterno;
        @SerializedName("nombre")
        @Expose
        private String nombre;
        @SerializedName("porcentaje")
        @Expose
        private String porcentaje;
        @SerializedName("parentesco")
        @Expose
        private Parentesco__1 parentesco;

        public String getApellidoMaterno() {
            return apellidoMaterno;
        }

        public void setApellidoMaterno(String apellidoMaterno) {
            this.apellidoMaterno = apellidoMaterno;
        }

        public String getApellidoPaterno() {
            return apellidoPaterno;
        }

        public void setApellidoPaterno(String apellidoPaterno) {
            this.apellidoPaterno = apellidoPaterno;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getPorcentaje() {
            return porcentaje;
        }

        public void setPorcentaje(String porcentaje) {
            this.porcentaje = porcentaje;
        }

        public Parentesco__1 getParentesco() {
            return parentesco;
        }

        public void setParentesco(Parentesco__1 parentesco) {
            this.parentesco = parentesco;
        }

    }



    public static class Canase {

        @SerializedName("nombreImss")
        @Expose
        private String nombreImss;
        @SerializedName("fechaAlta")
        @Expose
        private String fechaAlta;
        @SerializedName("fechaUltimaTransaccion")
        @Expose
        private String fechaUltimaTransaccion;
        @SerializedName("sexo")
        @Expose
        private String sexo;
        @SerializedName("mesNacimiento")
        @Expose
        private String mesNacimiento;
        @SerializedName("entidadFederativa")
        @Expose
        private String entidadFederativa;

        public String getNombreImss() {
            return nombreImss;
        }

        public void setNombreImss(String nombreImss) {
            this.nombreImss = nombreImss;
        }

        public String getFechaAlta() {
            return fechaAlta;
        }

        public void setFechaAlta(String fechaAlta) {
            this.fechaAlta = fechaAlta;
        }

        public String getFechaUltimaTransaccion() {
            return fechaUltimaTransaccion;
        }

        public void setFechaUltimaTransaccion(String fechaUltimaTransaccion) {
            this.fechaUltimaTransaccion = fechaUltimaTransaccion;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public String getMesNacimiento() {
            return mesNacimiento;
        }

        public void setMesNacimiento(String mesNacimiento) {
            this.mesNacimiento = mesNacimiento;
        }

        public String getEntidadFederativa() {
            return entidadFederativa;
        }

        public void setEntidadFederativa(String entidadFederativa) {
            this.entidadFederativa = entidadFederativa;
        }

    }


    public static class Domicilio {

        @SerializedName("calle")
        @Expose
        private String calle;
        @SerializedName("codigoPostal")
        @Expose
        private String codigoPostal;
        @SerializedName("colonia")
        @Expose
        private String colonia;
        @SerializedName("numeroExterior")
        @Expose
        private String numeroExterior;
        @SerializedName("fechaActualizaTrabajador")
        @Expose
        private String fechaActualizaTrabajador;
        @SerializedName("nsarMunicipio")
        @Expose
        private NsarMunicipio nsarMunicipio;
        @SerializedName("idTipoDomicilio")
        @Expose
        private String idTipoDomicilio;
        @SerializedName("numeroInterior")
        @Expose
        private String numeroInterior;

        public String getCalle() {
            return calle;
        }

        public void setCalle(String calle) {
            this.calle = calle;
        }

        public String getCodigoPostal() {
            return codigoPostal;
        }

        public void setCodigoPostal(String codigoPostal) {
            this.codigoPostal = codigoPostal;
        }

        public String getColonia() {
            return colonia;
        }

        public void setColonia(String colonia) {
            this.colonia = colonia;
        }

        public String getNumeroExterior() {
            return numeroExterior;
        }

        public void setNumeroExterior(String numeroExterior) {
            this.numeroExterior = numeroExterior;
        }

        public String getFechaActualizaTrabajador() {
            return fechaActualizaTrabajador;
        }

        public void setFechaActualizaTrabajador(String fechaActualizaTrabajador) {
            this.fechaActualizaTrabajador = fechaActualizaTrabajador;
        }

        public NsarMunicipio getNsarMunicipio() {
            return nsarMunicipio;
        }

        public void setNsarMunicipio(NsarMunicipio nsarMunicipio) {
            this.nsarMunicipio = nsarMunicipio;
        }

        public String getIdTipoDomicilio() {
            return idTipoDomicilio;
        }

        public void setIdTipoDomicilio(String idTipoDomicilio) {
            this.idTipoDomicilio = idTipoDomicilio;
        }

        public String getNumeroInterior() {
            return numeroInterior;
        }

        public void setNumeroInterior(String numeroInterior) {
            this.numeroInterior = numeroInterior;
        }

    }




    public static class EntidadFederativa {

        @SerializedName("chCvEntidadFederativa")
        @Expose
        private String chCvEntidadFederativa;
        @SerializedName("descripcion")
        @Expose
        private String descripcion;
        @SerializedName("claveCorta")
        @Expose
        private String claveCorta;
        @SerializedName("nuCvEntidadFederativa")
        @Expose
        private String nuCvEntidadFederativa;
        @SerializedName("pais")
        @Expose
        private Pais__1 pais;

        public String getChCvEntidadFederativa() {
            return chCvEntidadFederativa;
        }

        public void setChCvEntidadFederativa(String chCvEntidadFederativa) {
            this.chCvEntidadFederativa = chCvEntidadFederativa;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getClaveCorta() {
            return claveCorta;
        }

        public void setClaveCorta(String claveCorta) {
            this.claveCorta = claveCorta;
        }

        public String getNuCvEntidadFederativa() {
            return nuCvEntidadFederativa;
        }

        public void setNuCvEntidadFederativa(String nuCvEntidadFederativa) {
            this.nuCvEntidadFederativa = nuCvEntidadFederativa;
        }

        public Pais__1 getPais() {
            return pais;
        }

        public void setPais(Pais__1 pais) {
            this.pais = pais;
        }

    }




    public static class EntidadNacimiento {

        @SerializedName("chCvEntidadFederativa")
        @Expose
        private String chCvEntidadFederativa;
        @SerializedName("descripcion")
        @Expose
        private String descripcion;
        @SerializedName("claveCorta")
        @Expose
        private String claveCorta;
        @SerializedName("nuCvEntidadFederativa")
        @Expose
        private String nuCvEntidadFederativa;
        @SerializedName("pais")
        @Expose
        private Pais pais;

        public String getChCvEntidadFederativa() {
            return chCvEntidadFederativa;
        }

        public void setChCvEntidadFederativa(String chCvEntidadFederativa) {
            this.chCvEntidadFederativa = chCvEntidadFederativa;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getClaveCorta() {
            return claveCorta;
        }

        public void setClaveCorta(String claveCorta) {
            this.claveCorta = claveCorta;
        }

        public String getNuCvEntidadFederativa() {
            return nuCvEntidadFederativa;
        }

        public void setNuCvEntidadFederativa(String nuCvEntidadFederativa) {
            this.nuCvEntidadFederativa = nuCvEntidadFederativa;
        }

        public Pais getPais() {
            return pais;
        }

        public void setPais(Pais pais) {
            this.pais = pais;
        }

    }




    public static class Expediente {

        @SerializedName("codigoOperacion")
        @Expose
        private String codigoOperacion;
        @SerializedName("mensaje")
        @Expose
        private String mensaje;
        @SerializedName("response")
        @Expose
        private Response__1 response;

        public String getCodigoOperacion() {
            return codigoOperacion;
        }

        public void setCodigoOperacion(String codigoOperacion) {
            this.codigoOperacion = codigoOperacion;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public Response__1 getResponse() {
            return response;
        }

        public void setResponse(Response__1 response) {
            this.response = response;
        }

    }



    public static class NsarMunicipio {

        @SerializedName("descripcion")
        @Expose
        private String descripcion;
        @SerializedName("claveMunicipio")
        @Expose
        private String claveMunicipio;
        @SerializedName("entidadFederativa")
        @Expose
        private EntidadFederativa entidadFederativa;

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getClaveMunicipio() {
            return claveMunicipio;
        }

        public void setClaveMunicipio(String claveMunicipio) {
            this.claveMunicipio = claveMunicipio;
        }

        public EntidadFederativa getEntidadFederativa() {
            return entidadFederativa;
        }

        public void setEntidadFederativa(EntidadFederativa entidadFederativa) {
            this.entidadFederativa = entidadFederativa;
        }

    }


    public static class Pais {

        @SerializedName("descripcion")
        @Expose
        private String descripcion;
        @SerializedName("clavePais")
        @Expose
        private String clavePais;

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getClavePais() {
            return clavePais;
        }

        public void setClavePais(String clavePais) {
            this.clavePais = clavePais;
        }

    }



    public static class Pais__1 {

        @SerializedName("descripcion")
        @Expose
        private String descripcion;
        @SerializedName("clavePais")
        @Expose
        private String clavePais;

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getClavePais() {
            return clavePais;
        }

        public void setClavePais(String clavePais) {
            this.clavePais = clavePais;
        }

    }


    public static class Parentesco {

        @SerializedName("descripcion")
        @Expose
        private String descripcion;
        @SerializedName("claveParentesco")
        @Expose
        private String claveParentesco;

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getClaveParentesco() {
            return claveParentesco;
        }

        public void setClaveParentesco(String claveParentesco) {
            this.claveParentesco = claveParentesco;
        }

    }



    public static class Parentesco__1 {

        @SerializedName("descripcion")
        @Expose
        private String descripcion;
        @SerializedName("claveParentesco")
        @Expose
        private String claveParentesco;

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getClaveParentesco() {
            return claveParentesco;
        }

        public void setClaveParentesco(String claveParentesco) {
            this.claveParentesco = claveParentesco;
        }

    }




    public static class Participante {

        @SerializedName("nuActivo")
        @Expose
        private String nuActivo;

        public String getNuActivo() {
            return nuActivo;
        }

        public void setNuActivo(String nuActivo) {
            this.nuActivo = nuActivo;
        }

    }



    public static class Participante__1 {

        @SerializedName("nuActivo")
        @Expose
        private String nuActivo;

        public String getNuActivo() {
            return nuActivo;
        }

        public void setNuActivo(String nuActivo) {
            this.nuActivo = nuActivo;
        }

    }




    public static class Referencia {

        @SerializedName("parentesco")
        @Expose
        private Parentesco parentesco;
        @SerializedName("participante")
        @Expose
        private Participante__1 participante;
        @SerializedName("nombre")
        @Expose
        private String nombre;
        @SerializedName("telefono")
        @Expose
        private String telefono;
        @SerializedName("apellidoPaterno")
        @Expose
        private String apellidoPaterno;
        @SerializedName("apellidoMaterno")
        @Expose
        private String apellidoMaterno;

        public Parentesco getParentesco() {
            return parentesco;
        }

        public void setParentesco(Parentesco parentesco) {
            this.parentesco = parentesco;
        }

        public Participante__1 getParticipante() {
            return participante;
        }

        public void setParticipante(Participante__1 participante) {
            this.participante = participante;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getApellidoPaterno() {
            return apellidoPaterno;
        }

        public void setApellidoPaterno(String apellidoPaterno) {
            this.apellidoPaterno = apellidoPaterno;
        }

        public String getApellidoMaterno() {
            return apellidoMaterno;
        }

        public void setApellidoMaterno(String apellidoMaterno) {
            this.apellidoMaterno = apellidoMaterno;
        }

    }



    public static class Renapo {

        @SerializedName("CURP")
        @Expose
        private String curp;
        @SerializedName("apellido1")
        @Expose
        private String apellido1;
        @SerializedName("apellido2")
        @Expose
        private String apellido2;
        @SerializedName("nombres")
        @Expose
        private String nombres;
        @SerializedName("sexo")
        @Expose
        private String sexo;
        @SerializedName("fechNac")
        @Expose
        private String fechNac;
        @SerializedName("nacionalidad")
        @Expose
        private String nacionalidad;
        @SerializedName("docProbatorio")
        @Expose
        private String docProbatorio;
        @SerializedName("anioReg")
        @Expose
        private String anioReg;
        @SerializedName("numActa")
        @Expose
        private String numActa;
        @SerializedName("numEntidadReg")
        @Expose
        private String numEntidadReg;
        @SerializedName("cveMunicipioReg")
        @Expose
        private String cveMunicipioReg;
        @SerializedName("cveEntidadNac")
        @Expose
        private String cveEntidadNac;
        @SerializedName("statusCurp")
        @Expose
        private String statusCurp;
        @SerializedName("curpHistoricas")
        @Expose
        private String curpHistoricas;

        public String getCurp() {
            return curp;
        }

        public void setCurp(String curp) {
            this.curp = curp;
        }

        public String getApellido1() {
            return apellido1;
        }

        public void setApellido1(String apellido1) {
            this.apellido1 = apellido1;
        }

        public String getApellido2() {
            return apellido2;
        }

        public void setApellido2(String apellido2) {
            this.apellido2 = apellido2;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public String getFechNac() {
            return fechNac;
        }

        public void setFechNac(String fechNac) {
            this.fechNac = fechNac;
        }

        public String getNacionalidad() {
            return nacionalidad;
        }

        public void setNacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
        }

        public String getDocProbatorio() {
            return docProbatorio;
        }

        public void setDocProbatorio(String docProbatorio) {
            this.docProbatorio = docProbatorio;
        }

        public String getAnioReg() {
            return anioReg;
        }

        public void setAnioReg(String anioReg) {
            this.anioReg = anioReg;
        }

        public String getNumActa() {
            return numActa;
        }

        public void setNumActa(String numActa) {
            this.numActa = numActa;
        }

        public String getNumEntidadReg() {
            return numEntidadReg;
        }

        public void setNumEntidadReg(String numEntidadReg) {
            this.numEntidadReg = numEntidadReg;
        }

        public String getCveMunicipioReg() {
            return cveMunicipioReg;
        }

        public void setCveMunicipioReg(String cveMunicipioReg) {
            this.cveMunicipioReg = cveMunicipioReg;
        }

        public String getCveEntidadNac() {
            return cveEntidadNac;
        }

        public void setCveEntidadNac(String cveEntidadNac) {
            this.cveEntidadNac = cveEntidadNac;
        }

        public String getStatusCurp() {
            return statusCurp;
        }

        public void setStatusCurp(String statusCurp) {
            this.statusCurp = statusCurp;
        }

        public String getCurpHistoricas() {
            return curpHistoricas;
        }

        public void setCurpHistoricas(String curpHistoricas) {
            this.curpHistoricas = curpHistoricas;
        }

    }



    public static class Response {

        @SerializedName("afore")
        @Expose
        private Afore afore;
        @SerializedName("participante")
        @Expose
        private Participante participante;
        @SerializedName("apellidoMaterno")
        @Expose
        private String apellidoMaterno;
        @SerializedName("apellidoPaterno")
        @Expose
        private String apellidoPaterno;
        @SerializedName("nombre")
        @Expose
        private String nombre;
        @SerializedName("tipoAfiliacion")
        @Expose
        private String tipoAfiliacion;
        @SerializedName("fechaInicioAfore")
        @Expose
        private String fechaInicioAfore;
        @SerializedName("nss")
        @Expose
        private String nss;
        @SerializedName("curp")
        @Expose
        private String curp;
        @SerializedName("fechaNacimiento")
        @Expose
        private String fechaNacimiento;
        @SerializedName("sexo")
        @Expose
        private Sexo sexo;
        @SerializedName("entidadNacimiento")
        @Expose
        private EntidadNacimiento entidadNacimiento;
        @SerializedName("nacionalidad")
        @Expose
        private String nacionalidad;
        @SerializedName("telefonoList")
        @Expose
        private List<Telefono> telefonoList = null;
        @SerializedName("referenciaList")
        @Expose
        private List<Referencia> referenciaList = null;
        @SerializedName("beneficiarioList")
        @Expose
        private List<Beneficiario> beneficiarioList = null;
        @SerializedName("domicilioList")
        @Expose
        private List<Domicilio> domicilioList = null;
        @SerializedName("expediente")
        @Expose
        private Expediente expediente;
        @SerializedName("renapo")
        @Expose
        private Renapo renapo;
        @SerializedName("canase")
        @Expose
        private List<Canase> canase = null;

        public Afore getAfore() {
            return afore;
        }

        public void setAfore(Afore afore) {
            this.afore = afore;
        }

        public Participante getParticipante() {
            return participante;
        }

        public void setParticipante(Participante participante) {
            this.participante = participante;
        }

        public String getApellidoMaterno() {
            return apellidoMaterno;
        }

        public void setApellidoMaterno(String apellidoMaterno) {
            this.apellidoMaterno = apellidoMaterno;
        }

        public String getApellidoPaterno() {
            return apellidoPaterno;
        }

        public void setApellidoPaterno(String apellidoPaterno) {
            this.apellidoPaterno = apellidoPaterno;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTipoAfiliacion() {
            return tipoAfiliacion;
        }

        public void setTipoAfiliacion(String tipoAfiliacion) {
            this.tipoAfiliacion = tipoAfiliacion;
        }

        public String getFechaInicioAfore() {
            return fechaInicioAfore;
        }

        public void setFechaInicioAfore(String fechaInicioAfore) {
            this.fechaInicioAfore = fechaInicioAfore;
        }

        public String getNss() {
            return nss;
        }

        public void setNss(String nss) {
            this.nss = nss;
        }

        public String getCurp() {
            return curp;
        }

        public void setCurp(String curp) {
            this.curp = curp;
        }

        public String getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public Sexo getSexo() {
            return sexo;
        }

        public void setSexo(Sexo sexo) {
            this.sexo = sexo;
        }

        public EntidadNacimiento getEntidadNacimiento() {
            return entidadNacimiento;
        }

        public void setEntidadNacimiento(EntidadNacimiento entidadNacimiento) {
            this.entidadNacimiento = entidadNacimiento;
        }

        public String getNacionalidad() {
            return nacionalidad;
        }

        public void setNacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
        }

        public List<Telefono> getTelefonoList() {
            return telefonoList;
        }

        public void setTelefonoList(List<Telefono> telefonoList) {
            this.telefonoList = telefonoList;
        }

        public List<Referencia> getReferenciaList() {
            return referenciaList;
        }

        public void setReferenciaList(List<Referencia> referenciaList) {
            this.referenciaList = referenciaList;
        }

        public List<Beneficiario> getBeneficiarioList() {
            return beneficiarioList;
        }

        public void setBeneficiarioList(List<Beneficiario> beneficiarioList) {
            this.beneficiarioList = beneficiarioList;
        }

        public List<Domicilio> getDomicilioList() {
            return domicilioList;
        }

        public void setDomicilioList(List<Domicilio> domicilioList) {
            this.domicilioList = domicilioList;
        }

        public Expediente getExpediente() {
            return expediente;
        }

        public void setExpediente(Expediente expediente) {
            this.expediente = expediente;
        }

        public Renapo getRenapo() {
            return renapo;
        }

        public void setRenapo(Renapo renapo) {
            this.renapo = renapo;
        }

        public List<Canase> getCanase() {
            return canase;
        }

        public void setCanase(List<Canase> canase) {
            this.canase = canase;
        }

    }




    public static class Response__1 {

        @SerializedName("claveAforeExpBiometrico")
        @Expose
        private String claveAforeExpBiometrico;
        @SerializedName("claveAforeExpIdentificacion")
        @Expose
        private String claveAforeExpIdentificacion;
        @SerializedName("claveExpedienteIdentificacion")
        @Expose
        private String claveExpedienteIdentificacion;
        @SerializedName("descAforeExpBiometrico")
        @Expose
        private String descAforeExpBiometrico;
        @SerializedName("descAforeExpIdentificacion")
        @Expose
        private String descAforeExpIdentificacion;
        @SerializedName("estatusEnrolamiento")
        @Expose
        private String estatusEnrolamiento;
        @SerializedName("estatusExpedienteIdentificacion")
        @Expose
        private String estatusExpedienteIdentificacion;
        @SerializedName("expedienteMovil")
        @Expose
        private String expedienteMovil;
        @SerializedName("fechaEnrolamiento")
        @Expose
        private String fechaEnrolamiento;
        @SerializedName("fechaIDE")
        @Expose
        private String fechaIDE;
        @SerializedName("tipoIDE")
        @Expose
        private String tipoIDE;

        public String getClaveAforeExpBiometrico() {
            return claveAforeExpBiometrico;
        }

        public void setClaveAforeExpBiometrico(String claveAforeExpBiometrico) {
            this.claveAforeExpBiometrico = claveAforeExpBiometrico;
        }

        public String getClaveAforeExpIdentificacion() {
            return claveAforeExpIdentificacion;
        }

        public void setClaveAforeExpIdentificacion(String claveAforeExpIdentificacion) {
            this.claveAforeExpIdentificacion = claveAforeExpIdentificacion;
        }

        public String getClaveExpedienteIdentificacion() {
            return claveExpedienteIdentificacion;
        }

        public void setClaveExpedienteIdentificacion(String claveExpedienteIdentificacion) {
            this.claveExpedienteIdentificacion = claveExpedienteIdentificacion;
        }

        public String getDescAforeExpBiometrico() {
            return descAforeExpBiometrico;
        }

        public void setDescAforeExpBiometrico(String descAforeExpBiometrico) {
            this.descAforeExpBiometrico = descAforeExpBiometrico;
        }

        public String getDescAforeExpIdentificacion() {
            return descAforeExpIdentificacion;
        }

        public void setDescAforeExpIdentificacion(String descAforeExpIdentificacion) {
            this.descAforeExpIdentificacion = descAforeExpIdentificacion;
        }

        public String getEstatusEnrolamiento() {
            return estatusEnrolamiento;
        }

        public void setEstatusEnrolamiento(String estatusEnrolamiento) {
            this.estatusEnrolamiento = estatusEnrolamiento;
        }

        public String getEstatusExpedienteIdentificacion() {
            return estatusExpedienteIdentificacion;
        }

        public void setEstatusExpedienteIdentificacion(String estatusExpedienteIdentificacion) {
            this.estatusExpedienteIdentificacion = estatusExpedienteIdentificacion;
        }

        public String getExpedienteMovil() {
            return expedienteMovil;
        }

        public void setExpedienteMovil(String expedienteMovil) {
            this.expedienteMovil = expedienteMovil;
        }

        public String getFechaEnrolamiento() {
            return fechaEnrolamiento;
        }

        public void setFechaEnrolamiento(String fechaEnrolamiento) {
            this.fechaEnrolamiento = fechaEnrolamiento;
        }

        public String getFechaIDE() {
            return fechaIDE;
        }

        public void setFechaIDE(String fechaIDE) {
            this.fechaIDE = fechaIDE;
        }

        public String getTipoIDE() {
            return tipoIDE;
        }

        public void setTipoIDE(String tipoIDE) {
            this.tipoIDE = tipoIDE;
        }

    }



    public static class Sexo {

        @SerializedName("claveGenero")
        @Expose
        private String claveGenero;
        @SerializedName("descripcionGenero")
        @Expose
        private String descripcionGenero;

        public String getClaveGenero() {
            return claveGenero;
        }

        public void setClaveGenero(String claveGenero) {
            this.claveGenero = claveGenero;
        }

        public String getDescripcionGenero() {
            return descripcionGenero;
        }

        public void setDescripcionGenero(String descripcionGenero) {
            this.descripcionGenero = descripcionGenero;
        }

    }



    public static class Telefono {

        @SerializedName("claveTipoTelefono")
        @Expose
        private String claveTipoTelefono;
        @SerializedName("descTipoTelefono")
        @Expose
        private String descTipoTelefono;
        @SerializedName("numeroTelefono")
        @Expose
        private String numeroTelefono;
        @SerializedName("estatus")
        @Expose
        private String estatus;
        @SerializedName("extensionTelefonica")
        @Expose
        private String extensionTelefonica;

        public String getClaveTipoTelefono() {
            return claveTipoTelefono;
        }

        public void setClaveTipoTelefono(String claveTipoTelefono) {
            this.claveTipoTelefono = claveTipoTelefono;
        }

        public String getDescTipoTelefono() {
            return descTipoTelefono;
        }

        public void setDescTipoTelefono(String descTipoTelefono) {
            this.descTipoTelefono = descTipoTelefono;
        }

        public String getNumeroTelefono() {
            return numeroTelefono;
        }

        public void setNumeroTelefono(String numeroTelefono) {
            this.numeroTelefono = numeroTelefono;
        }

        public String getEstatus() {
            return estatus;
        }

        public void setEstatus(String estatus) {
            this.estatus = estatus;
        }

        public String getExtensionTelefonica() {
            return extensionTelefonica;
        }

        public void setExtensionTelefonica(String extensionTelefonica) {
            this.extensionTelefonica = extensionTelefonica;
        }

    }

}