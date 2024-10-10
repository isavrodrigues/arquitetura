package br.insper.banda.musica;

import br.insper.banda.banda.Banda;
import br.insper.banda.banda.BandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private BandaService bandaService;


    public String   cadastrarMusica(Musica musica) {

        Banda banda = bandaService.buscarBanda(musica.getBanda().getId());
        if (banda != null) {
            musica.setBanda(banda);
            musicaRepository.save(musica);
            return "Música cadastrada com sucesso";
        } else {
            return "Banda não encontrada";
        }
    }

    public ArrayList<Musica> listaMusicas(String banda) {
        if (banda != null) {
            musicaRepository.findByBandaNome(banda);
        }
        return new ArrayList<>(musicaRepository.findAll());
    }

    public Musica buscarMusica(String id) {

        return musicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Musica não encontrada"));
    }

    public void excluir(String id) {
        Musica musica = buscarMusica(id);
        musicaRepository.delete(musica);
    }

    public HashMap<String, String> bandaMusicaMaisTocada() {
        HashMap<String, String> maisTocadaNome = new HashMap<>();
        HashMap<String, Integer> maisTocadaNumero = new HashMap<>();
        for (Musica musica : musicaRepository.findAll()) {
            if (!maisTocadaNome.containsKey(musica.getBanda().getNome())) {
                maisTocadaNome.put(musica.getBanda().getNome(), musica.getNome());
                maisTocadaNumero.put(musica.getBanda().getNome(), musica.getReproducoes());
            } else {
                Integer numero = maisTocadaNumero.get(musica.getBanda().getNome());
                if (musica.getReproducoes() > numero) {
                    maisTocadaNome.put(musica.getBanda().getNome(), musica.getNome());
                    maisTocadaNumero.put(musica.getBanda().getNome(), musica.getReproducoes());
                }
            }
        }
        return maisTocadaNome;
    }

}
