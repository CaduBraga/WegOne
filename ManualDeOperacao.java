import java.util.Date;
import java.util.Scanner;

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

    public void preencherDados() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o título do manual:");
        this.titulo = scanner.nextLine();

        System.out.println("Digite o autor do manual:");
        this.autor = scanner.nextLine();

        System.out.println("Digite o texto do manual:");
        this.texto = scanner.nextLine();

        this.dataPublicacao = new Date();
    }

    public void editarTitulo() {
        Scanner scanner = new Scanner(System.in);
        String novoTitulo;
        
        do {
            System.out.println("Título atual: " + this.titulo);
            System.out.print("Digite o novo título: ");
            novoTitulo = scanner.nextLine();

            if (novoTitulo.equals("")) {
                System.out.println("O título não pode ser vazio. Tente novamente.");
            } else if (novoTitulo.equals(this.titulo)) {
                System.out.println("O título não pode ser igual ao título atual. Tente novamente.");
            }

        } while (novoTitulo.equals("") || novoTitulo.equals(this.titulo));

        this.titulo = novoTitulo;
        System.out.println("Título atualizado para: " + this.titulo);
    }

    public void editarAutor() {
        Scanner scanner = new Scanner(System.in);
        String novoAutor;

        do {
            System.out.println("Autor atual: " + this.autor);
            System.out.print("Digite o novo autor: ");
            novoAutor = scanner.nextLine();

            if (novoAutor.equals("")) {
                System.out.println("O autor não pode ser vazio. Tente novamente.");
            } else if (novoAutor.equals(this.autor)) {
                System.out.println("O autor não pode ser igual ao autor atual. Tente novamente.");
            }

        } while (novoAutor.equals("") || novoAutor.equals(this.autor));

        this.autor = novoAutor;
        System.out.println("Autor atualizado para: " + this.autor);
    }

    public void editarTexto() {
        Scanner scanner = new Scanner(System.in);
        String novoTexto;

        do {
            System.out.println("Texto atual: " + this.texto);
            System.out.print("Digite o novo texto: ");
            novoTexto = scanner.nextLine();

            if (novoTexto.equals("")) {
                System.out.println("O texto não pode ser vazio. Tente novamente.");
            } else if (novoTexto.equals(this.texto)) {
                System.out.println("O texto não pode ser igual ao texto atual. Tente novamente.");
            }

        } while (novoTexto.equals("") || novoTexto.equals(this.texto));

        this.texto = novoTexto;
        System.out.println("Texto atualizado.");
    }

    public void editarDataPublicacao() {
        Date novaData = new Date();

        if (novaData.equals(this.dataPublicacao)) {
            System.out.println("A nova data não pode ser igual à atual.");
        } else {
            this.dataPublicacao = novaData;
            System.out.println("Data de publicação atualizada para: " + this.dataPublicacao);
        }
    }
}