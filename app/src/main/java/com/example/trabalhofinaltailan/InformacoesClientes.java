package com.example.trabalhofinaltailan;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class InformacoesClientes extends AppCompatActivity {
private ListView lista_clientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibircli);

        ClienteDAO lista_clientes = new ClienteDAO(this);
        ArrayList<Cliente> lista = lista_clientes.listar();

        // Cria um Adapter da lista de itens, para que realize a compatibilidade com a ListView
        ArrayAdapter<Cliente> adaptador = new ArrayAdapter<Cliente>(InformacoesClientes.this, android.R.layout.simple_list_item_1, lista);

        // InstancÃ­a o componente ListView adicionado ao layout, passando o Adapter para ela carregar os itens da listagem
        ListView minhaListView = (ListView) findViewById(R.id.exibir_cli);
        minhaListView.setAdapter(adaptador);

        // Implementa o evendo de click no item da listagem, para saber qual foi clicado e realizar algo com ele.
        minhaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(InformacoesClientes.this, lista.get(i).toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}