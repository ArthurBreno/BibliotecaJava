package com.example.bibliotecajava;

public class Item {
    private long id;
    private String nome;
    private String origem;
    private String data;

    public void setItemValues(long id, String nome, String origem, String data){
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.origem = origem;
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
        this.origem = origem;
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
        return origem;
    }
}
