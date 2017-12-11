package com.example.laudr.appdeeventos;

/**
 * Created by laudr on 10/11/2017.
 */

public class Evento {
    private int id;
    private String nome;
    private String local;
    private String atracao;
    private String data;
    private String detalhes;
    private double preco;

    public Evento(int id, String nome, String local, double preco, String atracao, String data, String detalhes) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.preco = preco;
        this.atracao = atracao;
        this.data = data;
        this.detalhes = detalhes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getAtracao() {
        return atracao;
    }

    public void setAtracao(String atracao) {
        this.atracao = atracao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
