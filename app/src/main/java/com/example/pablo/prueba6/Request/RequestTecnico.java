package com.example.pablo.prueba6.Request;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.pablo.prueba6.sampledata.Constants.ROOT_URL;
import com.example.pablo.prueba6.acivity_navegation;

public class RequestTecnico {
    acivity_navegation acivity_navegation = new acivity_navegation();

    public void clv_tec() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient);
        Retrofit retrofit = retrofitBuilder.build();
        ReqResApi service = retrofit.create(ReqResApi.class);
        TecnicoReqResRequest user = new TecnicoReqResRequest("SISTE");
        Call<ResponseBody> callableResponse = service.createUser(user);
        dumpCallableResponse(callableResponse);
    }

    private <T> void dumpCallableResponse(Call<T> callableResponse) {
        Request request = callableResponse.request();
        try {
            Buffer buffer = new Buffer();
            String show = request.toString() + "headers: " + request.headers();
            if (request.body() != null) {
                request.body().writeTo(buffer);
                show += "Body : " + buffer.readString(Charset.defaultCharset());
            }

            updateResult(show + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        callableResponse.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                try {
                    updateResult(acivity_navegation.clv.getText() + ("\nResponse : " + getStrFromResponseBody(response)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {

            }
        });
    }

    Handler mainThreadHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //  tokenn.setText(msg.obj.toString());
        }
    };

    private void updateResult(String myResponse) {
        Message msg = Message.obtain();
        msg.obj = myResponse;
        mainThreadHandler.sendMessage(msg);
    }

    public <T> String getStrFromResponseBody(Response<T> response) throws IOException {
        String body = "";
        if (response.body() instanceof ResponseBody)
            body = ((ResponseBody) response.body()).string();
        else if (response.body() == null)
            body = "";
        else
            body = response.body().toString();
        acivity_navegation.clv.setText(body);
        return String.format(Locale.US, "headers:\n %s, \nmessage \n: %s\nbody:\n %s\n", response.headers(), response.message(), body);

    }
}
