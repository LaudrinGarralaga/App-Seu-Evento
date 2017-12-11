package com.example.laudr.appdeeventos;

/**
 * Created by laudr on 10/11/2017.
 */

public class Convite {

    private int id;
    private String convidado;
    private String email;
    private int evento_id;

public Convite(int id, String convidado, String email, int evento_id) {
        this.id = id;
        this.convidado = convidado;
        this.email = email;
        this.evento_id = evento_id;
        }

public int getId() {
        return id;
        }
}
