package com.reintegro.profuturo.app.domain.dto;

import com.reintegro.profuturo.app.data.entity.DateEntity;

public class ProcedureDto {
    private String id;
    private DateDto procedureDate;
    private String procedureFolio;
    private String binnacleFolio;
    private String applicantCurp;
    private Integer idProcess;
    private Integer idSubProcess;
    private Integer idApplicantType;
    private String authFolio;
    private String idChannel;
    private String voluntarySeal;
    private String idStatusVoluntarySeal;
    private Integer idStage;
    private Integer idSubStage;
    private Integer idChannelStage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateDto getProcedureDate() {
        return procedureDate;
    }

    public void setProcedureDate(DateDto procedureDate) {
        this.procedureDate = procedureDate;
    }

    public String getApplicantCurp() {
        return applicantCurp;
    }

    public void setApplicantCurp(String applicantCurp) {
        this.applicantCurp = applicantCurp;
    }

    public String getProcedureFolio() {
        return procedureFolio;
    }

    public void setProcedureFolio(String procedureFolio) {
        this.procedureFolio = procedureFolio;
    }

    public String getBinnacleFolio() {
        return binnacleFolio;
    }

    public void setBinnacleFolio(String binnacleFolio) {
        this.binnacleFolio = binnacleFolio;
    }

    public Integer getIdProcess() {
        return idProcess;
    }

    public void setIdProcess(Integer idProcess) {
        this.idProcess = idProcess;
    }

    public Integer getIdSubProcess() {
        return idSubProcess;
    }

    public void setIdSubProcess(Integer idSubProcess) {
        this.idSubProcess = idSubProcess;
    }

    public Integer getIdApplicantType() {
        return idApplicantType;
    }

    public void setIdApplicantType(Integer idApplicantType) {
        this.idApplicantType = idApplicantType;
    }

    public String getAuthFolio() {
        return authFolio;
    }

    public void setAuthFolio(String authFolio) {
        this.authFolio = authFolio;
    }

    public String getIdChannel() {
        return idChannel;
    }

    public void setIdChannel(String idChannel) {
        this.idChannel = idChannel;
    }

    public String getVoluntarySeal() {
        return voluntarySeal;
    }

    public void setVoluntarySeal(String voluntarySeal) {
        this.voluntarySeal = voluntarySeal;
    }

    public String getIdStatusVoluntarySeal() {
        return idStatusVoluntarySeal;
    }

    public void setIdStatusVoluntarySeal(String idStatusVoluntarySeal) {
        this.idStatusVoluntarySeal = idStatusVoluntarySeal;
    }

    public Integer getIdStage() {
        return idStage;
    }

    public void setIdStage(Integer idStage) {
        this.idStage = idStage;
    }

    public Integer getIdSubStage() {
        return idSubStage;
    }

    public void setIdSubStage(Integer idSubStage) {
        this.idSubStage = idSubStage;
    }

    public Integer getIdChannelStage() {
        return idChannelStage;
    }

    public void setIdChannelStage(Integer idChannelStage) {
        this.idChannelStage = idChannelStage;
    }
}
