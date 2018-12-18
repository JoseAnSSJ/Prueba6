package com.example.pablo.prueba6.Request;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static com.example.pablo.prueba6.sampledata.Constants.URL_GET_TECNICO;

public interface ReqResApi {
    @Headers({
            "Content-Type: application/json", "Authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IlNJU1RFIiwibmJmIjoxNTQ1MTcxMDA0LCJleHAiOjE1NDYzNzEwMDQsImlhdCI6MTU0NTE3MTAwNH0.tFAD3uPkKlsUvHQmS0TZDIBzEmfuw9-MLBEfH7wF8_Q"
    })
    @POST(URL_GET_TECNICO)
    Call<ResponseBody> createUser(@Body TecnicoReqResRequest user);
}
