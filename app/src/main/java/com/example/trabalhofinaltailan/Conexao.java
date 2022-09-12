package com.example.trabalhofinaltailan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;

    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE clientes (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(255) NOT NULL, cpf VARCHAR (14), telefone VARCHAR(255), endereco VARCHAR (255), email VARCHAR (255))");
        db.execSQL("CREATE TABLE sobran (id INTEGER PRIMARY KEY AUTOINCREMENT, cod_cli INTEGER (255) NOT NULL, espa_sobra VARCHAR (14), espessura VARCHAR(255), altura_ini VARCHAR (255), altura_final VARCHAR (255))");
        db.execSQL("CREATE TABLE cilios (id INTEGER PRIMARY KEY AUTOINCREMENT, cod_cli INTEGER  NOT NULL, tipo_cili VARCHAR (50), tecnica VARCHAR(255), espessura VARCHAR (255), curvatura VARCHAR (255), cola VARCHAR (255))");
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


