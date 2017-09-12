package com.mlist.felip.mlist.modeloDb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}
