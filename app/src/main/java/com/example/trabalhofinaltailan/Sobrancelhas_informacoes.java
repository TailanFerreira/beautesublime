package com.example.trabalhofinaltailan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Sobrancelhas_informacoes extends AppCompatActivity {
private Button btn_nova_ficha;
private Button btn_vizualizar;
private Button btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobrancelhas);

        Button btn_nova_ficha = (Button) findViewById(R.id.btn_ficha_sobran);
        btn_nova_ficha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Criar_ficha_sobr.class);
                startActivity(intent);
            }
        });
        Button btn_vizualizar = (Button) findViewById(R.id.btn_vizualizar_sobran);
        btn_vizualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Fichas_sobran.class);
                startActivity(intent);
            }
        });

        Button btn_voltar = (Button) findViewById(R.id.btn_voltar_cili);
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Fichas_sobran.class);
                startActivity(intent);
            }
        });
    }
}
