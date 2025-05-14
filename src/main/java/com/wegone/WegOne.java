package com.wegone;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Scanner;
import org.json.JSONObject;

public class WegOne {

    static JSONObject mensagensNoIdiomaEscolhido;

    public static String obterMensagem(String chave) {
        return mensagensNoIdiomaEscolhido.optString(chave, chave);
    } // usado para traduzir os valores do enum

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
                System.out.println(
                        "Idioma inválido / Invalid language / Idioma inválido / Ungültige Sprache / Langue invalide.");
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
        Manual.carregarIdioma(new JSONObject(conteudo));

        traduzir("welcome");

        Manual[] manuais = Manual.imprimirManuais();
        int totalManuais = manuais.length;

        while (true) {
            traduzir("chose-an-option");
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

                    TipoManual[] tipos = TipoManual.values();

                    traduzir("chose-the-type-of-manual");
                    traduzir("operational-conduct-manual");
                    traduzir("diagnostic-manual");
                    traduzir("maintenance-manual");
                    traduzir("operation-manual");
                    traduzir("security-manual");
                    System.out.print("> ");
                    int escolhaTipo = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaTipo < 1 || escolhaTipo > tipos.length) {
                        traduzir("invalid-option");
                    } else {
                        TipoManual tipoEscolhido = tipos[escolhaTipo - 1];

                        switch (escolhaTipo) {
                            case 1:
                                traduzir("manual-type-operational");
                                break;
                            case 2:
                                traduzir("manual-type-diagnostic");
                                break;
                            case 3:
                                traduzir("manual-type-maintenance");
                                break;
                            case 4:
                                traduzir("manual-type-operation");
                                break;
                            case 5:
                                traduzir("security-manual");
                                break;
                            default:
                                traduzir("manual-type-safety");
                                break;
                        }

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
                            traduzir("no-manual-found");
                        } else {

                            traduzir("digit-number");
                            System.out.print("> ");
                            int escolhaManual = scanner.nextInt();
                            scanner.nextLine();

                            if (escolhaManual < 1 || escolhaManual > count) {
                                traduzir("invalid-option");
                            } else {
                                Manual selecionado = manuais[indices[escolhaManual - 1]];
                                selecionado.imprimir();
                            }
                        }
                    }

                    break;

                case 3:

                    TipoManual[] tiposExcluir = TipoManual.values();

                    traduzir("chose-the-type-of-manual");
                    traduzir("operational-conduct-manual");
                    traduzir("diagnostic-manual");
                    traduzir("maintenance-manual");
                    traduzir("operation-manual");
                    traduzir("security-manual");
                    System.out.print("> ");
                    int tipoExcluirIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoExcluirIndex < 1 || tipoExcluirIndex > tiposExcluir.length) {
                        traduzir("invalid-option");
                    } else {
                        TipoManual tipoEscolhido = tiposExcluir[tipoExcluirIndex - 1];

                        int count = 0;
                        int[] indices = new int[totalManuais];

                        for (int i = 0; i < totalManuais; i++) {
                            Manual m = manuais[i];
                            if (m.getTipo() == tipoEscolhido) {
                                indices[count] = i;
                                System.out.printf("%d - %s%n", count + 1, m.getTitulo());
                                count++;
                            }
                        }

                        if (count == 0) {
                            traduzir("no-manual-found");
                        } else {
                            traduzir("chose-the-number-of-the-manual-to-delete");
                            System.out.print("> ");
                            int apagarManualIndex = scanner.nextInt();
                            scanner.nextLine();

                            if (apagarManualIndex < 1 || apagarManualIndex > count) {
                                traduzir("invalid-option");
                            } else {
                                int indiceReal = indices[apagarManualIndex - 1];
                                for (int i = indiceReal; i < totalManuais - 1; i++) {
                                    manuais[i] = manuais[i + 1];
                                }
                                manuais[totalManuais - 1] = null;
                                totalManuais--;
                                traduzir("manual-deleted-sucessfully");
                            }
                        }
                    }

                    break;
                case 4:

                    traduzir("chose-the-type-of-manual");
                    traduzir("operational-conduct-manual");
                    traduzir("diagnostic-manual");
                    traduzir("maintenance-manual");
                    traduzir("operation-manual");
                    traduzir("security-manual");
                    System.out.print("> ");

                    TipoManual[] tiposEdicao = TipoManual.values();

                    int tipoEscolhidoIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoEscolhidoIndex < 1 || tipoEscolhidoIndex > tiposEdicao.length) {
                        traduzir("invalid-option");
                    } else {
                        TipoManual tipoEscolhido = tiposEdicao[tipoEscolhidoIndex - 1];

                        int count = 0;
                        int[] indices = new int[totalManuais];

                        for (int i = 0; i < totalManuais; i++) {
                            Manual m = manuais[i];
                            if (m.getTipo() == tipoEscolhido) {
                                indices[count] = i;
                                System.out.printf("%d - %s%n", count + 1, m.getTitulo());
                                count++;
                            }
                        }

                        if (count == 0) {
                            traduzir("no-manual-found");
                        } else {
                            traduzir("chose-the-number-to-edit");
                            System.out.print("> ");
                            int editarOperacao = scanner.nextInt();
                            scanner.nextLine();

                            if (editarOperacao < 1 || editarOperacao > count) {
                                traduzir("invalid-option");
                            } else {
                                Manual manual = manuais[indices[editarOperacao - 1]];

                                traduzir("what-you-want-to-edit");
                                traduzir("manual-title");
                                traduzir("manual-author");
                                traduzir("manual-text");
                                traduzir("publication-date");
                                traduzir("manual-type");
                                System.out.print("> ");
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
                        }
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