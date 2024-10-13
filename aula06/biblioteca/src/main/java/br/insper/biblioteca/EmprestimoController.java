package br.insper.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/emprestimo")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarEmprestimo(@RequestBody Emprestimo emprestimo) {
        emprestimoService.cadastrarEmprestimo(emprestimo);
        return "Empréstimo cadastrado com sucesso";
    }

    @GetMapping("/emprestimo")
    public ArrayList<Emprestimo> listarEmprestimos() {
        return emprestimoService.listarEmprestimos();
    }

    @DeleteMapping("/emprestimo/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEmprestimo(@PathVariable String codigo) {
        emprestimoService.removerEmprestimo(codigo);
    }
}