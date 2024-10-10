package br.insper.biblioteca;

import java.util.ArrayList;

public class BibliotecaService {

    private ArrayList<Biblioteca> bibliotecas = new ArrayList<>();
    public void cadastrarBiblioteca(String nome, String endereco) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNome(nome);
        biblioteca.setEndereco(endereco);

        bibliotecas.add(biblioteca);
    }

    public void listarBibliotecas() {
        for (Biblioteca biblioteca : bibliotecas) {
            System.out.println("Nome: " + biblioteca.getNome());
        }
    }

    public Biblioteca buscarBiblioteca(String nomeBiblioteca) {

       // return bibliotecas
       //         .stream()
       //         .filter(b -> b.getNome().equals(nomeBiblioteca))
       //         .findFirst()
       //         .get();

        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getNome().equals(nomeBiblioteca)) {
                return biblioteca;
            }
        }
        return null;
    }
}
