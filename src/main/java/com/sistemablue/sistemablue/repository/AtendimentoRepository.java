package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.domain.entities.Atendimento;
import com.sistemablue.sistemablue.domain.entities.Cliente;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AtendimentoRepository extends MongoRepository<Atendimento, ObjectId> {

    List<Atendimento> findByCliente(final Cliente cliente);

}
