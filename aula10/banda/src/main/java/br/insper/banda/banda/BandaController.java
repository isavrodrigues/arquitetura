package br.insper.banda.banda;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/banda")
public class BandaController {

    @Autowired
    private BandaService bandaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarBandaDTO cadastrarBanda(@Valid @RequestBody CadastrarBandaDTO banda) {
        return bandaService.cadastrarBanda(banda);
    }

    @GetMapping
    public Page<Banda> listarBandas(@RequestParam(required = false) String pais
            , Pageable pageable) {
        return bandaService.listarBandas(pais, pageable);
    }

    @GetMapping("/{id}")
    public Banda getById(@PathVariable String id) {
        return bandaService.buscarBanda(id);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirBanda(@PathVariable String id) {
        bandaService.excluirBanda(id);
    }


}
