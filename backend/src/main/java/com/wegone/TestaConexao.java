package com.wegone;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) {
        try (Connection conn = Conexao.conectar()) {
            System.out.println("Conectado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }
}