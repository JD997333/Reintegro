package com.reintegro.profuturo.app.api.vo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ValCoexistenceNCIResponse {

    @SerializedName("consultaConvivenciaCompletaComunNCIResponse")
    @Expose
    private CoexistenceNCIResponse coexistenceNCIResponse;

    public CoexistenceNCIResponse getConsultaConvivenciaCompletaComunNCIResponse() {
        return coexistenceNCIResponse;
    }

    public void setConsultaConvivenciaCompletaComunNCIResponse(CoexistenceNCIResponse coexistenceNCIResponse) {
        this.coexistenceNCIResponse = coexistenceNCIResponse;
    }


    public static class CoexistenceNCIResponse {

        @SerializedName("convive")
        @Expose
        private String convive;
        @SerializedName("descNoConvivencia")
        @Expose
        private String descNoConvivencia;
        @SerializedName("descSubproceso")
        @Expose
        private String descSubproceso;
        @SerializedName("idSubproceso")
        @Expose
        private String idSubproceso;
        @SerializedName("listaSubcuentaCompleta")
        @Expose
        private ListaSubcuentaCompleta listaSubcuentaCompleta;
        @SerializedName("mensaje")
        @Expose
        private String mensaje;
        @SerializedName("numCuentaIndividual")
        @Expose
        private String numCuentaIndividual;
        @SerializedName("subprocesoNoConvive")
        @Expose
        private SubprocesoNoConvive subprocesoNoConvive;

        public String getConvive() {
            return convive;
        }

        public void setConvive(String convive) {
            this.convive = convive;
        }

        public String getDescNoConvivencia() {
            return descNoConvivencia;
        }

        public void setDescNoConvivencia(String descNoConvivencia) {
            this.descNoConvivencia = descNoConvivencia;
        }

        public String getDescSubproceso() {
            return descSubproceso;
        }

        public void setDescSubproceso(String descSubproceso) {
            this.descSubproceso = descSubproceso;
        }

        public String getIdSubproceso() {
            return idSubproceso;
        }

        public void setIdSubproceso(String idSubproceso) {
            this.idSubproceso = idSubproceso;
        }

        public ListaSubcuentaCompleta getListaSubcuentaCompleta() {
            return listaSubcuentaCompleta;
        }

        public void setListaSubcuentaCompleta(ListaSubcuentaCompleta listaSubcuentaCompleta) {
            this.listaSubcuentaCompleta = listaSubcuentaCompleta;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getNumCuentaIndividual() {
            return numCuentaIndividual;
        }

        public void setNumCuentaIndividual(String numCuentaIndividual) {
            this.numCuentaIndividual = numCuentaIndividual;
        }

        public SubprocesoNoConvive getSubprocesoNoConvive() {
            return subprocesoNoConvive;
        }

        public void setSubprocesoNoConvive(SubprocesoNoConvive subprocesoNoConvive) {
            this.subprocesoNoConvive = subprocesoNoConvive;
        }

    }


    public static class Canal {


    }


    public static class EstatusProceso {


    }



    public static class Folio {

        @SerializedName("canal")
        @Expose
        private Canal canal;
        @SerializedName("estatusProceso")
        @Expose
        private EstatusProceso estatusProceso;
        @SerializedName("folio")
        @Expose
        private String folio;
        @SerializedName("proceso")
        @Expose
        private Proceso proceso;
        @SerializedName("subproceso")
        @Expose
        private Subprocess subproceso;

        public Canal getCanal() {
            return canal;
        }

        public void setCanal(Canal canal) {
            this.canal = canal;
        }

        public EstatusProceso getEstatusProceso() {
            return estatusProceso;
        }

        public void setEstatusProceso(EstatusProceso estatusProceso) {
            this.estatusProceso = estatusProceso;
        }

        public String getFolio() {
            return folio;
        }

        public void setFolio(String folio) {
            this.folio = folio;
        }

        public Proceso getProceso() {
            return proceso;
        }

        public void setProceso(Proceso proceso) {
            this.proceso = proceso;
        }

        public Subprocess getSubproceso() {
            return subproceso;
        }

        public void setSubproceso(Subprocess subproceso) {
            this.subproceso = subproceso;
        }

    }



    public static class FolioRelacionado {

        @SerializedName("canal")
        @Expose
        private Canal canal;
        @SerializedName("estatusProceso")
        @Expose
        private EstatusProceso estatusProceso;
        @SerializedName("proceso")
        @Expose
        private Proceso__1 proceso;
        @SerializedName("subproceso")
        @Expose
        private Subprocess subproceso;

        public Canal getCanal() {
            return canal;
        }

        public void setCanal(Canal canal) {
            this.canal = canal;
        }

        public EstatusProceso getEstatusProceso() {
            return estatusProceso;
        }

        public void setEstatusProceso(EstatusProceso estatusProceso) {
            this.estatusProceso = estatusProceso;
        }

        public Proceso__1 getProceso() {
            return proceso;
        }

        public void setProceso(Proceso__1 proceso) {
            this.proceso = proceso;
        }

        public Subprocess getSubproceso() {
            return subproceso;
        }

        public void setSubproceso(Subprocess subproceso) {
            this.subproceso = subproceso;
        }

    }



    public static class ListaSubcuentaCompleta {

        @SerializedName("subcuentaCompleta")
        @Expose
        private List<Object> subcuentaCompleta = null;

        public List<Object> getSubcuentaCompleta() {
            return subcuentaCompleta;
        }

        public void setSubcuentaCompleta(List<Object> subcuentaCompleta) {
            this.subcuentaCompleta = subcuentaCompleta;
        }

    }



    public static class MovimientoSubcuenta {

        @SerializedName("tipoMonto")
        @Expose
        private TipoMonto tipoMonto;

        public TipoMonto getTipoMonto() {
            return tipoMonto;
        }

        public void setTipoMonto(TipoMonto tipoMonto) {
            this.tipoMonto = tipoMonto;
        }

    }



    public static class Proceso {


    }



    public static class Proceso__1 {


    }



    public static class Subproceso {

        @SerializedName("descSubproceso")
        @Expose
        private String descSubproceso;
        @SerializedName("folio")
        @Expose
        private Folio folio;
        @SerializedName("folioRelacionado")
        @Expose
        private FolioRelacionado folioRelacionado;
        @SerializedName("idMarca")
        @Expose
        private String idMarca;
        @SerializedName("idSubproceso")
        @Expose
        private String idSubproceso;
        @SerializedName("movimientoSubcuenta")
        @Expose
        private MovimientoSubcuenta movimientoSubcuenta;
        @SerializedName("numeroCuentaIndividual")
        @Expose
        private String numeroCuentaIndividual;
        @SerializedName("tipoMonto")
        @Expose
        private TipoMonto__1 tipoMonto;
        @SerializedName("tipoSaldoOpera")
        @Expose
        private TipoSaldoOpera tipoSaldoOpera;

        public String getDescSubproceso() {
            return descSubproceso;
        }

        public void setDescSubproceso(String descSubproceso) {
            this.descSubproceso = descSubproceso;
        }

        public Folio getFolio() {
            return folio;
        }

        public void setFolio(Folio folio) {
            this.folio = folio;
        }

        public FolioRelacionado getFolioRelacionado() {
            return folioRelacionado;
        }

        public void setFolioRelacionado(FolioRelacionado folioRelacionado) {
            this.folioRelacionado = folioRelacionado;
        }

        public String getIdMarca() {
            return idMarca;
        }

        public void setIdMarca(String idMarca) {
            this.idMarca = idMarca;
        }

        public String getIdSubproceso() {
            return idSubproceso;
        }

        public void setIdSubproceso(String idSubproceso) {
            this.idSubproceso = idSubproceso;
        }

        public MovimientoSubcuenta getMovimientoSubcuenta() {
            return movimientoSubcuenta;
        }

        public void setMovimientoSubcuenta(MovimientoSubcuenta movimientoSubcuenta) {
            this.movimientoSubcuenta = movimientoSubcuenta;
        }

        public String getNumeroCuentaIndividual() {
            return numeroCuentaIndividual;
        }

        public void setNumeroCuentaIndividual(String numeroCuentaIndividual) {
            this.numeroCuentaIndividual = numeroCuentaIndividual;
        }

        public TipoMonto__1 getTipoMonto() {
            return tipoMonto;
        }

        public void setTipoMonto(TipoMonto__1 tipoMonto) {
            this.tipoMonto = tipoMonto;
        }

        public TipoSaldoOpera getTipoSaldoOpera() {
            return tipoSaldoOpera;
        }

        public void setTipoSaldoOpera(TipoSaldoOpera tipoSaldoOpera) {
            this.tipoSaldoOpera = tipoSaldoOpera;
        }

    }



    public static class SubprocesoNoConvive {

        @SerializedName("subproceso")
        @Expose
        private List<Subproceso> subproceso = null;

        public List<Subproceso> getSubproceso() {
            return subproceso;
        }

        public void setSubproceso(List<Subproceso> subproceso) {
            this.subproceso = subproceso;
        }

    }



    public static class Subprocess {


    }


    public static class TipoMonto {


    }



    public static class TipoMonto__1 {

        @SerializedName("tipoMonto")
        @Expose
        private TipoMonto__2 tipoMonto;

        public TipoMonto__2 getTipoMonto() {
            return tipoMonto;
        }

        public void setTipoMonto(TipoMonto__2 tipoMonto) {
            this.tipoMonto = tipoMonto;
        }

    }



    public static class TipoMonto__2 {


    }



    public static class TipoMonto__3 {

        @SerializedName("id")
        @Expose
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }


    public static class TipoSaldoOpera {

        @SerializedName("tipoMonto")
        @Expose
        private TipoMonto__3 tipoMonto;

        public TipoMonto__3 getTipoMonto() {
            return tipoMonto;
        }

        public void setTipoMonto(TipoMonto__3 tipoMonto) {
            this.tipoMonto = tipoMonto;
        }

    }

}