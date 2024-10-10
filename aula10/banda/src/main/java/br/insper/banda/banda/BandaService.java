package br.insper.banda.banda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BandaService {

    @Autowired
    private BandaRepository bandaRepository;


    public RetornarBandaDTO cadastrarBanda(CadastrarBandaDTO dto) {
        Banda banda = new Banda();
        banda.setNome(dto.nome());
        banda.setPais(dto.pais());
        banda.setAnoFormacao(dto.anoFormacao());

        banda = bandaRepository.save(banda);
        return new RetornarBandaDTO(banda.getId(), banda.getNome(), banda.getPais());
    }

    public Page<Banda> listarBandas(String pais, Pageable pageable) {
        if (pais != null) {
            return bandaRepository.findByPais(pais, pageable);
        }
        return bandaRepository.findAll(pageable);
    }

    public Banda buscarBanda(String id) {
        return bandaRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    public void excluirBanda(String id) {
        Banda banda = buscarBanda(id);
        if (banda != null && banda.getMusicas().isEmpty()) {
            bandaRepository.delete(banda);
        } else {
            throw new RuntimeException("Banda: " + id + " nao encontrada");
        }
    }
}
