package com.wegone;

import java.util.Date;

public class Manual {
    private String titulo;
    private Date data;
    private String autor;
    private String texto;
    private TipoManual tipo;

    public Manual(String titulo, Date data, String autor, String texto, TipoManual tipo) {
        this.titulo = titulo;
        this.data = data;
        this.autor = autor;
        this.texto = texto;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        System.out.println("Data: " + data);
        System.out.println("Autor: " + autor);
        System.out.println("Texto: " + texto);
        System.out.println("Tipo: " + (tipo != null ? tipo.name() : "Não definido"));
        System.out.println("----------------------------");
    }

    public void cadastrar(String titulo, Date data, String autor, String texto, TipoManual tipo) {
        setTitulo(titulo);
        setData(data);
        setAutor(autor);
        setTexto(texto);
        setTipo(tipo);
        System.out.println("Manual \"" + getTitulo() + "\" cadastrado com sucesso!");
    }
// Edita o título
public void editarTitulo(String novoTitulo) {
    setTitulo(novoTitulo);
    System.out.println("Título atualizado para: " + getTitulo());
}

// Edita a data
public void editarData(Date novaData) {
    setData(novaData);
    System.out.println("Data atualizada para: " + getData());
}

// Edita o autor
public void editarAutor(String novoAutor) {
    setAutor(novoAutor);
    System.out.println("Autor atualizado para: " + getAutor());
}

// Edita o texto
public void editarTexto(String novoTexto) {
    setTexto(novoTexto);
    System.out.println("Texto atualizado.");
}

// Edita o tipo
public void editarTipo(TipoManual novoTipo) {
    setTipo(novoTipo);
    System.out.println("Tipo atualizado para: " + getTipo());
}

// AINDA FALTA TERMINAR, AJEITAR OS METODOS COMPARANDO-OS COM AS DEMAIS CLASSES

}
