package com.example.pablo.prueba6.Request;

import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.pablo.prueba6.sampledata.Constants.ROOT_URL;
import static com.example.pablo.prueba6.sampledata.Constants.URL_GET_TECNICO;

import com.example.pablo.prueba6.User.Login;
import com.example.pablo.prueba6.User.UserModel;
import com.example.pablo.prueba6.sampledata.RestApiAdapter;
import com.example.pablo.prueba6.sampledata.Service;
import com.google.gson.JsonObject;

import org.json.JSONObject;

public class RequestTecnico extends AppCompatActivity {
    public String url = ROOT_URL + URL_GET_TECNICO;
    String abc = "Basic " + Login.enco;


    public void clv_tec() {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        Map<String, String> params = new HashMap<String, String>();

        params.put("Clv_Usuario", "" + Login.cvl_usuario);


        JSONObject parameter = new JSONObject(params);

        OkHttpClient client = new OkHttpClient();

        final RequestBody body = RequestBody.create(JSON, parameter.toString());

        Request request = new Request.Builder().url(url).post(body).addHeader("content-type", "application/json; charset=utf-8").addHeader("Authorization", "Basic " + Login.enco).build();


    /*    final List<String> lista = new ArrayList();

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getClientService();
        Call<JsonObject> call = service.getDataUser();
        call.enqueue(new Callback<JsonObject>() {
                         @Override
                         public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                             JsonObject userJson = response.body().getAsJsonObject("Get_ClvTecnicoResult");
                             Log.d("response4", userJson.get("BaseIdUser").getAsString());
                             Log.d("response5", userJson.get("BaseRemoteIp").getAsString());
                             Log.d("response6", userJson.get("clv_tecnico").getAsString());
                             Log.d("response7", userJson.get("Tecnico").getAsString());
                             UserModel user = new UserModel(userJson.get("BaseIdUser").getAsString(),
                                     userJson.get("BaseRemoteIp").getAsString(),
                                     userJson.get("clv_tecnico").getAsString(),
                                     userJson.get("Tecnico").getAsString());
                         }

                         @Override
                         public void onFailure(Call<JsonObject> call, Throwable t) {

                         }
                     });
    }
}*/

      client.newCall(request).enqueue(new okhttp3.Callback() {

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                Log.e("response", response.body().string());


            }

            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.e("response", call.request().body().toString());

            }


        });
    }
}




