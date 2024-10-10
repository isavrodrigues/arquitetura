package br.insper.banda;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BandaService {

    private ArrayList<Banda> bandas = new ArrayList<>();


    public String cadastrarBanda(Banda banda) {
        bandas.add(banda);
        return "Banda cadastrada com sucesso";
    }

    public ArrayList<Banda> listarBandas(String pais) {
        if (pais != null) {
            ArrayList<Banda> response = new ArrayList<>();
            for (Banda banda : bandas) {
                if (banda.getPais().equals(pais)) {
                    response.add(banda);
                }
            }
            return response;
        }
        return bandas;
    }

    public Banda buscarBanda(Integer id) {
        for (Banda banda : bandas) {
            if (banda.getId().equals(id)) {
                return banda;
            }
        }
        return null;
    }

    public void excluirBanda(Integer id) {
        Banda banda = buscarBanda(id);
        if (banda != null && banda.getMusicas().isEmpty()) {
            bandas.removeIf(b -> b.getId().equals(id));
        } else {
            throw new BandaNaoEncontradaException("Banda: " + id + " nao encontrada");
        }
    }
}
