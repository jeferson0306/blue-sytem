package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.model.exame.ExamesCadastrados;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CadastrarExamesRepository extends ReactiveMongoRepository<ExamesCadastrados, ObjectId> {
}
