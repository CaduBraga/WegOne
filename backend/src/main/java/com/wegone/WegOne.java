package com.wegone;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
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



        ManualDeManutencao[] manuaisManutencao = Manuais.imprimirManualDeManutencao();
        ManualDeOperacao[] manuaisOperacao = Manuais.imprimirManualDeOperacao();
        ManualDeSeguranca[] manuaisSeguranca = Manuais.imprimirManualDeSeguranca();
        ManualDeCondutaOperacional[] manuaisConduta = Manuais.imprimirManualDeCondutaOperacional();
        ManualDeDiagnostico[] manuaisDiagnostico = Manuais.imprimirManualDeDiagnostico();

        int totalManuaisManutencao = manuaisManutencao.length;
        int totalManuaisOperacao = manuaisOperacao.length;
        int totalManuaisSeguranca = manuaisSeguranca.length;
        int totalManuaisConduta = manuaisConduta.length;
        int totalManuaisDiagnostico = manuaisDiagnostico.length;

        while (true) {
            traduzir("chose-an-option");
            traduzir("insert-an-new-manual");
            traduzir("view-manuals");
            traduzir("delete-an-manual");
            traduzir("edit-an-existence-manual");
            traduzir("close-program");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1) {
                traduzir("chose-the-type-of-manual");
                traduzir("manutencion-manual");
                traduzir("operation-manual");
                traduzir("security-manual");
                traduzir("conduct-manual");
                traduzir("diagnostic-manual");

                int tipoManual = scanner.nextInt();
                scanner.nextLine();

                switch (tipoManual) {
                    case 1:
                        if (totalManuaisManutencao == manuaisManutencao.length) {
                            /*
                             * sempre que acabar o espaço do array ele vai criar um novo, duplicar o espaço
                             * e copiar os arquivos nele novamente
                             */
                            ManualDeManutencao[] novoArray = new ManualDeManutencao[manuaisManutencao.length * 2];
                            System.arraycopy(manuaisManutencao, 0, novoArray, 0, manuaisManutencao.length);
                            manuaisManutencao = novoArray;
                        }
                        ManualDeManutencao novoManual = new ManualDeManutencao("", new Date(), "", "");
                        novoManual.preencherDados();
                        manuaisManutencao[totalManuaisManutencao] = novoManual;
                        totalManuaisManutencao++;
                        traduzir("new-manual-sucessfully-inserted");
                        break;
                    case 2:
                        if (totalManuaisOperacao == manuaisOperacao.length) {
                            ManualDeOperacao[] novoArray = new ManualDeOperacao[manuaisOperacao.length * 2];
                            System.arraycopy(manuaisOperacao, 0, novoArray, 0, manuaisOperacao.length);
                            manuaisOperacao = novoArray;
                        }
                        ManualDeOperacao novoManualOperacao = new ManualDeOperacao("", new Date(), "", "");
                        novoManualOperacao.preencherDados();
                        manuaisOperacao[totalManuaisOperacao] = novoManualOperacao;
                        totalManuaisOperacao++;
                        traduzir("new-manual-sucessfully-inserted");
                        break;
                    case 3:
                        if (totalManuaisSeguranca == manuaisSeguranca.length) {
                            ManualDeSeguranca[] novoArray = new ManualDeSeguranca[manuaisSeguranca.length * 2];
                            System.arraycopy(manuaisSeguranca, 0, novoArray, 0, manuaisSeguranca.length);
                            manuaisSeguranca = novoArray;
                        }
                        ManualDeSeguranca novoManualSeguranca = new ManualDeSeguranca("", new Date(), "", "");
                        novoManualSeguranca.preencherDados();
                        manuaisSeguranca[totalManuaisSeguranca] = novoManualSeguranca;
                        totalManuaisSeguranca++;
                        traduzir("new-manual-sucessfully-inserted");
                        break;
                    case 4:
                        if (totalManuaisConduta == manuaisConduta.length) {
                            ManualDeCondutaOperacional[] novoArray = new ManualDeCondutaOperacional[manuaisConduta.length
                                    * 2];
                            System.arraycopy(manuaisConduta, 0, novoArray, 0, manuaisConduta.length);
                            manuaisConduta = novoArray;
                        }
                        ManualDeCondutaOperacional novoManualConduta = new ManualDeCondutaOperacional("", new Date(),
                                "", "");
                        novoManualConduta.preencherDados();
                        manuaisConduta[totalManuaisConduta] = novoManualConduta;
                        totalManuaisConduta++;
                        traduzir("new-manual-sucessfully-inserted");
                        break;
                    case 5:
                        if (totalManuaisDiagnostico == manuaisDiagnostico.length) {
                            ManualDeDiagnostico[] novoArray = new ManualDeDiagnostico[manuaisDiagnostico.length * 2];
                            System.arraycopy(manuaisDiagnostico, 0, novoArray, 0, manuaisDiagnostico.length);
                            manuaisDiagnostico = novoArray;
                        }
                        ManualDeDiagnostico novoManualDiagnostico = new ManualDeDiagnostico("", new Date(), "", "");
                        novoManualDiagnostico.preencherDados();
                        manuaisDiagnostico[totalManuaisDiagnostico] = novoManualDiagnostico;
                        totalManuaisDiagnostico++;
                        traduzir("new-manual-sucessfully-inserted");
                        break;
                    default:
                        traduzir("invalid-option");
                }

            } else if (escolha == 2) {
                traduzir("chose-the-type-of-manual-to-view");
                traduzir("manutencion-manual");
                traduzir("operation-manual");
                traduzir("security-manual");
                traduzir("conduct-manual");
                traduzir("diagnostic-manual");

                int tipoVisualizacao = scanner.nextInt();
                scanner.nextLine();

                switch (tipoVisualizacao) {
                    case 1:
                        traduzir("manutencion-manuals-existing");
                        for (int i = 0; i < totalManuaisManutencao; i++) {
                            System.out.println((i + 1) + " - " + manuaisManutencao[i].getTitulo());
                        }
                        break;
                    case 2:
                        traduzir("operation-manuals-existing");
                        for (int i = 0; i < totalManuaisOperacao; i++) {
                            System.out.println((i + 1) + " - " + manuaisOperacao[i].getTitulo());
                        }
                        break;
                    case 3:
                        traduzir("security-manuals-existing");
                        for (int i = 0; i < totalManuaisSeguranca; i++) {
                            System.out.println((i + 1) + " - " + manuaisSeguranca[i].getTitulo());
                        }
                        break;
                    case 4:
                        traduzir("operacional-conduct-existing");
                        for (int i = 0; i < totalManuaisConduta; i++) {
                            System.out.println((i + 1) + " - " + manuaisConduta[i].getTitulo());
                        }
                        break;
                    case 5:
                        traduzir("diagnostic-manuals-existing");
                        for (int i = 0; i < totalManuaisDiagnostico; i++) {
                            System.out.println((i + 1) + " - " + manuaisDiagnostico[i].getTitulo());
                        }
                        break;
                    default:
                        traduzir("invalid-option");
                        continue;
                }

                traduzir("select-a-manual-to-see-more-details");
                int escolhaManual = scanner.nextInt();
                scanner.nextLine();

                switch (tipoVisualizacao) {
                    case 1:
                        if (escolhaManual <= totalManuaisManutencao) {
                            manuaisManutencao[escolhaManual - 1].exibirManual(); 
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    case 2:
                        if (escolhaManual <= totalManuaisOperacao) {
                            manuaisOperacao[escolhaManual - 1].exibirManual();
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    case 3:
                        if (escolhaManual <= totalManuaisSeguranca) {
                            manuaisSeguranca[escolhaManual - 1].exibirManual();
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    case 4:
                        if (escolhaManual <= totalManuaisConduta) {
                            manuaisConduta[escolhaManual - 1].exibirManual();
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    case 5:
                        if (escolhaManual <= totalManuaisDiagnostico) {
                            manuaisDiagnostico[escolhaManual - 1].exibirManual(); 
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                }

            } else if (escolha == 3) {
                traduzir("chose-the-type-of-manual-to-delete");
                traduzir("manutencion-manual");
                traduzir("operation-manual");
                traduzir("security-manual");
                traduzir("conduct-manual");
                traduzir("diagnostic-manual");

                int tipoApagar = scanner.nextInt();
                scanner.nextLine();

                switch (tipoApagar) {
                    case 1:
                        traduzir("chose-the-number-of-the-manual-to-delete");
                        for (int i = 0; i < totalManuaisManutencao; i++) {
                            System.out.println((i + 1) + " - " + manuaisManutencao[i].getTitulo());
                        }
                        int apagarManutencao = scanner.nextInt();
                        scanner.nextLine();
                        if (apagarManutencao >= 1 && apagarManutencao <= totalManuaisManutencao) {
                            for (int i = apagarManutencao - 1; i < totalManuaisManutencao - 1; i++) {
                                manuaisManutencao[i] = manuaisManutencao[i + 1];
                            }
                            manuaisManutencao[totalManuaisManutencao - 1] = null;
                            totalManuaisManutencao--;
                            traduzir("manual-deletede-sucessefully");
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    case 2:
                        traduzir("chose-the-number-of-the-manual-to-delete");
                        for (int i = 0; i < totalManuaisOperacao; i++) {
                            System.out.println((i + 1) + " - " + manuaisOperacao[i].getTitulo());
                        }
                        int apagarOperacao = scanner.nextInt();
                        scanner.nextLine();
                        if (apagarOperacao >= 1 && apagarOperacao <= totalManuaisOperacao) {
                            for (int i = apagarOperacao - 1; i < totalManuaisOperacao - 1; i++) {
                                manuaisOperacao[i] = manuaisOperacao[i + 1];
                            }
                            manuaisOperacao[totalManuaisOperacao - 1] = null;
                            totalManuaisOperacao--;
                            traduzir("manual-deletede-sucessefully");
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    case 3:
                        traduzir("chose-the-number-of-the-manual-to-delete");
                        for (int i = 0; i < totalManuaisSeguranca; i++) {
                            System.out.println((i + 1) + " - " + manuaisSeguranca[i].getTitulo());
                        }
                        int apagarSeguranca = scanner.nextInt();
                        scanner.nextLine();
                        if (apagarSeguranca >= 1 && apagarSeguranca <= totalManuaisSeguranca) {
                            for (int i = apagarSeguranca - 1; i < totalManuaisSeguranca - 1; i++) {
                                manuaisSeguranca[i] = manuaisSeguranca[i + 1];
                            }
                            manuaisSeguranca[totalManuaisSeguranca - 1] = null;
                            totalManuaisSeguranca--;
                            traduzir("manual-deletede-sucessefully");
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    case 4:
                        traduzir("chose-the-number-of-the-manual-to-delete");
                        for (int i = 0; i < totalManuaisConduta; i++) {
                            System.out.println((i + 1) + " - " + manuaisConduta[i].getTitulo());
                        }
                        int apagarConduta = scanner.nextInt();
                        scanner.nextLine();
                        if (apagarConduta >= 1 && apagarConduta <= totalManuaisConduta) {
                            for (int i = apagarConduta - 1; i < totalManuaisConduta - 1; i++) {
                                manuaisConduta[i] = manuaisConduta[i + 1];
                            }
                            manuaisConduta[totalManuaisConduta - 1] = null;
                            totalManuaisConduta--;
                            traduzir("manual-deletede-sucessefully");
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    case 5:
                        traduzir("chose-the-number-of-the-manual-to-delete");
                        for (int i = 0; i < totalManuaisDiagnostico; i++) {
                            System.out.println((i + 1) + " - " + manuaisDiagnostico[i].getTitulo());
                        }
                        int apagarDiagnostico = scanner.nextInt();
                        scanner.nextLine();
                        if (apagarDiagnostico >= 1 && apagarDiagnostico <= totalManuaisDiagnostico) {
                            for (int i = apagarDiagnostico - 1; i < totalManuaisDiagnostico - 1; i++) {
                                manuaisDiagnostico[i] = manuaisDiagnostico[i + 1];
                            }
                            manuaisDiagnostico[totalManuaisDiagnostico - 1] = null;
                            totalManuaisDiagnostico--;
                            traduzir("manual-deletede-sucessefully");
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    default:
                        traduzir("invalid-option");
                }

            } else if (escolha == 4) {
                traduzir("chose-the-type-of-manual-to-edit");
                traduzir("manutencion-manual");
                traduzir("operation-manual");
                traduzir("security-manual");
                traduzir("conduct-manual");
                traduzir("diagnostic-manual");

                int tipoEditar = scanner.nextInt();
                scanner.nextLine();

                switch (tipoEditar) {
                    case 1:
                        traduzir("chose-the-type-of-manual-to-edit");
                        for (int i = 0; i < totalManuaisManutencao; i++) {
                            System.out.println((i + 1) + " - " + manuaisManutencao[i].getTitulo());
                        }
                        int editarManutencao = scanner.nextInt();
                        scanner.nextLine();
                        if (editarManutencao >= 1 && editarManutencao <= totalManuaisManutencao) {
                            ManualDeManutencao manual = manuaisManutencao[editarManutencao - 1];
                            traduzir("what-do-you-want-to-edit");
                            traduzir("manutencion-manual");
                            traduzir("operation-manual");
                            traduzir("security-manual");
                            traduzir("conduct-manual");
                            traduzir("diagnostic-manual");
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
                                    manual.editarDataPublicacao();
                                    break;
                                default:
                                    traduzir("invalid-option");
                            }
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    case 2:
                        traduzir("chose-the-number-to-edit");
                        for (int i = 0; i < totalManuaisOperacao; i++) {
                            System.out.println((i + 1) + " - " + manuaisOperacao[i].getTitulo());
                        }
                        int editarOperacao = scanner.nextInt();
                        scanner.nextLine();
                        if (editarOperacao >= 1 && editarOperacao <= totalManuaisOperacao) {
                            ManualDeOperacao manual = manuaisOperacao[editarOperacao - 1];
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
                                    manual.editarDataPublicacao();
                                    break;
                                default:
                                    traduzir("invalid-option");
                            }
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    case 3:
                        traduzir("chose-the-number-to-edit");
                        for (int i = 0; i < totalManuaisSeguranca; i++) {
                            System.out.println((i + 1) + " - " + manuaisSeguranca[i].getTitulo());
                        }
                        int editarSeguranca = scanner.nextInt();
                        scanner.nextLine();
                        if (editarSeguranca >= 1 && editarSeguranca <= totalManuaisSeguranca) {
                            ManualDeSeguranca manual = manuaisSeguranca[editarSeguranca - 1];
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
                                    manual.editarDataPublicacao();
                                    break;
                                default:
                                    traduzir("invalid-option");
                            }
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    case 4:
                        traduzir("chose-the-number-to-edit");
                        for (int i = 0; i < totalManuaisConduta; i++) {
                            System.out.println((i + 1) + " - " + manuaisConduta[i].getTitulo());
                        }
                        int editarConduta = scanner.nextInt();
                        scanner.nextLine();
                        if (editarConduta >= 1 && editarConduta <= totalManuaisConduta) {
                            ManualDeCondutaOperacional manual = manuaisConduta[editarConduta - 1];
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
                                    manual.editarDataPublicacao();
                                    break;
                                default:
                                    traduzir("invalid-option");
                            }
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    case 5:
                        traduzir("chose-the-number-to-edit");
                        for (int i = 0; i < totalManuaisDiagnostico; i++) {
                            System.out.println((i + 1) + " - " + manuaisDiagnostico[i].getTitulo());
                        }
                        int editarDiagnostico = scanner.nextInt();
                        scanner.nextLine();
                        if (editarDiagnostico >= 1 && editarDiagnostico <= totalManuaisDiagnostico) {
                            ManualDeDiagnostico manual = manuaisDiagnostico[editarDiagnostico - 1];
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
                                    manual.editarDataPublicacao();
                                    break;
                                default:
                                    traduzir("invalid-option");
                            }
                        } else {
                            traduzir("invalid-option");
                        }
                        break;
                    default:
                        traduzir("invalid-option");
                }

            } else if (escolha == 5) {
                traduzir("closing-the-program");
                break;
            } else {
                traduzir("invalid-optin-try-again");
            }

        }

        scanner.close();

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