package com.mlist.felip.mlist.modeloDb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mlist.felip.mlist.modelo.Filme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felip on 12/09/2017.
 */

public class FilmeModeloBD extends SQLiteOpenHelper {
    public FilmeModeloBD(Context context) {
        super(context, "Lista", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE Lista (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, genero TEXT, nota REAL);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS Lista";
        db.execSQL(sql);
        onCreate(db);

    }

    public void insere(Filme filme) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", filme.getNome());
        dados.put("genero", filme.getGenero());
        dados.put("nota", filme.getNota());

        db.insert("Lista", null, dados);
    }

    public List<Filme> buscaFilmes() {

        String sql = "SELECT * FROM Lista;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Filme> filmes = new ArrayList<Filme>();
        while(c.moveToNext()){
            Filme recFilme = new Filme();
            recFilme.setId(c.getLong(c.getColumnIndex("id")));
            recFilme.setNome(c.getString(c.getColumnIndex("nome")));
            recFilme.setGenero(c.getString(c.getColumnIndex("genero")));
            recFilme.setNota(c.getDouble(c.getColumnIndex("nota")));

            filmes.add(recFilme);
        }
        c.close();

        return filmes;
    }

}
