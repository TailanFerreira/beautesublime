package com.example.trabalhofinaltailan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
private Button btn_produtos;
private EditText listagem_produtos;
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
    }
}