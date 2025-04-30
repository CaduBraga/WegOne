package com.wegone;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONObject;

public class Manual {
        static JSONObject mensagensNoIdiomaEscolhido;

        private int idManual;
        private String titulo;
        private Date dataDePublicacao;
        private String autor;
        private String texto;
        private TipoManual tipo;

        public Manual(int idManual, String titulo, Date dataDePublicacao, String autor, String texto, TipoManual tipo) {
                this.idManual = idManual;
                this.titulo = titulo;
                this.dataDePublicacao = dataDePublicacao;
                this.autor = autor;
                this.texto = texto;
                this.tipo = tipo;
        }

        public Manual() {
                // Não precisa atribuir nada, pois todos os campos são inicializados como null
                // ou valores padrão
        }

        public int getIdManual() {
                return idManual;
        }

        public void setIdManual(int idManual) {
                this.idManual = idManual;
        }

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public Date getDataDePublicacao() {
                return dataDePublicacao;
        }

        public void setDataDePublicacao(Date dataDePublicacao) {
                this.dataDePublicacao = dataDePublicacao;
        }

        public String getAutor() {
                return autor;
        }

        public void setAutor(String autor) {
                this.autor = autor;
        }

        public String getTexto() {
                return texto;
        }

        public void setTexto(String texto) {
                this.texto = texto;
        }

        public TipoManual getTipo() {
                return tipo;
        }

        public void setTipo(TipoManual tipo) {
                this.tipo = tipo;
        }

        public void imprimir() {
                traduzir("manual-data");
                traduzir("title:");
                System.out.println(titulo);
                traduzir("date:");
                System.out.println(dataDePublicacao);
                traduzir("author:");
                System.out.println(autor);
                traduzir("text:");
                System.out.println(texto);
                traduzir("type:");
                System.out.println(tipo);
                System.out.println("----------------------------");
        }

        public void cadastrar() {
                Scanner scanner = new Scanner(System.in);

                traduzir("type-the-title-of-the-manual");
                setTitulo(scanner.nextLine());

                traduzir("type-the-author-of-the-manual");
                setAutor(scanner.nextLine());

                traduzir("type-the-text-of-the-manual");
                setTexto(scanner.nextLine());

                TipoManual[] tipos = TipoManual.values();
                TipoManual escolhaTipo = null;
                do {
                        traduzir("select-the-type-of-the-manual");
                        for (int i = 0; i < tipos.length; i++) {
                                System.out.printf("%d) %s%n", i + 1, tipos[i].getDescricao());
                        }
                        System.out.print("> ");
                        int op = scanner.nextInt();
                        scanner.nextLine();
                        if (op >= 1 && op <= tipos.length) {
                                escolhaTipo = tipos[op - 1];
                        } else {
                                traduzir("invalid-option-try-again");
                        }
                } while (escolhaTipo == null);
                setTipo(escolhaTipo);

                Date agora = new Date();
                setDataDePublicacao(agora);

                String sql = "INSERT INTO manuais (titulo, autor, texto, dataDePublicacao, tipoManual) VALUES (?,?,?,?,?)";
                try (Connection conn = Conexao.conectar();
                                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                        stmt.setString(1, getTitulo());
                        stmt.setString(2, getAutor());
                        stmt.setString(3, getTexto());
                        stmt.setDate(4, new java.sql.Date(agora.getTime()));
                        stmt.setString(5, getTipo().getDescricao());
                        stmt.executeUpdate();

                        try (ResultSet rs = stmt.getGeneratedKeys()) {
                                if (rs.next())
                                        setIdManual(rs.getInt(1));
                        }
                        traduzir("manual-saved-successfully");
                        System.out.println(getIdManual());

                } catch (SQLException e) {
                        traduzir("error-saving-to-database");
                        System.out.println(e.getMessage());
                }
        }

        public static Manual[] buscarManuaisDoBanco() {
                String sqlCount = "SELECT COUNT(*) FROM manuais";
                int total = 0;
                try (Connection conn = Conexao.conectar();
                                PreparedStatement stmtCount = conn.prepareStatement(sqlCount);
                                ResultSet rsCount = stmtCount.executeQuery()) {
                        if (rsCount.next())
                                total = rsCount.getInt(1);
                } catch (SQLException e) {
                        traduzir("error-to-count-manuals");
                        System.out.println(e.getMessage());
                        return new Manual[0];
                }

                Manual[] manuais = new Manual[total];
                String sql = "SELECT id_manual, titulo, autor, texto, dataDePublicacao, tipoManual FROM manuais";
                try (Connection conn = Conexao.conectar();
                                PreparedStatement stmt = conn.prepareStatement(sql);
                                ResultSet rs = stmt.executeQuery()) {

                        int i = 0;
                        while (rs.next()) {
                                int id = rs.getInt("id_manual");
                                String titulo = rs.getString("titulo");
                                String autor = rs.getString("autor");
                                String texto = rs.getString("texto");
                                Date data = rs.getDate("dataDePublicacao");
                                String tipoStr = rs.getString("tipoManual");
                                TipoManual tipo = TipoManual.fromDescricao(tipoStr);

                                manuais[i++] = new Manual(id, titulo, data, autor, texto, tipo);
                        }
                } catch (SQLException e) {
                        traduzir("error-to-count-manuals");
                        System.out.println(e.getMessage());
                        return new Manual[0];
                }
                return manuais;
        }

        public static Manual buscarManualPorId(int id) {
                String sql = "SELECT * FROM manuais WHERE id_manual = ?";
                try (Connection conn = Conexao.conectar();
                                PreparedStatement stmt = conn.prepareStatement(sql)) {

                        stmt.setInt(1, id);
                        try (ResultSet rs = stmt.executeQuery()) {
                                if (rs.next()) {
                                        return new Manual(
                                                        id,
                                                        rs.getString("titulo"),
                                                        rs.getDate("dataDePublicacao"),
                                                        rs.getString("autor"),
                                                        rs.getString("texto"),
                                                        TipoManual.fromDescricao(rs.getString("tipoManual")));
                                }
                        }
                } catch (SQLException e) {
                        traduzir("error-to-search-manuals");
                        System.out.println(e.getMessage());
                }
                return null;
        }

        public static void excluirPorId(int id) {
                String sql = "DELETE FROM manuais WHERE id_manual = ?";
                try (Connection conn = Conexao.conectar();
                                PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setInt(1, id);
                        stmt.executeUpdate();
                        traduzir("excluded-manual");
                        System.out.println(id);
                } catch (SQLException e) {
                        traduzir("exclusion-error");
                        System.out.println(e.getMessage());
                }
        }

        public static void atualizarTitulo(int id, String novoTitulo) {
                String sql = "UPDATE manuais SET titulo = ? WHERE id_manual = ?";
                try (Connection conn = Conexao.conectar();
                                PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setString(1, novoTitulo);
                        stmt.setInt(2, id);
                        stmt.executeUpdate();
                        traduzir("title-updated");
                } catch (SQLException e) {
                        traduzir("title-update-error");
                        System.out.println(e.getMessage());
                }
        }

        public static void atualizarAutor(int id, String novoAutor) {
                String sql = "UPDATE manuais SET autor = ? WHERE id_manual = ?";
                try (Connection conn = Conexao.conectar();
                                PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setString(1, novoAutor);
                        stmt.setInt(2, id);
                        stmt.executeUpdate();
                        traduzir("updated-author");
                } catch (SQLException e) {
                        traduzir("update-author-error");
                        System.out.println(e.getMessage());
                }
        }

        public static void atualizarTexto(int id, String novoTexto) {
                String sql = "UPDATE manuais SET texto = ? WHERE id_manual = ?";
                try (Connection conn = Conexao.conectar();
                                PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setString(1, novoTexto);
                        stmt.setInt(2, id);
                        stmt.executeUpdate();
                        traduzir("text-updated");
                } catch (SQLException e) {
                        traduzir("error-to-update-text");
                        System.out.println(e.getMessage());

                }
        }

        public static void atualizarData(int id, Date novaData) {
                String sql = "UPDATE manuais SET dataDePublicacao = ? WHERE id_manual = ?";
                try (Connection conn = Conexao.conectar();
                                PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setDate(1, new java.sql.Date(novaData.getTime()));
                        stmt.setInt(2, id);
                        stmt.executeUpdate();
                        traduzir("update-date");
                } catch (SQLException e) {
                        traduzir("error-to-update-date");
                        System.out.println(e.getMessage());

                }
        }

        public static void atualizarTipo(int id, TipoManual novoTipo) {
                String sql = "UPDATE manuais SET tipoManual = ? WHERE id_manual = ?";
                try (Connection conn = Conexao.conectar();
                                PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setString(1, novoTipo.getDescricao());
                        stmt.setInt(2, id);
                        stmt.executeUpdate();
                        traduzir("updated-type");
                } catch (SQLException e) {
                        traduzir("error-to-update-type");
                        System.out.println(e.getMessage());

                }

        }

        private static void traduzir(String chave) {
                String mensagem = mensagensNoIdiomaEscolhido.optString(chave, chave);
                System.out.println(mensagem);
        }
}
//Ver onde é atualizar ou atualizar para: