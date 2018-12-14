package com.example.pablo.prueba6;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pablo.prueba6.User.Login;
import com.example.pablo.prueba6.User.UserController;
import com.example.pablo.prueba6.User.UserModel;


public class UserConfig extends AppCompatActivity {

    Button CS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_config);
        CS = (Button)findViewById(R.id.CS);

        CS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
UserModel.Token="";
               try {
                   UserController.b = false;
                   Intent intento = new Intent(UserConfig.this, Login.class);
                   startActivity(intento);
               }
               catch (Exception e){

               }

            }
        });

        if (UserController.b!=true) {
            Toast.makeText(getApplicationContext(), "No estas logeado", Toast.LENGTH_LONG).show();
            Intent intento3 = new Intent(UserConfig.this, Login.class);
            startActivity(intento3);
        }
    }

}
