package com.example.pablo.prueba6.sampledata;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.pablo.prueba6.User.Login;

import org.json.JSONException;
import org.json.JSONObject;

public class RestApiAdapter {

    public String abc="Basic "+Login.enco;
    public Service getClientService() {

            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {

                    Request newRequest = chain.request().newBuilder()
                            .addHeader("Authorization", abc)
                            .build();


                    return chain.proceed(newRequest);
                }
            }).build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.ROOT_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(Service.class);
        }
    public Service getTecService() throws JSONException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Clv_Usuario",""+Login.cvl_usuario);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {

                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", abc)
                        .addHeader("Content-Type", "application/json")
                        .post(body)
                        .build();


                return chain.proceed(newRequest);
            }
        }).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.ROOT_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }

}