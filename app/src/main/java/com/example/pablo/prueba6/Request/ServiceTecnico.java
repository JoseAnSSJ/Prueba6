package com.example.pablo.prueba6.Request;

import com.example.pablo.prueba6.sampledata.Constants;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceTecnico {
    @GET(Constants.URL_GET_TECNICO)
    Call<JsonObject> getDataUser();
}
