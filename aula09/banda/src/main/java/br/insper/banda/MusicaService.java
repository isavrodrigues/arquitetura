package br.insper.banda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MusicaService {

    private ArrayList<Musica> musicas = new ArrayList<>();

    @Autowired
    private BandaService bandaService;


    public String cadastrarMusica(Musica musica) {

        Banda banda = bandaService.buscarBanda(musica.getBanda().getId());
        if (banda != null) {
            musica.setBanda(banda);
            musicas.add(musica);
            banda.getMusicas().add(musica);
            return "Música cadastrada com sucesso";
        } else {
            return "Banda não encontrada";
        }
    }

    public ArrayList<Musica> listaMusicas(String banda) {
        if (banda != null) {
            ArrayList<Musica> response = new ArrayList<>();
            for (Musica musica : musicas) {
                if (musica.getBanda().getNome().equals(banda)) {
                    response.add(musica);
                }
            }
            return response;
        }
        return musicas;
    }

    public Musica buscarMusica(Integer id) {
        for (Musica musica : musicas) {
            if (musica.getId().equals(id)) {
                return musica;
            }
        }
        return null;
    }

    public void excluir(Integer id) {
        Musica musica = buscarMusica(id);
        musicas.removeIf(m -> m.getId().equals(id));
        musica.getBanda().getMusicas().removeIf(m -> m.getId().equals(id));
    }

    public HashMap<String, String> bandaMusicaMaisTocada() {
        HashMap<String, String> maisTocadaNome = new HashMap<>();
        HashMap<String, Integer> maisTocadaNumero = new HashMap<>();
        for (Musica musica : musicas) {
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
