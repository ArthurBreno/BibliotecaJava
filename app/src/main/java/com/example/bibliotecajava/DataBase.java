package com.example.bibliotecajava;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Date;

public class DataBase extends SQLiteOpenHelper {
    //----
    private Context context;
    private static final String DATABASE_NAME = "LibraryJava.db";
    private static final int DATABASE_VERSION = 1;
    //----
    private static final String TABLE_NAME = "tabela";
    private static final String COLUMN_ID = "id";
    private static final String DATA = "date";
    private static final String TYPE = "type";
    private static final String PARAM_01 = "param01";
    private static final String PARAM_02 = "param02";
    private static final String PARAM_03 = "param03";
    private static final String PARAM_04 = "param04";


    public DataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String queryCreateTable = gerarQuery();
    db.execSQL(queryCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      String casa =  "DROP TABLE IF EXISTS " + TABLE_NAME;
      sqLiteDatabase.execSQL(casa);
      onCreate(sqLiteDatabase);
    }

    public void testar(){


    }

    private String gerarQuery(){
      return "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DATA + " TEXT, " +
              TYPE + " TEXT, " + PARAM_01 + " TEXT, " + PARAM_02 + " INTEGER, " + PARAM_03 + " TEXT, " + PARAM_04 + " TEXT);";

    }

    private void atribuirVariaveisIemParaDataBase(){

    }

    public long updateDataBase(Item item){
        Date date = new Date();
        //DataBase dataBase = new DataBase(context);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DATA, date.toString());
        String tipo = item.getType();
        String p1 = item.getParametro01();
        String p2 = item.getParametro02();
        String p3 = item.getParametro03();
        String p4 = item.getParametro04();
        values.put(TYPE, tipo);
        values.put(PARAM_01, p1);
        values.put(PARAM_02, p2);
        values.put(PARAM_03, p3);
        values.put(PARAM_04, p4);
        return db.insert(TABLE_NAME, null, values);
    }

    private String queryRecuperarDateBase(){
        return  "SELECT * FROM " + TABLE_NAME;
    }

    public Cursor recuperarDados(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(queryRecuperarDateBase(), null);
        }
        return cursor;
    }



}

