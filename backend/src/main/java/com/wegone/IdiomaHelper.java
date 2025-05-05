package com.wegone;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.JSONObject;

public class IdiomaHelper {

    private static JSONObject mensagensNoIdiomaEscolhido;

    public static String escolherIdioma(Scanner scanner) {
        System.out.println(
                "Escolha um idioma para tradução / Choose a language / Elija un idioma / Sprache wählen / Choisissez une langue :");
        System.out.println("1. Português");
        System.out.println("2. English");
        System.out.println("3. Español");
        System.out.println("4. Deutsch");
        System.out.println("5. Français");

        System.out.print("Digite o número / Enter number / Ingrese número / Nummer eingeben / Entrez le numéro: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                return "pt";
            case 2:
                return "en";
            case 3:
                return "es";
            case 4:
                return "de";
            case 5:
                return "fr";
            default:
                System.out.println(
                        "Idioma inválido / Invalid language / Idioma inválido / Ungültige Sprache / Langue invalide.");
                return null;
        }
    }

    public static void carregarIdioma(String codigoIdioma) throws IOException {
        InputStream inputStream = IdiomaHelper.class.getClassLoader()
                .getResourceAsStream("translate/" + codigoIdioma + ".json");

        if (inputStream == null) {
            System.out.println("Arquivo não encontrado: translate/" + codigoIdioma + ".json");
            return;
        }

        String conteudo = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        JSONObject root = new JSONObject(conteudo);
        mensagensNoIdiomaEscolhido = root.getJSONObject("Messages");
    }

    public static int exibirMenuInicial(String userRole, Scanner scanner) {
        traduzir("choose-an-option");

        if (!userRole.equals("viewer")) {
            traduzir("insert-a-new-manual");
        }

        traduzir("view-manuals");

        if (userRole.equals("adm")) {
            traduzir("delete-a-manual");
        }

        if (!userRole.equals("viewer")) {
            traduzir("edit-an-existing-manual");
        }

        traduzir("close-program");
        System.out.print("> ");

        int escolha = scanner.nextInt();
        scanner.nextLine();
        return escolha;
    }

    public static void traduzir(String chave) {
        if (mensagensNoIdiomaEscolhido != null) {
            String mensagem = mensagensNoIdiomaEscolhido.optString(chave, chave);
            System.out.println(mensagem);
        } else {
            System.out.println("Idioma ainda não carregado.");
        }
    }

}
