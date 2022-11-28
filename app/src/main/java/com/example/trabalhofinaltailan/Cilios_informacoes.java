package com.example.trabalhofinaltailan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Cilios_informacoes extends AppCompatActivity {
    private Button btn_cri_fic_cili;
    private Button btn_vizu_cili;
    private Button btn_voltar_cili;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilios);

        Button btn_cri_fic_cili = (Button) findViewById(R.id.btn_ficha_cili);
        btn_cri_fic_cili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Criar_ficha_cili.class);
                startActivity(intent);
            }
        });

        Button btn_vizu_cili = (Button) findViewById(R.id.btn_vizualizar_cili);
        btn_vizu_cili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Fichas_cilios.class);
                startActivity(intent);
            }
        });

        Button btn_voltar_cili = (Button) findViewById(R.id.btn_voltar_cili);
        btn_voltar_cili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
