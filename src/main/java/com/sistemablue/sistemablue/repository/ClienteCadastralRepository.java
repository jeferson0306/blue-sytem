package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.domain.entities.Cliente;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteCadastralRepository extends MongoRepository<Cliente, ObjectId> {

    Cliente findByCpf(final String cpf);

}
