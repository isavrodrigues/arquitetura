package br.insper.banda.musica;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MusicaRepository extends MongoRepository<Musica, String> {

    public List<Musica> findByBandaNome(String nome);
}
