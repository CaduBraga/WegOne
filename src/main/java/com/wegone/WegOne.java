package com.wegone;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.json.JSONObject;

public class WegOne {

    private static JSONObject mensagensNoIdiomaEscolhido;
    private static String userRole;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String idiomaEscolhido = IdiomaHelper.escolherIdioma(scanner);

        if (idiomaEscolhido != null) {
            System.out.println("Idioma selecionado: " + idiomaEscolhido);
        } else {
            System.out.println("Nenhum idioma selecionado.");
        }

        InputStream inputStream = WegOne.class.getClassLoader()
                .getResourceAsStream("translate/" + idiomaEscolhido + ".json");

        if (inputStream == null) {
            System.out.println("Arquivo não encontrado: translate/" + idiomaEscolhido + ".json");
            return;
        }

        String conteudo = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        JSONObject root = new JSONObject(conteudo);
        mensagensNoIdiomaEscolhido = root.getJSONObject("Messages");

        Manual.carregarIdioma(root);

        traduzir("welcome");

        traduzir("enter-your-username");
        System.out.print("> ");
        String usuario = scanner.nextLine();

        if (!ValidacaoUsuario.usuarioExiste(usuario)) {
            traduzir("invalid-username");
            return;
        }

        traduzir("enter-your-password");
        System.out.print("> ");
        String senha = scanner.nextLine();

        if (!ValidacaoUsuario.validarSenha(usuario, senha)) {
            traduzir("invalid-password");
            return;
        }

        userRole = ValidacaoUsuario.obterPapelDoUsuario(usuario, senha);

        while (true) {
            int escolha = IdiomaHelper.exibirMenuInicial(userRole, scanner);

            switch (escolha) {
                case 1:
                    if (!userRole.equals("viewer")) {
                        Manual novoManual = new Manual();
                        novoManual.cadastrar();
                    } else {
                        System.out.println("Acesso negado.");
                    }
                    break;

                case 2:

                    IdiomaHelper.visualizar(scanner);
                    break;
                case 3:
                    IdiomaHelper.deletar(scanner, userRole);
                    break;
                case 4:
                    IdiomaHelper.editar(scanner, userRole);

                    break;

                case 5:
                    IdiomaHelper.encerrando();
                    break;

                default:
                    traduzir("invalid-option-try-again");
                    break;

            }

        }

    }

    private static void traduzir(String chave) {
        String mensagem = mensagensNoIdiomaEscolhido.optString(chave, chave);
        System.out.println(mensagem);
    }
}