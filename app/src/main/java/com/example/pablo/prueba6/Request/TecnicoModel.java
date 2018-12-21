package com.example.pablo.prueba6.Request;

public class TecnicoModel {
    private String BaseIdUser="";
    private String BaseRemoteIp="";
    private String clv_tecnico="";
    private String Tecnico="";

    public TecnicoModel(String baseIdUser, String baseRemoteIp, String clv_tecnico, String tecnico) {
        this.BaseIdUser = baseIdUser;
        this.BaseRemoteIp = baseRemoteIp;
        this.clv_tecnico = clv_tecnico;
        this.Tecnico = tecnico;
    }

    public String getBaseIdUser() {
        return BaseIdUser;
    }

    public String getBaseRemoteIp() {
        return BaseRemoteIp;
    }

    public String getClv_tecnico() {
        return clv_tecnico;
    }

    public String getTecnico() {
        return Tecnico;
    }

    public void setBaseIdUser(String baseIdUser) {
        BaseIdUser = baseIdUser;
    }

    public void setBaseRemoteIp(String baseRemoteIp) {
        BaseRemoteIp = baseRemoteIp;
    }

    public void setClv_tecnico(String clv_tecnico) {
        this.clv_tecnico = clv_tecnico;
    }

    public void setTecnico(String tecnico) {
        Tecnico = tecnico;
    }
}