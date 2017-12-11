package com.example.laudr.appdeeventos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by laudr on 21/11/2017.
 */

public class EventoDB extends SQLiteOpenHelper {

    public EventoDB(Context context) {
        super(context, "eventosbd.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists usuario" +
                "(_id integer primary key autoincrement, nome text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



    public Evento busca(int id) {
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.query("usuario", null, "id=?", new String[]{String.valueOf(id)},
                    null, null, null);
            // getCount(): nº de registros obtidos
            if (c.getCount() > 0) {
                c.moveToFirst();

                // 1, 2, 3... número da coluna recuperada
                String nome = c.getString(1);
                String local = c.getString(2);
                String atracao = c.getString(3);
                String data = c.getString(4);
                String detalhes = c.getString(5);
                double preco = c.getDouble(6);
                return new Evento(id, nome, local, preco,atracao, data, detalhes);
            } else {
                return new Evento(0, "", "", 0, "","","");
            }
        } finally {
            db.close();
        }
    }


}
