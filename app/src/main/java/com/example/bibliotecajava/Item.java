package com.example.bibliotecajava;

public class Item {
    private long id;
    private String nome;
    private String origen;
    private String data;
    private final String[] itemList = {"Book", "Magazine", "Cd","Pokemon"};
    private final String[] bookList = {"Author", "Number of Pages", "category", "type"};
    private final String[] magazineList = {"Publisher", "Number of Pages", "category", "type"};
    private final String[] cdList = {"Publisher/Singer", "Number of Records", "category", "Quality"};
    private final String[] pokeList = {"Name", "Combat Power", "Primary Type", "Catch City"};


    public void setItemValues(long id, String nome, String origen, String data){
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.origen = origen;
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

    public void setData(String data) {
        this.data = data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setOrigem(String origem) {
        this.origen = origem;
    }

    public long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }

    public String getOrigem() {
        return origen;
    }
}
