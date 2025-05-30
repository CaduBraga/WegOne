package com.wegone;

public class Usuario {
    private String login;
    private String tipo;

    public Usuario(int id, String login, String tipo) {
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