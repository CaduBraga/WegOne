package com.wegone;

import java.sql.Connection;
import java.sql.SQLException;
import org.json.JSONObject;

public class TestaConexao {
    static JSONObject mensagensNoIdiomaEscolhido;

    public static void main(String[] args) {
        try (Connection conn = Conexao.conectar()) {
            traduzir("connection-successfully");
        } catch (SQLException e) {
            traduzir("connection-error");
            System.out.println(e.getMessage());
        }
    }

    private static void traduzir(String chave) {
        String mensagem = mensagensNoIdiomaEscolhido.optString(chave, chave);
        System.out.println(mensagem);
    }
}