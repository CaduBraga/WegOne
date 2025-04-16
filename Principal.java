import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ManualDeOperacao[] manuais = new ManualDeOperacao[10];
        int totalManuais = 10;

        manuais = ManuaisIniciais.imprimir();
        totalManuais = manuais.length;

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Inserir um novo manual");
            System.out.println("2 - Ver manuais existentes");
            System.out.println("3 - Apagar um manual existente");
            System.out.println("4 - Editar um manual existente");
            System.out.println("5 - Encerrar o programa");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1) {
                if (totalManuais == manuais.length) {
                    ManualDeOperacao[] novoArray = new ManualDeOperacao[manuais.length * 2];
                    System.arraycopy(manuais, 0, novoArray, 0, manuais.length);
                    manuais = novoArray;
                }
                ManualDeOperacao novoManual = new ManualDeOperacao("", new Date(), "", "");
                novoManual.preencherDados();
                manuais[totalManuais] = novoManual;
                totalManuais++;
                System.out.println("Novo manual inserido com sucesso!");

            } else if (escolha == 2) {
                System.out.println("Manuais existentes:");
                for (int i = 0; i < totalManuais; i++) {
                    System.out.println((i + 1) + " - " + manuais[i].getTitulo());
                }
                System.out.println("Escolha o número do manual para visualizar os detalhes:");
                int manualEscolhido = scanner.nextInt();
                scanner.nextLine();
                if (manualEscolhido >= 1 && manualEscolhido <= totalManuais) {
                    manuais[manualEscolhido - 1].exibirManual();
                } else {
                    System.out.println("Opção inválida.");
                }

            } else if (escolha == 3) {
                System.out.println("Escolha o número do manual que deseja apagar:");
                for (int i = 0; i < totalManuais; i++) {
                    System.out.println((i + 1) + " - " + manuais[i].getTitulo());
                }
                int apagar = scanner.nextInt();
                scanner.nextLine();

                if (apagar >= 1 && apagar <= totalManuais) {
                    for (int i = apagar - 1; i < totalManuais - 1; i++) {
                        manuais[i] = manuais[i + 1];
                    }
                    manuais[totalManuais - 1] = null;
                    totalManuais--;
                    System.out.println("Manual apagado com sucesso!");
                } else {
                    System.out.println("Opção inválida.");
                }

            } else if (escolha == 4) {
                System.out.println("Escolha o número do manual que deseja editar:");
                for (int i = 0; i < totalManuais; i++) {
                    System.out.println((i + 1) + " - " + manuais[i].getTitulo());
                }
                int editar = scanner.nextInt();
                scanner.nextLine();
                if (editar >= 1 && editar <= totalManuais) {
                    ManualDeOperacao manual = manuais[editar - 1];
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

            } else if (escolha == 5) {
                System.out.println("Encerrando o programa...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}