package com.sistemablue.sistemablue.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CadastrarExamesRepository extends ReactiveMongoRepository<AtendimentoExameDTO, ObjectId> {
}
