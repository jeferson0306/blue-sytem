package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.model.exame.ExamesCadastrados;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ExameRepository extends ReactiveMongoRepository<ExamesCadastrados, Long> {

    Flux<ExamesCadastrados> findCadastroDeExameByObjectId(final ObjectId objectId);
    Flux<ExamesCadastrados> findByNome(final String nome);
    Flux<ExamesCadastrados> findByDataCadastro(final String dataCadastro);




}

