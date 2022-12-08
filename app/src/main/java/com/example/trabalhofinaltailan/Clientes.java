package com.example.trabalhofinaltailan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Clientes extends AppCompatActivity{
private Button btn_adicionar_cli;
private Button btn_voltar_cli;
private Button btn_informacoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        Button btn_adicionar_cli = findViewById(R.id.btn_adicionar_cli);
        btn_adicionar_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarCli.class);
                startActivity(intent);
            }

        });

        Button btn_informacoes = findViewById(R.id.btn_informacoes_cli);
        btn_informacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InformacoesClientes.class);
                startActivity(intent);
            }
        });

        Button btn_voltar_cli = findViewById(R.id.btn_voltar_cli);
        btn_voltar_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
