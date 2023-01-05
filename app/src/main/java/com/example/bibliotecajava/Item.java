package com.example.bibliotecajava;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

public class Item {
    private Context context;
    private long id;
    private String type;
    private String parametro01;
    private String parametro02;
    private String parametro03;
    private String parametro04;
    private final String[] itemList = {"Book", "Magazine", "Cd","Pokemon"};
    private final String[] bookList = {"Author", "Number of Pages", "category", "type"};
    private final String[] magazineList = {"Publisher", "Number of Pages", "category", "type"};
    private final String[] cdList = {"Publisher/Singer", "Number of Records", "category", "Quality"};
    private final String[] pokeList = {"Name", "Combat Power", "Primary Type", "Catch City"};

    public void setItemValues(String parametro1, String parametro2, String parametro3, String parametro4){
        this.parametro01 = parametro1;
        this.parametro02 = parametro2;
        this.parametro03 = parametro3;
        this.parametro04 = parametro4;

    }

    public void setContext(Context contexto){
        this.context = contexto;
    }

    public String[] getItemList(){
        return itemList;
    }
    public String[] getBookList(){
        return bookList;
    }
    public String[] getMagazineList(){
        return magazineList;
    }
    public String[] getCdList(){
        return cdList;
    }
    public String[] getPokeList(){
        return pokeList;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setParametro01(String parametro01) {
        this.parametro01 = parametro01;
    }

    public void setParametro02(String numero) {
        this.parametro02 = numero;
    }

    public String getType() {
        String temp = type;
        return temp;

    }

    public String getParametro01() {
        return parametro01;
    }
    public String getParametro02() {
        return parametro02;
    }

    public String getParametro03() {
        return parametro03;
    }

    public String getParametro04() {
        return parametro04;
    }

    public void setParametro04(String parametro04) {
        this.parametro04 = parametro04;
    }


    public void setParametro03(String parametro03) {
        this.parametro03 = parametro03;
    }



    public void setType(String type) {
        this.type = type;
    }
}
