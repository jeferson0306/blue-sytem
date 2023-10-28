package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.domain.entities.Cliente;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, ObjectId> {

    Mono<Cliente> findClienteByObjectId(final ObjectId objectId);
    Mono<Cliente> findByNome(final String nome);
    Mono<Cliente> findByCpf(final String cpf);
    Mono<Cliente> findByRg(final String rg);
    Mono<Cliente> findByDataNascimento(final String dataNascimento);
    Mono<Cliente> findByEmail(final String email);
    Mono<Cliente> findByTelefone(final String numero);
    Mono<Cliente> findByEndereco(final String cidade);

}
