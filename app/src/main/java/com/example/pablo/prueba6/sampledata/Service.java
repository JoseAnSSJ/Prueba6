package com.example.pablo.prueba6.sampledata;

import com.example.pablo.prueba6.Request.JSONResponseTecnico;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET(Constants.URL_GET_USER)
    Call<JsonObject> getDataUser();
    @GET(Constants.URL_GET_TECNICO)
    Call<JSONResponseTecnico> getDataTec();

}

