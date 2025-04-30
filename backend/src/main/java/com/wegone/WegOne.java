package com.wegone;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import org.json.JSONObject;

public class WegOne {

    static JSONObject mensagensNoIdiomaEscolhido;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um idioma para tradução:");
        System.out.println("1. Português");
        System.out.println("2. English");
        System.out.println("3. Español");
        System.out.println("4. Deutch");

        System.out.print("Digite o número do idioma: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        String codigoIdioma = "";
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
        mensagensNoIdiomaEscolhido = new JSONObject(conteudo).getJSONObject("Messages");

        traduzir("welcome");

        while (true) {

            traduzir("chose-an-option");
            traduzir("insert-an-new-manual");
            traduzir("view-manuals");
            traduzir("delete-an-manual");
            traduzir("edit-an-existence-manual");
            traduzir("close-program");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    Manual novoManual = new Manual();
                    novoManual.cadastrar();

                    break;

                case 2:
                    Manual[] todos = Manual.buscarManuaisDoBanco();
                    if (todos.length == 0) {
                        System.out.println("Nenhum manual cadastrado.");
                    } else {
                        System.out.println("Manuais cadastrados:");
                        for (int i = 0; i < todos.length; i++) {
                            System.out.printf("%d - %s%n", i + 1, todos[i].getTitulo());
                        }
                        System.out.print("Escolha um manual para detalhes (0 para sair): ");
                        int idx = scanner.nextInt();
                        scanner.nextLine();
                        if (idx >= 1 && idx <= todos.length) {
                            todos[idx - 1].imprimir();
                        }
                    }
                    break;

                case 3:

                    traduzir("chose-the-type-of-manual-to-delete");
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
                            .filter(m -> m.getTipo() == tipoParaDel)
                            .toArray(Manual[]::new);

                    if (filtradosDel.length == 0) {
                        traduzir("no-manual-found-of-this-type");
                        break;
                    }

                    traduzir("manuals-available-to-delete");
                    for (int i = 0; i < filtradosDel.length; i++) {
                        System.out.printf("%d) %s%n", i + 1, filtradosDel[i].getTitulo());
                    }
                    traduzir("chose-the-number-of-the-manual-to-delete");
                    int del = scanner.nextInt();
                    scanner.nextLine();
                    if (del < 1 || del > filtradosDel.length) {
                        traduzir("invalid-option");
                        break;
                    }
                    Manual.excluirPorId(filtradosDel[del - 1].getIdManual());
                    traduzir("manual-deleted-succesfully");
                    break;

                case 4:
                    traduzir("chose-the-type-of-manual");
                    TipoManual[] tiposEd = TipoManual.values();
                    for (int i = 0; i < tiposEd.length; i++) {
                        System.out.printf("%d) %s%n", i + 1, tiposEd[i].getDescricao());
                    }
                    System.out.print("> ");
                    int tipoIdxEd = scanner.nextInt();
                    scanner.nextLine();
                    if (tipoIdxEd < 1 || tipoIdxEd > tiposEd.length) {
                        traduzir("invalid-option");
                        break;
                    }
                    TipoManual tipoParaEd = tiposEd[tipoIdxEd - 1];

                    Manual[] todosParaEd = Manual.buscarManuaisDoBanco();
                    Manual[] filtradosEd = Arrays.stream(todosParaEd)
                            .filter(m -> m.getTipo() == tipoParaEd)
                            .toArray(Manual[]::new);

                    if (filtradosEd.length == 0) {
                        traduzir("no-manual-found-of-this-type");
                        break;
                    }

                    System.out.println("Manuais de “" + tipoParaEd.getDescricao() + "”:");
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
                    traduzir("title");
                    traduzir("author");
                    traduzir("text");
                    traduzir("date-of-publication");
                    traduzir("type");
                    int field = scanner.nextInt();
                    scanner.nextLine();
                    switch (field) {
                        case 1:
                            System.out.print("> ");
                            Manual.atualizarTitulo(idEd, scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("> ");
                            Manual.atualizarAutor(idEd, scanner.nextLine());
                            break;
                        case 3:
                            System.out.print("> ");
                            Manual.atualizarTexto(idEd, scanner.nextLine());
                            break;
                        case 4:
                            System.out.print("> ");
                            Manual.atualizarData(idEd, java.sql.Date.valueOf(scanner.nextLine()));
                            break;
                        case 5:
                            traduzir("chose-the-type-of-manual");
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
                    traduzir("manual-updated-successfully");
                    break;

                case 5:
                    traduzir("program-closed");
                    System.out.println("Programa encerrado.");
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private static void traduzir(String chave) {
        String mensagem = mensagensNoIdiomaEscolhido.optString(chave, chave);
        System.out.println(mensagem);
    }
}