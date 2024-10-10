package br.insper.biblioteca;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer opcao = 0;

        //instanciando os serviços
        BibliotecaService bibliotecaService = new BibliotecaService();
        UsuarioService usuarioService = new UsuarioService();
        LivroService livroService = new LivroService();
        ReservaService reservaService = new ReservaService();
        EmprestimoService emprestimoService = new EmprestimoService();

        while (opcao != 10) {

            System.out.println("1 - Cadastrar Biblioteca");
            System.out.println("2 - Listar Biblitecas");
            System.out.println("3 - Cadastrar Usuário");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Cadastrar Livro");
            System.out.println("6 - Listar Livros");
            System.out.println("7 - Cadastrar Reserva");
            System.out.println("8 - Listar Reservas");
            System.out.println("9 - Cadastrar Empréstimo");
            System.out.println("10 - Listar Empréstimos");
            System.out.println("11 - Sair");

            opcao = scanner.nextInt();

            //cadastrar biblioteca
            if (opcao == 1) {
                System.out.println("Digite o nome biblioteca:");
                String nome = scanner.next();

                System.out.println("Digite o endereço da bilioteca");
                String endereco = scanner.next();

                bibliotecaService.cadastrarBiblioteca(nome, endereco);

            }

            //listar bibliotecas
            if (opcao == 2) {
                bibliotecaService.listarBibliotecas();
            }

            //cadastrar usuário
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

            //listar usuarios
            if (opcao == 4) {
                usuarioService.listarUsuarios();
            }

            //cadastrar livro
            if (opcao == 5) {
                System.out.println("Digite o nome do livro:");
                String nomeLivro = scanner.next();

                System.out.println("Digite o nome do autor:");
                String autor = scanner.next();

                System.out.println("O livro está disponível? (true/false):");
                Boolean disponivel = scanner.nextBoolean();

                System.out.println("Digite o nome da biblioteca:");
                String nomeBiblioteca = scanner.next();

                Biblioteca biblioteca = bibliotecaService.buscarBiblioteca(nomeBiblioteca);

                if (biblioteca != null) {
                    livroService.cadastrarLivro(nomeLivro, autor, disponivel, biblioteca);
                } else {
                    System.out.println("Biblioteca não encontrada.");
                }
            }

            //listar livros
            if (opcao == 6) {
                livroService.listarLivros();
            }

            //cadastrar reserva
            if (opcao == 7) {
                System.out.println("Digite o código da reserva:");
                String codigoReserva = scanner.next();

                System.out.println("Digite o nome do usuário:");
                String nomeUsuario = scanner.next();

                Usuario usuario = usuarioService.buscarUsuario(nomeUsuario);

                if (usuario != null) {
                    System.out.println("Digite o nome do livro:");
                    String nomeLivro = scanner.next();

                    Livro livro = livroService.buscarLivro(nomeLivro);

                    if (livro != null) {
                        LocalDateTime dataHora = LocalDateTime.now();
                        reservaService.cadastrarReserva(codigoReserva, dataHora, usuario, livro);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                } else {
                    System.out.println("Usuário não encontrado.");
                }
            }

            //listar reservas
            if (opcao == 8) {
                reservaService.listarReservas();
            }

            //cadastrar empréstimo
            if (opcao == 9) {
                System.out.println("Digite o código do empréstimo:");
                String codigoEmprestimo = scanner.next();

                System.out.println("Digite o status do empréstimo:");
                String status = scanner.next();

                System.out.println("Digite o nome do usuário:");
                String nomeUsuario = scanner.next();

                Usuario usuario = usuarioService.buscarUsuario(nomeUsuario);

                if (usuario != null) {
                    System.out.println("Digite o nome do livro:");
                    String nomeLivro = scanner.next();

                    Livro livro = livroService.buscarLivro(nomeLivro);

                    if (livro != null) {
                        System.out.println("Digite a data de devolução (yyyy-MM-dd):");
                        String dataDevolucaoStr = scanner.next();
                        LocalDateTime dataDevolucao = LocalDateTime.parse(dataDevolucaoStr + "T00:00:00");

                        emprestimoService.cadastrarEmprestimo(codigoEmprestimo, status, dataDevolucao, usuario, livro);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                } else {
                    System.out.println("Usuário não encontrado.");
                }
            }

            //listar empréstimos
            if (opcao == 10) {
                emprestimoService.listarEmprestimos();
            }

        }

        scanner.close();

        }


    }

}
