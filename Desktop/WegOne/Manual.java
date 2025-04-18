import java.util.Date;

public abstract class Manual {
    private String titulo;
    private Date data;
    private String autor;
    private String texto;

    public Manual(String titulo, Date data, String autor, String texto) {
        this.titulo = titulo;
        this.data = data;
        this.autor = autor;
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getData() {
        return data;
    }

    public String getAutor() {
        return autor;
    }

    public String getTexto() {
        return texto;
    }

    // Método de instância para exibir informações do manual
    public void exibirManual() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Data: " + this.data);
        System.out.println("Texto: " + this.texto);
    }
}