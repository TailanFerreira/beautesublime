package com.example.trabalhofinaltailan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ClienteDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ClienteDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Cliente model) {
        ContentValues values = new ContentValues();
        values.put("nome", model.getNome());
        values.put("cpf", model.getCpf());
        values.put("telefone", model.getTelefone());
        values.put("endereco", model.getEndereco());
        values.put("email", model.getEmail());

        // Retorna o id do registro inserido
        return banco.insert("clientes", null, values);
    }

    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> lista = new ArrayList<>();
        Cursor cursor = banco.query("clientes", new String[]{"id", "nome", "cpf", "telefone", "endereco", "email"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Cliente model = new Cliente();
            model.setId(cursor.getInt(0));
            model.setNome(cursor.getString(1));
            model.setCpf(cursor.getString(2));
            model.setTelefone(cursor.getString(3));
            model.setEndereco(cursor.getString(4));
            model.setEmail(cursor.getString(5));
            lista.add(model);
        }

        return lista;
    }

    public Cliente ler(int id) {
        Cliente model = new Cliente();
        Cursor cursor = banco.query("clientes", new String[]{"id", "nome", "cpf", "telefone", "endereco", "email"}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        while (cursor.moveToNext()) {
            model.setId(cursor.getInt(0));
            model.setNome(cursor.getString(1));
            model.setCpf(cursor.getString(2));
            model.setTelefone(cursor.getString(3));
            model.setEndereco(cursor.getString(4));
            model.setEmail(cursor.getString(5));
        }
        return model;
    }

    public long atualizar(Cliente model) {
        ContentValues values = new ContentValues();
        values.put("nome", model.getNome());
        values.put("cpf", model.getCpf());
        values.put("telefone", model.getTelefone());
        values.put("endereco", model.getEndereco());
        values.put("email", model.getEmail());

        // Retorna o id do registro atualizado
        return banco.update("clientes", values, "id = ?", new String[]{String.valueOf(model.getId())});
    }

    public int excluir(Cliente model) {
        return banco.delete("clientes", "id = ?", new String[]{String.valueOf(model.getId())});
    }
}