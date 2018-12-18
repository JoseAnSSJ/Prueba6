package com.example.pablo.prueba6.Request;

public class TecnicoReqResRequest {
    public String Clv_Usuario;

    public TecnicoReqResRequest(String Clv_Usuario){
        this.Clv_Usuario= Clv_Usuario;
    }
    @Override
    public String toString() { return "Clv_Usuario" + Clv_Usuario; }
}
