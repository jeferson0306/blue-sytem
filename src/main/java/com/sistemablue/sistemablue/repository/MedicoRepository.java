package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.model.entities.Medico;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface MedicoRepository extends ReactiveMongoRepository<Medico, ObjectId> {

    Mono<Medico> findMedicoByObjectId(final ObjectId objectId);

    Mono<Medico> findMedicoByCrm(final String crm);

    Mono<Medico> findMedicoByNome(final String nome);

}
