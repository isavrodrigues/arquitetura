package br.insper.biblioteca;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EmprestimoService {

    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarEmprestimo(String codigo, String status, LocalDateTime dataDevolucao, Usuario usuario, Livro livro) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setCodigo(codigo);
        emprestimo.setStatus(status);
        emprestimo.setDataDevolucao(dataDevolucao);
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);

        emprestimos.add(emprestimo);
        livro.adicionaEmprestimo(emprestimo);
    }

    public void listarEmprestimos() {
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("Código: " + emprestimo.getCodigo());
            System.out.println("Status: " + emprestimo.getStatus());
            System.out.println("Data de Devolução: " + emprestimo.getDataDevolucao());
            System.out.println("Usuário: " + emprestimo.getUsuario().getNome());
            System.out.println("Livro: " + emprestimo.getLivro().getNome());
        }
    }
}