package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.model.CadastroDeExame;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ExameRepository extends ReactiveMongoRepository<CadastroDeExame, Long> {

    Flux<CadastroDeExame> findCadastroDeExameByObjectId(final ObjectId objectId);
    Flux<CadastroDeExame> findByDataRealizacao(final String dataRealizacao);
    Flux<CadastroDeExame> findByNome(final String nome);




}

