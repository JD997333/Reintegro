package com.reintegro.profuturo.app.api.vo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRepaymentSolicitudeDocRequest {
    @SerializedName("folio")
    @Expose
    private String folio;
    @SerializedName("desdSucursal")
    @Expose
    private String desdSucursal;
    @SerializedName("numSucursal")
    @Expose
    private String numSucursal;
    @SerializedName("numCuenta")
    @Expose
    private String numCuenta;
    @SerializedName("nss")
    @Expose
    private String nss;
    @SerializedName("curp")
    @Expose
    private String curp;
    @SerializedName("fechSol")
    @Expose
    private String fechSol;
    @SerializedName("apellidoPaterno")
    @Expose
    private String apellidoPaterno;
    @SerializedName("apellidoMater")
    @Expose
    private String apellidoMaterno;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("fecRetiro")
    @Expose
    private String fecRetiro;
    @SerializedName("semanDescontadas")
    @Expose
    private String semanDescontadas;
    @SerializedName("maxSemanReintegrar")
    @Expose
    private String maxSemanReintegrar;
    @SerializedName("maxMontoReintegrar")
    @Expose
    private String maxMontoReintegrar;
    @SerializedName("semanReintegrar")
    @Expose
    private String semanReintegrar;
    @SerializedName("montoReintegarar")
    @Expose
    private String montoReintegrar;
    @SerializedName("avisoPrivacidad")
    @Expose
    private String avisoPrivacidad;
    @SerializedName("imagenFirmaAfore")
    @Expose
    private String imagenFirmaAfore;
    @SerializedName("imagenFirmaCliente")
    @Expose
    private String imagenFirmaCliente;
    @SerializedName("nombreFirmaReceptorAfore")
    @Expose
    private String nombreFirmaReceptorAfore;
    @SerializedName("nombreFirmaCliente")
    @Expose
    private String nombreFirmaCliente;

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getDesdSucursal() {
        return desdSucursal;
    }

    public void setDesdSucursal(String desdSucursal) {
        this.desdSucursal = desdSucursal;
    }

    public String getNumSucursal() {
        return numSucursal;
    }

    public void setNumSucursal(String numSucursal) {
        this.numSucursal = numSucursal;
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

    public String getFechSol() {
        return fechSol;
    }

    public void setFechSol(String fechSol) {
        this.fechSol = fechSol;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecRetiro() {
        return fecRetiro;
    }

    public void setFecRetiro(String fecRetiro) {
        this.fecRetiro = fecRetiro;
    }

    public String getSemanDescontadas() {
        return semanDescontadas;
    }

    public void setSemanDescontadas(String semanDescontadas) {
        this.semanDescontadas = semanDescontadas;
    }

    public String getMaxSemanReintegrar() {
        return maxSemanReintegrar;
    }

    public void setMaxSemanReintegrar(String maxSemanReintegrar) {
        this.maxSemanReintegrar = maxSemanReintegrar;
    }

    public String getMaxMontoReintegrar() {
        return maxMontoReintegrar;
    }

    public void setMaxMontoReintegrar(String maxMontoReintegrar) {
        this.maxMontoReintegrar = maxMontoReintegrar;
    }

    public String getSemanReintegrar() {
        return semanReintegrar;
    }

    public void setSemanReintegrar(String semanReintegrar) {
        this.semanReintegrar = semanReintegrar;
    }

    public String getMontoReintegrar() {
        return montoReintegrar;
    }

    public void setMontoReintegrar(String montoReintegrar) {
        this.montoReintegrar = montoReintegrar;
    }

    public String getAvisoPrivacidad() {
        return avisoPrivacidad;
    }

    public void setAvisoPrivacidad(String avisoPrivacidad) {
        this.avisoPrivacidad = avisoPrivacidad;
    }

    public String getImagenFirmaAfore() {
        return imagenFirmaAfore;
    }

    public void setImagenFirmaAfore(String imagenFirmaAfore) {
        this.imagenFirmaAfore = imagenFirmaAfore;
    }

    public String getImagenFirmaCliente() {
        return imagenFirmaCliente;
    }

    public void setImagenFirmaCliente(String imagenFirmaCliente) {
        this.imagenFirmaCliente = imagenFirmaCliente;
    }

    public String getNombreFirmaReceptorAfore() {
        return nombreFirmaReceptorAfore;
    }

    public void setNombreFirmaReceptorAfore(String nombreFirmaReceptorAfore) {
        this.nombreFirmaReceptorAfore = nombreFirmaReceptorAfore;
    }

    public String getNombreFirmaCliente() {
        return nombreFirmaCliente;
    }

    public void setNombreFirmaCliente(String nombreFirmaCliente) {
        this.nombreFirmaCliente = nombreFirmaCliente;
    }
}