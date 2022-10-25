package com.example.trabalhofinaltailan;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdicionarCli extends AppCompatActivity {
    private EditText nome;
    private EditText cpf;
    private EditText telefone;
    private EditText endereco;
    private EditText email;
    private Button btn_salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criacacliente);

        Button btn_salvar = findViewById(R.id.btn_salvar);
        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Cliente model = new Cliente();
                    model.setNome(nome.getText().toString());
                    model.setCpf(cpf.getText().toString());
                    model.setTelefone(telefone.getText().toString());
                    model.setEndereco(endereco.getText().toString());
                    model.setEmail(email.getText().toString());

                    ClienteDAO dao = new ClienteDAO(AdicionarCli.this);
                    long id = dao.inserir(model);

                    Context contexto = AdicionarCli.this;
                    CharSequence texto = "Cliente " + id + " inserido com sucesso.";
                    int duracao = Toast.LENGTH_LONG; // Toast.LENGTH_LONG

                    Toast toast = Toast.makeText(contexto, texto, duracao);
                    toast.show();
                }
        });
    }
}