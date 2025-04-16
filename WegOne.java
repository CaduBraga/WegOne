
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WegOne {
    public static void main(String[] args) {
        // Mapa de mensagens traduzidas
    	
        Map<String, String> mensagens = new HashMap<>();
        mensagens.put("pt", "Bem-vindo ao WegOne");
        mensagens.put("en", "Welcome to WegOne");
        mensagens.put("de", "Willkommen bei WegOne");

        // Mapa de opções do menu traduzidas
        Map<String, String[]> opcoesMenu = new HashMap<>();
        opcoesMenu.put("pt", new String[]{"Cadastrar Orientação", "Pesquisar Orientação", "Editar Orientação", "Excluir Orientação", "Sair"});
        opcoesMenu.put("en", new String[]{"Register Guidance", "Search Guidance", "Edit Guidance", "Delete Guidance", "Exit"});
        opcoesMenu.put("de", new String[]{"Orientierung Registrieren", "Orientierung Suchen", "Orientierung Bearbeiten", "Orientierung Löschen", "Verlassen"});

        // Mapa de mensagens para escolha
        Map<String, String> mensagemEscolha = new HashMap<>();
        mensagemEscolha.put("pt", "Digite sua escolha: ");
        mensagemEscolha.put("en", "Enter your choice: ");
        mensagemEscolha.put("de", "Geben Sie Ihre Wahl ein: ");
        
        

        // Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Exibir opções de idiomas
        System.out.println("Escolha um idioma para tradução:");
        System.out.println("1. Português");
        System.out.println("2. Inglês");
        System.out.println("3. Alemão");
        System.out.print("Digite o número do idioma: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        String codigoIdioma = "";
        switch (escolha) {
            case 1:
                codigoIdioma = "pt";
                break;
            case 2:
                codigoIdioma = "en";
                break;
            case 3:
                codigoIdioma = "de";
                break;
            default:
                System.out.println("Idioma inválido.");
                return;
        }

        // Exibir mensagem de boas-vindas no idioma escolhido
        System.out.println(mensagens.get(codigoIdioma));

        // Exibir menu de opções no idioma escolhido
        for (int i = 0; i < opcoesMenu.get(codigoIdioma).length; i++) {
            System.out.println((i + 1) + ". " + opcoesMenu.get(codigoIdioma)[i]);
        }

        // Exibir mensagem para o usuário digitar a escolha
        System.out.print(mensagemEscolha.get(codigoIdioma));
        int opcao = scanner.nextInt();
        
        // Lógica para processar a escolha do usuário
        // Aqui você pode adicionar a lógica para cada opção do menu

        // Fechar o scanner
        scanner.close();
    }
}