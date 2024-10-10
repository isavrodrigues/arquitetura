package br.insper.banda.musica;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    @PostMapping("/musica")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarBanda(@Valid @RequestBody Musica musica) {
        return musicaService.cadastrarMusica(musica);
    }

    @GetMapping("/musica")
    public ArrayList<Musica> listarMusicas(@RequestHeader @RequestParam(required = false) String banda) {
        return musicaService.listaMusicas(banda);
    }


    @DeleteMapping("/musica/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirMusica(@PathVariable String id) {
        musicaService.excluir(id);
    }

    @GetMapping("/musica/maisTocada")
    public HashMap<String, String> maisTocada() {
        return musicaService.bandaMusicaMaisTocada();
    }


}
