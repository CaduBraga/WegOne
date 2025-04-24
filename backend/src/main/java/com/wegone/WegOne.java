package backend.src.main.java.com.wegone;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Date;

public class WegOne {
    public static void main(String[] args) {

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

        Scanner scanner = new Scanner(System.in);

        // Começo
        System.out.println("Escolha um idioma para tradução:");
        System.out.println("1. Português");
        System.out.println("2. Inglês");
        System.out.println("3. Espanhol");
        System.out.println("4. Alemão");
        System.out.print("Digite o número do idioma: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        // Salva o código do idioma selecionad
        
        System.out.println("Idioma inválido.");

        // Mostrar "bem vindo"
        System.out.println(mensagens.get(codigoIdioma));

        while (true) { // loop infinito

            // Cadastrar etc
            String[] opcoes = opcoesMenu.get(codigoIdioma);
            for (int i = 0; i < opcoes.length; i++) {
                System.out.println((i + 1) + ". " + opcoes[i]);
            }

            // "Digite sua escolha"
            System.out.print(mensagemEscolha.get(codigoIdioma));
            int codigo = scanner.nextInt();
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1) {


                System.out.println("Escolha o tipo de manual:");
                System.out.println("1 - Manual de Manutenção");
                System.out.println("2 - Manual de Operação");
                System.out.println("3 - Manual de Segurança");
                System.out.println("4 - Manual de Conduta Operacional");
                System.out.println("5 - Manual de Diagnóstico");

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
                        System.out.println(getTransaltion("new-manual-success-message"));
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
                        System.out.println("Novo manual inserido com sucesso!");
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
                        System.out.println("Novo manual inserido com sucesso!");
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
                        System.out.println("Novo manual inserido com sucesso!");
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
                        System.out.println("Novo manual inserido com sucesso!");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }

            } else if (escolha == 2) {
                System.out.println("Escolha o tipo de manual para visualizar:");
                System.out.println("1 - Manuais de Manutenção");
                System.out.println("2 - Manuais de Operação");
                System.out.println("3 - Manuais de Segurança");
                System.out.println("4 - Manuais de Conduta Operacional");
                System.out.println("5 - Manuais de Diagnóstico");

                int tipoVisualizacao = scanner.nextInt();
                scanner.nextLine();

                switch (tipoVisualizacao) {
                    case 1:
                        System.out.println("Manuais de Manutenção existentes:");
                        for (int i = 0; i < totalManuaisManutencao; i++) {
                            System.out.println((i + 1) + " - " + manuaisManutencao[i].getTitulo());
                        }
                        break;
                    case 2:
                        System.out.println("Manuais de Operação existentes:");
                        for (int i = 0; i < totalManuaisOperacao; i++) {
                            System.out.println((i + 1) + " - " + manuaisOperacao[i].getTitulo());
                        }
                        break;
                    case 3:
                        System.out.println("Manuais de Segurança existentes:");
                        for (int i = 0; i < totalManuaisSeguranca; i++) {
                            System.out.println((i + 1) + " - " + manuaisSeguranca[i].getTitulo());
                        }
                        break;
                    case 4:
                        System.out.println("Manuais de Conduta Operacional existentes:");
                        for (int i = 0; i < totalManuaisConduta; i++) {
                            System.out.println((i + 1) + " - " + manuaisConduta[i].getTitulo());
                        }
                        break;
                    case 5:
                        System.out.println("Manuais de Diagnóstico existentes:");
                        for (int i = 0; i < totalManuaisDiagnostico; i++) {
                            System.out.println((i + 1) + " - " + manuaisDiagnostico[i].getTitulo());
                        }
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        continue; // Volta para o início do loop (contrário do break)
                }

                System.out.println("Selecione um manual para ver mais detalhes:");
                int escolhaManual = scanner.nextInt();
                scanner.nextLine();

                switch (tipoVisualizacao) {
                    case 1:
                        if (escolhaManual <= totalManuaisManutencao) {
                            manuaisManutencao[escolhaManual - 1].exibirManual(); // Chama o método de instância
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 2:
                        if (escolhaManual <= totalManuaisOperacao) {
                            manuaisOperacao[escolhaManual - 1].exibirManual(); // Chama o método de instância
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 3:
                        if (escolhaManual <= totalManuaisSeguranca) {
                            manuaisSeguranca[escolhaManual - 1].exibirManual(); // Chama o método de instância
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 4:
                        if (escolhaManual <= totalManuaisConduta) {
                            manuaisConduta[escolhaManual - 1].exibirManual(); // Chama o método de instância
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 5:
                        if (escolhaManual <= totalManuaisDiagnostico) {
                            manuaisDiagnostico[escolhaManual - 1].exibirManual(); // Chama o método de instância
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                }

            } else if (escolha == 3) {
                System.out.println("Escolha o tipo de manual que deseja apagar:");
                System.out.println("1 - Manuais de Manutenção");
                System.out.println("2 - Manuais de Operação");
                System.out.println("3 - Manuais de Segurança");
                System.out.println("4 - Manuais de Conduta Operacional");
                System.out.println("5 - Manuais de Diagnóstico");

                int tipoApagar = scanner.nextInt();
                scanner.nextLine();

                switch (tipoApagar) {
                    case 1:
                        System.out.println("Escolha o número do manual que deseja apagar:");
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
                            System.out.println("Manual apagado com sucesso!");
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 2:
                        System.out.println("Escolha o número do manual que deseja apagar:");
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
                            System.out.println("Manual apagado com sucesso!");
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 3:
                        System.out.println("Escolha o número do manual que deseja apagar:");
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
                            System.out.println("Manual apagado com sucesso!");
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 4:
                        System.out.println("Escolha o número do manual que deseja apagar:");
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
                            System.out.println("Manual apagado com sucesso!");
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 5:
                        System.out.println("Escolha o número do manual que deseja apagar:");
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
                            System.out.println("Manual apagado com sucesso!");
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }

            } else if (escolha == 4) {
                System.out.println("Escolha o tipo de manual que deseja editar:");
                System.out.println("1 - Manuais de Manutenção");
                System.out.println("2 - Manuais de Operação");
                System.out.println("3 - Manuais de Segurança");
                System.out.println("4 - Manuais de Conduta Operacional");
                System.out.println("5 - Manuais de Diagnóstico");

                int tipoEditar = scanner.nextInt();
                scanner.nextLine();

                switch (tipoEditar) {
                    case 1:
                        System.out.println("Escolha o número do manual que deseja editar:");
                        for (int i = 0; i < totalManuaisManutencao; i++) {
                            System.out.println((i + 1) + " - " + manuaisManutencao[i].getTitulo());
                        }
                        int editarManutencao = scanner.nextInt();
                        scanner.nextLine();
                        if (editarManutencao >= 1 && editarManutencao <= totalManuaisManutencao) {
                            ManualDeManutencao manual = manuaisManutencao[editarManutencao - 1];
                            System.out.println("O que deseja editar?");
                            System.out.println("1 - Título");
                            System.out.println("2 - Autor");
                            System.out.println("3 - Texto");
                            System.out.println("4 - Data de Publicação");
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
                                    System.out.println("Opção inválida.");
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 2:
                        System.out.println("Escolha o número do manual que deseja editar:");
                        for (int i = 0; i < totalManuaisOperacao; i++) {
                            System.out.println((i + 1) + " - " + manuaisOperacao[i].getTitulo());
                        }
                        int editarOperacao = scanner.nextInt();
                        scanner.nextLine();
                        if (editarOperacao >= 1 && editarOperacao <= totalManuaisOperacao) {
                            ManualDeOperacao manual = manuaisOperacao[editarOperacao - 1];
                            System.out.println("O que deseja editar?");
                            System.out.println("1 - Título");
                            System.out.println("2 - Autor");
                            System.out.println("3 - Texto");
                            System.out.println("4 - Data de Publicação");
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
                                    System.out.println("Opção inválida.");
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 3:
                        System.out.println("Escolha o número do manual que deseja editar:");
                        for (int i = 0; i < totalManuaisSeguranca; i++) {
                            System.out.println((i + 1) + " - " + manuaisSeguranca[i].getTitulo());
                        }
                        int editarSeguranca = scanner.nextInt();
                        scanner.nextLine();
                        if (editarSeguranca >= 1 && editarSeguranca <= totalManuaisSeguranca) {
                            ManualDeSeguranca manual = manuaisSeguranca[editarSeguranca - 1];
                            System.out.println("O que deseja editar?");
                            System.out.println("1 - Título");
                            System.out.println("2 - Autor");
                            System.out.println("3 - Texto");
                            System.out.println("4 - Data de Publicação");
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
                                    System.out.println("Opção inválida.");
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 4:
                        System.out.println("Escolha o número do manual que deseja editar:");
                        for (int i = 0; i < totalManuaisConduta; i++) {
                            System.out.println((i + 1) + " - " + manuaisConduta[i].getTitulo());
                        }
                        int editarConduta = scanner.nextInt();
                        scanner.nextLine();
                        if (editarConduta >= 1 && editarConduta <= totalManuaisConduta) {
                            ManualDeCondutaOperacional manual = manuaisConduta[editarConduta - 1];
                            System.out.println("O que deseja editar?");
                            System.out.println("1 - Título");
                            System.out.println("2 - Autor");
                            System.out.println("3 - Texto");
                            System.out.println("4 - Data de Publicação");
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
                                    System.out.println("Opção inválida.");
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 5:
                        System.out.println("Escolha o número do manual que deseja editar:");
                        for (int i = 0; i < totalManuaisDiagnostico; i++) {
                            System.out.println((i + 1) + " - " + manuaisDiagnostico[i].getTitulo());
                        }
                        int editarDiagnostico = scanner.nextInt();
                        scanner.nextLine();
                        if (editarDiagnostico >= 1 && editarDiagnostico <= totalManuaisDiagnostico) {
                            ManualDeDiagnostico manual = manuaisDiagnostico[editarDiagnostico - 1];
                            System.out.println("O que deseja editar?");
                            System.out.println("1 - Título");
                            System.out.println("2 - Autor");
                            System.out.println("3 - Texto");
                            System.out.println("4 - Data de Publicação");
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
                                    System.out.println("Opção inválida.");
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }

            } else if (escolha == 5) {
                System.out.println("Encerrando o programa...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        }

        // Aqui você pode adicionar a lógica para cada opção do menu

        // Fechar o scanner
        scanner.close();
    }
}