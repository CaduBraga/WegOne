package com.wegone;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import org.json.JSONObject;

public class WegOne {

    private static JSONObject mensagensNoIdiomaEscolhido;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

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

        String codigoIdioma;
        switch (opcao) {
            case 1:
                codigoIdioma = "pt";
                break;
            case 2:
                codigoIdioma = "en";
                break;
            case 3:
                codigoIdioma = "es";
                break;
            case 4:
                codigoIdioma = "de";
                break;
            case 5:
                codigoIdioma = "fr";
                break;
            default:
                System.out.println("Idioma inválido.");
                return;
        }

        InputStream inputStream = WegOne.class.getClassLoader()
                .getResourceAsStream("translate/" + codigoIdioma + ".json");

        if (inputStream == null) {
            System.out.println("Arquivo não encontrado: translate/" + codigoIdioma + ".json");
            return;
        }

        String conteudo = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        JSONObject root = new JSONObject(conteudo);
        mensagensNoIdiomaEscolhido = root.getJSONObject("Messages");
        Manual.carregarIdioma(root);

        traduzir("welcome");

        while (true) {
            traduzir("choose-an-option");
            traduzir("insert-a-new-manual");
            traduzir("view-manuals");
            traduzir("delete-a-manual");
            traduzir("edit-an-existing-manual");
            traduzir("close-program");
            System.out.print("> ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    Manual novoManual = new Manual();
                    novoManual.cadastrar();
                    break;

                case 2:
                    traduzir("select-the-type-of-the-manual");
                    traduzir("operational-conduct-manual");
                    traduzir("diagnostic-manual");
                    traduzir("manutance-manual");
                    traduzir("operation-manual");
                    traduzir("security-manual");
                    System.out.print("> ");
                    TipoManual[] tiposView = TipoManual.values();
                    int tipoIdxView = scanner.nextInt();
                    scanner.nextLine();
                    if (tipoIdxView < 1 || tipoIdxView > tiposView.length) {
                        traduzir("invalid-option");
                        break;
                    }
                    TipoManual tipoParaView = tiposView[tipoIdxView - 1];

                    Manual[] todosParaView = Manual.buscarManuaisDoBanco();
                    Manual[] filtradosView = Arrays.stream(todosParaView)
                            .filter(m -> m != null && m.getTipo() == tipoParaView)
                            .toArray(Manual[]::new);

                    if (filtradosView.length == 0) {
                        traduzir("no-manual-found-of--type");
                    } else {
                        traduzir("registred-manuals");
                        for (int i = 0; i < filtradosView.length; i++) {
                            System.out.printf("%d - %s%n", i + 1, filtradosView[i].getTitulo());
                        }
                        traduzir("select-a-manual-to-see-more-details");
                        System.out.print("> ");
                        int idx = scanner.nextInt();
                        scanner.nextLine();
                        if (idx >= 1 && idx <= filtradosView.length) {
                            filtradosView[idx - 1].imprimir();
                        } else {
                            traduzir("invalid-option");
                        }
                    }
                    break;

                case 3:
                    traduzir("choose-the-type-of-manual-to-delete");
                    TipoManual[] tiposDel = TipoManual.values();
                    for (int i = 0; i < tiposDel.length; i++) {
                        System.out.printf("%d) %s%n", i + 1, tiposDel[i].getDescricao());
                    }
                    System.out.print("> ");
                    int tipoIdxDel = scanner.nextInt();
                    scanner.nextLine();
                    if (tipoIdxDel < 1 || tipoIdxDel > tiposDel.length) {
                        traduzir("invalid-option");
                        break;
                    }
                    TipoManual tipoParaDel = tiposDel[tipoIdxDel - 1];

                    Manual[] todosParaDel = Manual.buscarManuaisDoBanco();
                    Manual[] filtradosDel = Arrays.stream(todosParaDel)
                            .filter(m -> m != null && m.getTipo() == tipoParaDel)
                            .toArray(Manual[]::new);

                    if (filtradosDel.length == 0) {
                        traduzir("no-manual-found-of--type");
                        break;
                    }

                    traduzir("manuals-available-to-delete");
                    for (int i = 0; i < filtradosDel.length; i++) {
                        System.out.printf("%d) %s%n", i + 1, filtradosDel[i].getTitulo());
                    }
                    traduzir("choose-the-number-of-the-manual-to-delete");
                    System.out.print("> ");
                    int del = scanner.nextInt();
                    scanner.nextLine();
                    if (del < 1 || del > filtradosDel.length) {
                        traduzir("invalid-option");
                        break;
                    }
                    int idExcluido = filtradosDel[del - 1].getIdManual();
                    Manual.excluirPorId(idExcluido);
                    traduzir("manual-deleted-successfully");
                    System.out.println("ID: " + idExcluido);
                    break;

                case 4:

                    traduzir("select-the-type-of-the-manual");
                    traduzir("operational-conduct-manual");
                    traduzir("diagnostic-manual");
                    traduzir("manutance-manual");
                    traduzir("operation-manual");
                    traduzir("security-manual");
                    System.out.print("> ");

                    TipoManual[] tiposEd = TipoManual.values();
                    int tipoIdxEd = scanner.nextInt();
                    scanner.nextLine();
                    if (tipoIdxEd < 1 || tipoIdxEd > tiposEd.length) {
                        traduzir("invalid-option");
                        break;
                    }
                    TipoManual tipoParaEd = tiposEd[tipoIdxEd - 1];

                    Manual[] todosParaEd = Manual.buscarManuaisDoBanco();
                    Manual[] filtradosEd = Arrays.stream(todosParaEd)
                            .filter(m -> m != null && m.getTipo() == tipoParaEd)
                            .toArray(Manual[]::new);

                    if (filtradosEd.length == 0) {
                        traduzir("no-manual-found-of--type");
                        break;
                    }

                    System.out.println(tipoParaEd.getDescricao());

                    for (int i = 0; i < filtradosEd.length; i++) {
                        System.out.printf("%d) %s%n", i + 1, filtradosEd[i].getTitulo());
                    }
                    System.out.print("> ");
                    int ed = scanner.nextInt();
                    scanner.nextLine();
                    if (ed < 1 || ed > filtradosEd.length) {
                        traduzir("invalid-option");
                        break;
                    }
                    int idEd = filtradosEd[ed - 1].getIdManual();

                    traduzir("what-you-want-to-edit");
                    traduzir("1-title");
                    traduzir("2-author");
                    traduzir("3-text");
                    traduzir("4-date-of-publication");
                    traduzir("5-type");
                    System.out.print("> ");
                    int field = scanner.nextInt();
                    scanner.nextLine();
                    switch (field) {
                        case 1:
                            traduzir("digit-new-title");
                            System.out.print("> ");
                            Manual.atualizarTitulo(idEd, scanner.nextLine());
                            break;
                        case 2:
                            traduzir("digit-new-author");
                            System.out.print("> ");
                            Manual.atualizarAutor(idEd, scanner.nextLine());
                            break;
                        case 3:
                            traduzir("digit-new-text");
                            System.out.print("> ");
                            Manual.atualizarTexto(idEd, scanner.nextLine());
                            break;
                        case 4:
                            Manual.atualizarData(idEd, java.sql.Date.valueOf(scanner.nextLine()));
                            break;
                        case 5:
                            traduzir("select-the-type-of-the-manual");
                            for (int i = 0; i < tiposEd.length; i++) {
                                System.out.printf("%d) %s%n", i + 1, tiposEd[i].getDescricao());
                            }
                            System.out.print("> ");
                            int nt = scanner.nextInt();
                            scanner.nextLine();
                            if (nt >= 1 && nt <= tiposEd.length) {
                                Manual.atualizarTipo(idEd, tiposEd[nt - 1]);
                            }
                            break;
                        default:
                            traduzir("invalid-option");
                    }
                    break;

                case 5:

                    traduzir("program-closing");
                    try {
                        // Delay para dar mais "veracidade" pro código, com essa firulinha de atraso
                        Thread.sleep(1500); // 1,5 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace(); // Em caso de interrupção da thread, exibe o erro
                    }

                    traduzir("program-closed");
                    return;

                default:
                    traduzir("invalid-option-try-again");
            }
        }
    }

    private static void traduzir(String chave) {
        String mensagem = mensagensNoIdiomaEscolhido.optString(chave, chave);
        System.out.println(mensagem);
    }
}