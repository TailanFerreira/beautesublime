package com.example.trabalhofinaltailan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    }
}