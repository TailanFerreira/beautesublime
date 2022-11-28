package com.example.trabalhofinaltailan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Criar_ficha_sobr extends AppCompatActivity {

    private EditText espaco_sobra;
    private EditText espessura;
    private EditText altura_inicial;
    private EditText altura_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_ficha_sobr);

        EditText espaco_sobra = findViewById(R.id.espa_sobra);
        EditText espessura = findViewById(R.id.espessura);
        EditText altura_inicial = findViewById(R.id.altura_ini);
        EditText altura_final = findViewById(R.id.altura_final);

        Button btn_salvar = findViewById(R.id.btn_salvar_sobra);
        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sobrancelha model = new Sobrancelha();
                model.setEspaço_sobrancelha(espaco_sobra.getText().toString());
                model.setEspessura(espessura.getText().toString());
                model.setAltura_inicial(altura_inicial.getText().toString());
                model.setAltura_final(altura_final.getText().toString());

                SobrancelhaDAO dao = new SobrancelhaDAO(Criar_ficha_sobr.this);
                long id = dao.inserir(model);

                Context contexto = Criar_ficha_sobr.this;
                CharSequence texto = "Sobrancelha " + id + " inserido com sucesso.";
                int duracao = Toast.LENGTH_LONG; // Toast.LENGTH_LONG

                Toast toast = Toast.makeText(contexto, texto, duracao);
                toast.show();
            }
        });

        Button btn_voltar = findViewById(R.id.btn_voltar_sob);
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}