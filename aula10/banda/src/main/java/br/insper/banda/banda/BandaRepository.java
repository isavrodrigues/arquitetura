package br.insper.banda.banda;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandaRepository extends MongoRepository<Banda, String> {

    Page <Banda> findByPais(String pais, Pageable pageable);

}
