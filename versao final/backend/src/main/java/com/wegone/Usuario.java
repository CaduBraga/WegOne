package com.wegone;

public class Usuario {
    private int id;
    private String login;
    private String tipo;

    public Usuario(int id, String login, String tipo) {
        this.id = id;
        this.login = login;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLogin() {
        return login;
    }
}