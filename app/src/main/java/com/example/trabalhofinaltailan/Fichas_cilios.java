package com.example.trabalhofinaltailan;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Fichas_cilios extends AppCompatActivity {

    private ListView lista_cilios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichas_cili);

        CiliosDAO lista_cilios= new CiliosDAO(this);
        ArrayList<Cilios> lista = lista_cilios.listar();

        // Cria um Adapter da lista de itens, para que realize a compatibilidade com a ListView
        ArrayAdapter<Cilios> adaptador = new ArrayAdapter<Cilios>(Fichas_cilios.this, android.R.layout.simple_list_item_1, lista);

        // InstancÃ­a o componente ListView adicionado ao layout, passando o Adapter para ela carregar os itens da listagem
        ListView minhaListView = (ListView) findViewById(R.id.exibir_cili);
        minhaListView.setAdapter(adaptador);

        // Implementa o evendo de click no item da listagem, para saber qual foi clicado e realizar algo com ele.
        minhaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Fichas_cilios.this, lista.get(i).toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}