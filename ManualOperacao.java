import java.util.Date;

public class ManualDeOperacao {
    private String titulo;
    private Date dataPublicacao;
    private String autor;
    private String texto;

    public ManualDeOperacao(String titulo, Date dataPublicacao, String autor, String texto) {
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void exibirManual() {
        System.out.println("=== MANUAL DE OPERAÇÃO ===");
        System.out.println("Título: " + titulo);
        System.out.println("Data de Publicação: " + dataPublicacao);
        System.out.println("Autor: " + autor);
        System.out.println("Texto: " + texto);
    }
}
