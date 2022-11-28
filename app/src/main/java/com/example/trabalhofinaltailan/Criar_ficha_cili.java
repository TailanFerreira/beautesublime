package com.example.trabalhofinaltailan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Criar_ficha_cili extends AppCompatActivity {

    private EditText tipo_cili;
    private EditText tecnica;
    private EditText espessura;
    private EditText curvatura;
    private EditText cola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_ficha_cili);

        EditText tipo_cili = findViewById(R.id.tipo_cili);
        EditText tecnica = findViewById(R.id.tecnica);
        EditText espessura = findViewById(R.id.espessura_ci);
        EditText cola = findViewById(R.id.cola);

        Button btn_salvar = findViewById(R.id.btn_salvar_cili);
        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cilios model = new Cilios();
                model.setTipo_cilios(tipo_cili.getText().toString());
                model.setTecnica(tecnica.getText().toString());
                model.setEspessura(espessura.getText().toString());
                model.setCola(cola.getText().toString());

                CiliosDAO dao = new CiliosDAO(Criar_ficha_cili.this);
                long id = dao.inserir(model);

                Context contexto = Criar_ficha_cili.this;
                CharSequence texto = "Cílios " + id + " inserido com sucesso.";
                int duracao = Toast.LENGTH_LONG; // Toast.LENGTH_LONG

                Toast toast = Toast.makeText(contexto, texto, duracao);
                toast.show();
            }
        });

        Button btn_voltar = findViewById(R.id.btn_voltar_cili);
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Sobrancelhas_informacoes.class);
                startActivity(intent);
            }
        });
    }
}