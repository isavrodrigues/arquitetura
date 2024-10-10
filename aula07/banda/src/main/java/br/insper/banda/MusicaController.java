package br.insper.banda;

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
    public String cadastrarBanda(@RequestBody Musica musica) {
        return musicaService.cadastrarMusica(musica);
    }

    @GetMapping("/musica")
    public ArrayList<Musica> listarMusicas(@RequestParam(required = false) String banda) {
        return musicaService.listaMusicas(banda);
    }


    @DeleteMapping("/musica/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirMusica(@PathVariable Integer id) {
        musicaService.excluir(id);
    }

    @GetMapping("/musica/maisTocada")
    public HashMap<String, String> maisTocada() {
        return musicaService.bandaMusicaMaisTocada();
    }


}
