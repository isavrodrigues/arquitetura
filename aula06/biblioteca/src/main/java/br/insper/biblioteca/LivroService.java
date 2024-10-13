package br.insper.biblioteca;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LivroService {

    private ArrayList<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public ArrayList<Livro> listarLivros() {
        return livros;
    }

    public void removerLivro(String nome) {
        livros.removeIf(livro -> livro.getNome().equals(nome));
    }
}