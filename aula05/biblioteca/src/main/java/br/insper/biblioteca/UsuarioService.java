package br.insper.biblioteca;

import java.util.ArrayList;

public class UsuarioService {

    private ArrayList<Usuario> usuarios =  new ArrayList<>();

    public void cadastrarUsuario(String nome, String endereco, String email,
                                 Biblioteca biblioteca) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEndereco(endereco);
        usuario.setEmail(email);
        usuario.setBiblioteca(biblioteca);

        usuarios.add(usuario);
        biblioteca.getUsuarios().add(usuario);
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Biblioteca: " + usuario.getBiblioteca().getNome());
        }
    }

}
