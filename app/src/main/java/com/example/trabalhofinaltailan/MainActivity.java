package com.example.trabalhofinaltailan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
private Button btn_produtos;
private EditText listagem_produtos;
private Button btn_clientes;
private Button btn_sobrancelhas;
private Button btn_cilios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_produtos = findViewById(R.id.btn_produtos);
        btn_produtos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Busca Produtos
                try {
                    Produtos retorno = new Webservice(btn_produtos.getText().toString()).execute().get();
                    listagem_produtos.setText(retorno.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        Button btn_clientes = findViewById(R.id.btn_cliente);
        btn_clientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Clientes.class);
                startActivity(intent);
            }
        });

        Button btn_sobrancelhas = findViewById(R.id.btn_sobrancelha);
        btn_sobrancelhas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Sobrancelhas_informacoes.class);
                startActivity(intent);
            }
        });

        Button btn_cilios = findViewById(R.id.btn_cilios);
        btn_cilios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Cilios_informacoes.class);
                startActivity(intent);
            }
        });

        Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, notificationIntent, 0);
        NotificationChannel notificationChannel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel("CANAL_ID", "Tempo de Alarme....", NotificationManager.IMPORTANCE_DEFAULT);
        }
        NotificationManager notificationManager = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notificationManager = getSystemService(NotificationManager.class);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
        Notification notification = new NotificationCompat.Builder(MainActivity.this, "CANAL_ID")
                .setContentTitle("TÃ­tulo")
                .setContentText("Aproveito o aplicativo feito para você")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .build();

        notificationManager.notify(new Random().nextInt(85-65), notification);
    }
}