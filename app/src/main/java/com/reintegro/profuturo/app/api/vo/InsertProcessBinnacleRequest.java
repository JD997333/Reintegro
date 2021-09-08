package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InsertProcessBinnacleRequest {
    @Expose
    @SerializedName("folio")
    private String folio;
    @Expose
    @SerializedName("idEstatus")
    private Integer idEstatus;
    @Expose
    @SerializedName("idEtapa")
    private Integer idEtapa;
    @Expose
    @SerializedName("idResultado")
    private Integer idResultado;
    @Expose
    @SerializedName("idSubetapa")
    private Integer idSubetapa;
    @Expose
    @SerializedName("idSubproceso")
    private Integer idSubproceso;
    @Expose
    @SerializedName("usuario")
    private String usuario;

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Integer getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public Integer getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    public Integer getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Integer idResultado) {
        this.idResultado = idResultado;
    }

    public Integer getIdSubetapa() {
        return idSubetapa;
    }

    public void setIdSubetapa(Integer idSubetapa) {
        this.idSubetapa = idSubetapa;
    }

    public Integer getIdSubproceso() {
        return idSubproceso;
    }

    public void setIdSubproceso(Integer idSubproceso) {
        this.idSubproceso = idSubproceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
