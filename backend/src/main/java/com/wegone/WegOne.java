package com.wegone;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
        }

        String conteudo = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        mensagensNoIdiomaEscolhido = new JSONObject(conteudo).getJSONObject("Messages");

        traduzir("welcome");

        Manual[] manuais = Manual.imprimirManuais();

        int totalManuais = manuais.length;

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

                    if (totalManuais == manuais.length) {
                        /*
                         * sempre que acabar o espaço do array ele vai criar um novo, duplicar o espaço
                         * e copiar os arquivos nele novamente
                         */
                        Manual[] novoArray = new Manual[manuais.length * 2];
                        System.arraycopy(manuais, 0, novoArray, 0, manuais.length);
                        manuais = novoArray;
                    }
                    Manual novoManual = new Manual("", new Date(), "", "", null); // cria um objeto vazio
                    novoManual.cadastrar();
                    manuais[totalManuais++] = novoManual;

                    break;

                case 2:
                    
                    traduzir("chose-the-type-of-manual");
                    TipoManual[] tipos = TipoManual.values();
                    for (int i = 0; i < tipos.length; i++) {
                        System.out.printf("%d - %s%n", i + 1, tipos[i].getDescricao());
                    }
                    System.out.print("> ");
                    int escolhaTipo = scanner.nextInt();
                    scanner.nextLine();


                    if (escolhaTipo < 1 || escolhaTipo > tipos.length) {
                        traduzir("invalid-option");
                    } else {
                        TipoManual tipoEscolhido = tipos[escolhaTipo - 1];

                        System.out.println("Manuais de “" + tipoEscolhido.getDescricao() + "”:");
                        int count = 0;
                        int[] indices = new int[totalManuais]; 

                        for (int i = 0; i < totalManuais; i++) {
                            Manual m = manuais[i];
                            if (m.getTipo() == tipoEscolhido) {
                                count++;
                                indices[count - 1] = i;
                                System.out.printf("%d - %s%n", count, m.getTitulo());
                            }
                        }

                        if (count == 0) {
                            System.out.println("Nenhum manual encontrado.");
                        } else {
                            
                            System.out.print("Digite o número do manual para ver detalhes: ");
                            int escolhaManual = scanner.nextInt();
                            scanner.nextLine();

                            if (escolhaManual < 1 || escolhaManual > count) {
                                traduzir("invalid-option");
                            } else {
                                Manual selecionado = manuais[indices[escolhaManual - 1]];
                                System.out.println("\n—— Detalhes do Manual ——");
                                selecionado.imprimir();
                            }
                        }
                    }

                    break;
                case 3:

                    traduzir("chose-the-number-of-the-manual-to-delete");
                    for (int i = 0; i < totalManuais; i++) {
                        System.out.println((i + 1) + " - " + manuais[i].getTitulo());
                    }
                    int apagarManutencao = scanner.nextInt();
                    scanner.nextLine();
                    if (apagarManutencao >= 1 && apagarManutencao <= totalManuais) {
                        for (int i = apagarManutencao - 1; i < totalManuais - 1; i++) {
                            manuais[i] = manuais[i + 1];
                        }
                        manuais[totalManuais - 1] = null;
                        totalManuais--;
                        traduzir("manual-deletede-sucessefully");
                    }

                    break;

                case 4:

                    traduzir("chose-the-number-to-edit");
                    for (int i = 0; i < totalManuais; i++) {
                        System.out.println((i + 1) + " - " + manuais[i].getTitulo());
                    }
                    int editarOperacao = scanner.nextInt();
                    scanner.nextLine();
                    if (editarOperacao >= 1 && editarOperacao <= totalManuais) {
                        Manual manual = manuais[editarOperacao - 1];
                        traduzir("what-you-want-to-edit");
                        traduzir("title");
                        traduzir("author");
                        traduzir("text");
                        traduzir("date-of-publication");
                        int opcaoEdicao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoEdicao) {
                            case 1:
                                manual.editarTitulo();
                                break;
                            case 2:
                                manual.editarAutor();
                                break;
                            case 3:
                                manual.editarTexto();
                                break;
                            case 4:
                                manual.editarData();
                                break;
                            case 5:
                                manual.editarTipo();
                                break;

                            default:
                                traduzir("invalid-option");
                        }
                    }
                    break;
                case 5:
                    traduzir("closing-the-program");

                    break;
                default:
                    traduzir("invalid-optin-try-again");
                    break;
            }

        }
    }

    private static String obterMensagemTraduzida(String chaveParaTraduzir) {
        String mensagem = chaveParaTraduzir;
        try {
            mensagem = mensagensNoIdiomaEscolhido.getString(chaveParaTraduzir);
        } catch (Exception e) {
            mensagem = chaveParaTraduzir;
        }
        return mensagem;
    }

    private static void traduzir(String chaveParaTraduzir) {
        System.out.println(obterMensagemTraduzida(chaveParaTraduzir));

    }

}