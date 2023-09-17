package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.model.Exame;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ExameRepository extends ReactiveMongoRepository<Exame, Long> {

    Flux<Exame> findExamesById(Long id);
    Flux<Exame> findByDataRealizacao(String dataRealizacao);
    Flux<Exame> findByNomeDoCliente(String nomeDoCliente);



}

