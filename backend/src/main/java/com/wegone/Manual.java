package com.wegone;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.json.JSONObject;

public class Manual {
    private static JSONObject mensagensNoIdiomaEscolhido;

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
        // campos inicializados com valores padrão (nulos/zerados)
    }

    public static void carregarIdioma(JSONObject root) {
        mensagensNoIdiomaEscolhido = root.getJSONObject("Messages"); // método para evitar erros ao puxar o idioma
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
        System.out.println("----- Dados do Manual -----");
        System.out.println("Título: " + titulo);
        System.out.println("Data: " + dataDePublicacao);
        System.out.println("Autor: " + autor);
        System.out.println("Texto: " + texto);
        System.out.println("Tipo: " + tipo.getDescricao());
        System.out.println("----------------------------");
    }

    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        traduzir("type-the-title-of-the-manual");
        System.out.print("> ");
        setTitulo(scanner.nextLine());

        traduzir("type-the-author-of-the-manual");
        System.out.print("> ");
        setAutor(scanner.nextLine());

        traduzir("type-the-text-of-the-manual");
        System.out.print("> ");
        setTexto(scanner.nextLine());

        TipoManual[] tipos = TipoManual.values();
        TipoManual escolhaTipo = null;

        do {
            traduzir("select-the-type-of-the-manual");
            traduzir("operational-conduct-manual");
            traduzir("diagnostic-manual");
            traduzir("manutance-manual");
            traduzir("operation-manual");
            traduzir("security-manual");
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
                if (rs.next()) {
                    setIdManual(rs.getInt(1));
                }
            }

            traduzir("manual-saved-successfully");
            System.out.println("ID: " + getIdManual());

        } catch (SQLException e) {
            traduzir("error-saving-to-database");
            System.out.println(e.getMessage());
        }
    }

    public static Manual[] buscarManuaisDoBanco() {
        List<Manual> lista = new ArrayList<>();
        String sql = "SELECT id_manual, titulo, autor, texto, dataDePublicacao, tipoManual FROM manuais";

        try (Connection conn = Conexao.conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Manual m = new Manual();
                m.setIdManual(rs.getInt("id_manual"));
                m.setTitulo(rs.getString("titulo"));
                m.setAutor(rs.getString("autor"));
                m.setTexto(rs.getString("texto"));
                m.setDataDePublicacao(rs.getDate("dataDePublicacao"));

                // Aqui o nome correto da coluna é tipoManual, não "tipo"
                String tipoDescricao = rs.getString("tipoManual");
                m.setTipo(TipoManual.fromDescricao(tipoDescricao));

                lista.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista.toArray(new Manual[0]);
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