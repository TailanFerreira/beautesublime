package com.example.trabalhofinaltailan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class SobrancelhaDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public SobrancelhaDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Sobrancelha model) {
        ContentValues values = new ContentValues();
        values.put("espaço_sobrancelha", model.getEspaço_sobrancelha());
        values.put("espessura", model.getEspessura());
        values.put("altura_inicial", model.getAltura_inicial());
        values.put("altura_final", model.getAltura_final());

        // Retorna o id do registro inserido
        return banco.insert("sobran", null, values);
    }

    public ArrayList<Sobrancelha> listar() {
        ArrayList<Sobrancelha> lista = new ArrayList<>();
        Cursor cursor = banco.query("sobran", new String[]{"id", "espa_sobra", "espessura", "altura_ini", "altura_final"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Sobrancelha model = new Sobrancelha();
            model.setId(cursor.getInt(0));
            model.setEspaço_sobrancelha(cursor.getString(1));
            model.setEspessura(cursor.getString(2));
            model.setAltura_inicial(cursor.getString(3));
            model.setAltura_final(cursor.getString(4));
            lista.add(model);
        }

        return lista;
    }

    public Sobrancelha ler(int id) {
        Sobrancelha model = new Sobrancelha();
        Cursor cursor = banco.query("sobran", new String[]{"id", "espa_sobra", "espessura", "altura_ini", "altura_final"}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        while (cursor.moveToNext()) {
            model.setId(cursor.getInt(0));
            model.setEspaço_sobrancelha(cursor.getString(1));
            model.setEspessura(cursor.getString(2));
            model.setAltura_inicial(cursor.getString(3));
            model.setAltura_final(cursor.getString(4));
        }
        return model;
    }

    public long atualizar(Sobrancelha model) {
        ContentValues values = new ContentValues();
        values.put("espaço_sobrancelha", model.getEspaço_sobrancelha());
        values.put("espessura", model.getEspessura());
        values.put("altura_inicial", model.getAltura_inicial());
        values.put("altura_final", model.getAltura_inicial());

        // Retorna o id do registro atualizado
        return banco.update("sobran", values, "id = ?", new String[]{String.valueOf(model.getId())});
    }

    public int excluir(Cliente model) {
        return banco.delete("sobran", "id = ?", new String[]{String.valueOf(model.getId())});
    }
}

