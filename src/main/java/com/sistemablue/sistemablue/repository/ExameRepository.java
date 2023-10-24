package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.model.exame.CadastrarExame;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ExameRepository extends ReactiveMongoRepository<CadastrarExame, Long> {

    Flux<CadastrarExame> findCadastroDeExameByObjectId(final ObjectId objectId);
    Flux<CadastrarExame> findByDataRealizacao(final String dataRealizacao);
    Flux<CadastrarExame> findByNome(final String nome);




}

