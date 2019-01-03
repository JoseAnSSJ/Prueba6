package com.example.pablo.prueba6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pablo.prueba6.User.Login;
import com.example.pablo.prueba6.User.UserController;

public class Orden extends AppCompatActivity {
    Button orden, confi;
    UserController userController = new UserController();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenes);
        orden = (Button) findViewById(R.id.orden);
        confi = (Button) findViewById(R.id.confi);


        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
            }
        });

        //* Boton para ir a menu principal
        orden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento1 = new Intent(Orden.this, acivity_navegation.class);
                startActivity(intento1);
            }
        });

        confi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intento2 = new Intent(Orden.this, UserConfig.class);
                    startActivity(intento2);
            }
        });
try {

    if (UserController.b != true) {
        Toast.makeText(getApplicationContext(), "No estas logeado", Toast.LENGTH_LONG).show();
        Intent intento3 = new Intent(Orden.this, Login.class);
        startActivity(intento3);
    }
}catch (Exception e){
    Toast.makeText(getApplicationContext(), "No estas logeado", Toast.LENGTH_LONG).show();
    Intent intento3 = new Intent(Orden.this, Login.class);
    startActivity(intento3);
}
    }

}
