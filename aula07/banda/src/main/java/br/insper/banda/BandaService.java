package br.insper.banda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BandaService {

    @Autowired
    private BandaRepository bandaRepository;


    public String cadastrarBanda(Banda banda) {
        bandaRepository.save(banda);
        return "Banda cadastrada com sucesso";
    }

    public ArrayList<Banda> listarBandas(String pais) {
        if (pais != null) {
            return bandaRepository.findByPais(pais);
        }
        return new ArrayList<>(bandaRepository.findAll());
    }

    public Banda buscarBanda(String id) {
        return bandaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Banda nao encontrada"));
    }

    public void excluirBanda(String id) {
        Banda banda = buscarBanda(id);
        if (banda != null && banda.getMusicas().isEmpty()) {
            bandaRepository.delete(banda);
        } else {
            throw new BandaNaoEncontradaException("Banda: " + id + " nao encontrada");
        }
    }
}
