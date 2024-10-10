package br.insper.biblioteca;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer opcao = 0;

        BibliotecaService bibliotecaService = new BibliotecaService();
        UsuarioService usuarioService = new UsuarioService();
        while (opcao != 10) {

            System.out.println("1 - Cadastrar Biblioteca");
            System.out.println("2 - Listar Biblitecas");
            System.out.println("3 - Cadastrar Usuário");
            System.out.println("4 - Listar Usuários");
            System.out.println("10 - Sair");

            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Digite o nome biblioteca:");
                String nome = scanner.next();

                System.out.println("Digite o endereço da bilioteca");
                String endereco = scanner.next();

                bibliotecaService.cadastrarBiblioteca(nome, endereco);

            }

            if (opcao == 2) {
                bibliotecaService.listarBibliotecas();
            }

            if (opcao == 3) {
                System.out.println("Digite o nome do usuário:");
                String nome = scanner.next();

                System.out.println("Digite o email do usuário:");
                String email = scanner.next();

                System.out.println("Digite o endereco do usuário:");
                String endereco = scanner.next();

                System.out.println("Digite o nome da biblioteca:");
                String nomeBiblioteca = scanner.next();

                Biblioteca biblioteca = bibliotecaService.buscarBiblioteca(nomeBiblioteca);

                if (biblioteca != null) {
                    usuarioService
                            .cadastrarUsuario(nome, endereco, email, biblioteca);
                } else {
                    System.out.println("Erro ao cadastrar usuário.");
                }
            }

            if (opcao == 4) {
                usuarioService.listarUsuarios();
            }

            // adicionar as outras operacoes:
            // Cadastrar e Listar Livros
            // Cadastrar e Listar Reservas
            // Cadastrar e Listar Emprestimos

        }


    }

}
