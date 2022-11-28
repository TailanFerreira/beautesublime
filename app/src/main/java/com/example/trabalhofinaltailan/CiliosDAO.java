package com.example.trabalhofinaltailan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CiliosDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public CiliosDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Cilios model) {
        ContentValues values = new ContentValues();
        values.put("tipo_cilios", model.getTipo_cilios());
        values.put("tecnica", model.getTecnica());
        values.put("espessura", model.getEspessura());
        values.put("curvatura", model.getCurvatura());
        values.put("cola", model.getCola());

        // Retorna o id do registro inserido
        return banco.insert("cilios", null, values);
    }

    public ArrayList<Cilios> listar() {
        ArrayList<Cilios> lista = new ArrayList<>();
        Cursor cursor = banco.query("cilios", new String[]{"id", "tipo_cili", "tecnica", "espessura", "curvatura", "cola"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Cilios model = new Cilios();
            model.setId(cursor.getInt(0));
            model.setTipo_cilios(cursor.getString(1));
            model.setTecnica(cursor.getString(2));
            model.setEspessura(cursor.getString(3));
            model.setCurvatura(cursor.getString(4));
            model.setCola(cursor.getString(5));
            lista.add(model);
        }

        return lista;
    }

    public Cilios ler(int id) {
        Cilios model = new Cilios();
        Cursor cursor = banco.query("cilios", new String[]{"id", "tipo_cili", "tecnica", "espessura", "curvatura", "cola"}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        while (cursor.moveToNext()) {
            model.setId(cursor.getInt(0));
            model.setTipo_cilios(cursor.getString(1));
            model.setTecnica(cursor.getString(2));
            model.setEspessura(cursor.getString(3));
            model.setCurvatura(cursor.getString(4));
            model.setCola(cursor.getString(5));
        }
        return model;
    }

    public long atualizar(Cilios model) {
        ContentValues values = new ContentValues();
        values.put("tipo_cilios", model.getTipo_cilios());
        values.put("tecnica", model.getTecnica());
        values.put("espessura", model.getEspessura());
        values.put("curvatura", model.getCurvatura());
        values.put("cola", model.getCola());

        // Retorna o id do registro atualizado
        return banco.update("cilios", values, "id = ?", new String[]{String.valueOf(model.getId())});
    }

    public int excluir(Cliente model) {
        return banco.delete("cilios", "id = ?", new String[]{String.valueOf(model.getId())});
    }
}
