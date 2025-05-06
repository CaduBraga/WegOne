package com.wegone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;

public class ValidacaoUsuario {
    static JSONObject mensagensNoIdiomaEscolhido;

    public static boolean usuarioExiste(String usuario) {
        // Verifica se o usuário existe na base de dados
        String sql = "SELECT COUNT(*) FROM usuarios WHERE login = ?";
        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true se o usuário existe
            }
        } catch (SQLException e) {
            traduzir("error-to-verify-user");
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static boolean validarSenha(String usuario, String senha) {
        // Verifica se a senha fornecida é válida para o nome de usuário fornecido.
        String sql = "SELECT COUNT(*) FROM usuarios WHERE login = ? AND senha = ?";
        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true se a senha for válida
            }
        } catch (SQLException e) {
            traduzir("error-to-verify-password");
            System.err.println(e.getMessage());
        }
        return false;
    }

    // Retorna o papel do usuário ('viewer', 'user' ou 'adm') se encontrar, ou null
    // caso inválido.
    public static String obterPapelDoUsuario(String usuario, String senha) {
        String sql = "SELECT tipo FROM usuarios WHERE login = ? AND senha = ?";
        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("tipo");
            }
        } catch (SQLException e) {
            traduzir("error-to-fetching-role");
            System.err.println(e.getMessage());
        }
        return null;
    }

    private static void traduzir(String chave) {
        String mensagem = mensagensNoIdiomaEscolhido.optString(chave, chave);
        System.out.println(mensagem);
    }
}
