package br.insper.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/livro")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarLivro(@RequestBody Livro livro) {
        livroService.cadastrarLivro(livro);
        return "Livro cadastrado com sucesso";
    }

    @GetMapping("/livro")
    public ArrayList<Livro> listarLivros() {
        return livroService.listarLivros();
    }

    @DeleteMapping("/livro/{nome}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerLivro(@PathVariable String nome) {
        livroService.removerLivro(nome);
    }
}
