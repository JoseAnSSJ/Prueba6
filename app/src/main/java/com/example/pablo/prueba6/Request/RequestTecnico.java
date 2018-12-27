package com.example.pablo.prueba6.Request;

import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
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

import org.json.JSONException;
import org.json.JSONObject;

public class RequestTecnico extends AppCompatActivity {
    public ArrayList<TecnicoModel> data;

    public void getClv_tecnico() throws JSONException {
    RestApiAdapter restApiAdapter = new RestApiAdapter();
    Service service = restApiAdapter.getTecService();
    Call<JSONResponseTecnico> call = service.getDataTec();
            call.enqueue(new Callback<JSONResponseTecnico>() {
        @Override
        public void onResponse(Call<JSONResponseTecnico> call, Response<JSONResponseTecnico> response) {
            JSONResponseTecnico jsonResponse = response.body();
            data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                   /* for(int i = 0; i<= data.size(); i= i++){
                        Log.d("response", data.get(i));
                    }*/
            Iterator<TecnicoModel> iteData = data.iterator();
            while (iteData.hasNext()){
                TecnicoModel dat = iteData.next();
                Log.d("response", dat.getClv_tecnico() );
            }
        }

        @Override
        public void onFailure(Call<JSONResponseTecnico> call, Throwable t) {

        }
});
    }
}



