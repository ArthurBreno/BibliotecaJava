package com.example.bibliotecajava;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    //----
    private Context context;
    private static final String DATABASE_NAME = "LibraryJava.db";
    private static final int DATABASE_VERSION = 1;
    //----
    private static final String TABLE_NAME = "temp_name";
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



}

