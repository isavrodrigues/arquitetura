package br.insper.banda;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BandaRepository extends MongoRepository<Banda, String> {

    ArrayList<Banda> findByPais(String pais);

}
