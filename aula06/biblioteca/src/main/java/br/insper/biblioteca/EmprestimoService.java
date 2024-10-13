package br.insper.biblioteca;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmprestimoService {

    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public ArrayList<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

    public void removerEmprestimo(String codigo) {
        emprestimos.removeIf(emprestimo -> emprestimo.getCodigo().equals(codigo));
    }
}
