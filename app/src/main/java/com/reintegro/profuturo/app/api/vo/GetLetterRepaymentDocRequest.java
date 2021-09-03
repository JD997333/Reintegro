package com.reintegro.profuturo.app.api.vo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLetterRepaymentDocRequest {
    @SerializedName("folio")
    @Expose
    private String folio;
    @SerializedName("dia")
    @Expose
    private String dia;
    @SerializedName("mes")
    @Expose
    private String mes;
    @SerializedName("anio")
    @Expose
    private String anio;
    @SerializedName("numCuenta")
    @Expose
    private String numCuenta;
    @SerializedName("nss")
    @Expose
    private String nss;
    @SerializedName("curp")
    @Expose
    private String curp;
    @SerializedName("nombreCompleto")
    @Expose
    private String nombreCompleto;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("colonia")
    @Expose
    private String colonia;
    @SerializedName("cp")
    @Expose
    private String cp;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("semanasaReintegrar")
    @Expose
    private String semanasaReintegrar;
    @SerializedName("monto")
    @Expose
    private String monto;
    @SerializedName("numConvenio")
    @Expose
    private String numConvenio;
    @SerializedName("referencia")
    @Expose
    private String referencia;
    @SerializedName("concepto")
    @Expose
    private String concepto;
    @SerializedName("diasHabiles")
    @Expose
    private String diasHabiles;
    @SerializedName("avisoPrivacidad")
    @Expose
    private String avisoPrivacidad;

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSemanasaReintegrar() {
        return semanasaReintegrar;
    }

    public void setSemanasaReintegrar(String semanasaReintegrar) {
        this.semanasaReintegrar = semanasaReintegrar;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getNumConvenio() {
        return numConvenio;
    }

    public void setNumConvenio(String numConvenio) {
        this.numConvenio = numConvenio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDiasHabiles() {
        return diasHabiles;
    }

    public void setDiasHabiles(String diasHabiles) {
        this.diasHabiles = diasHabiles;
    }

    public String getAvisoPrivacidad() {
        return avisoPrivacidad;
    }

    public void setAvisoPrivacidad(String avisoPrivacidad) {
        this.avisoPrivacidad = avisoPrivacidad;
    }

}
