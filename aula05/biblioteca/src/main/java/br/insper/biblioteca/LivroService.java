package br.insper.biblioteca;
import java.util.ArrayList;

public class LivroService {
    //declara a classe LivroService que vai gerenciar os livros
    private ArrayList<Livro> livros = new ArrayList<>();


    public void cadastrarLivro(String nome, String autor, Boolean disponivel, Biblioteca biblioteca) {
        Livro livro = new Livro();
        livro.setNome(nome);
        livro.setAutor(autor);
        livro.setDisponivel(disponivel);
        livro.setBiblioteca(biblioteca);

        //cria uma lista livros que amarzenara os objetos do tipo Livro
        livros.add(livro);
        biblioteca.getLivros().add(livro);
    }


    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println("Nome: " + livro.getNome());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Disponível: " + livro.getDisponivel());
            System.out.println("Biblioteca: " + livro.getBiblioteca().getNome());
        }
    }
    //metodo para buscar um livro pelo nome
    public Livro buscarLivro(String nome) {
        for (Livro livro : livros) {
            if (livro.getNome().equals(nome)) {
                return livro;
            }
        }
        return null;
    }
}