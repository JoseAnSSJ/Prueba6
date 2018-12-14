package com.example.pablo.prueba6;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;

import static android.content.Context.NOTIFICATION_SERVICE;


public class Notificaciones extends AppCompatActivity {
    public PendingIntent pendingIntent;
    public final static String CHANNEL_ID = "NOTIFICACION";
    public final static int NOTIFICACION_ID = 0;


}
