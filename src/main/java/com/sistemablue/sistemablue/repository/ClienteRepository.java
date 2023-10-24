package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.model.entities.Cliente;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, Long> {

    Mono<Cliente> findById(final Long id);
    Mono<Cliente> findByObjectId(final ObjectId objectId);
    Mono<Cliente> findByNome(final String nome);
    Mono<Cliente> findByCpf(final String cpf);
    Mono<Cliente> findByRg(final String rg);
    Mono<Cliente> findByDataNascimento(final String dataNascimento);
    Mono<Cliente> findClienteByEmail(final String email);
    Mono<Cliente> findClienteByTelefoneNumero(final String numero);
    Mono<Cliente> findClienteByEnderecoCidade(final String cidade);
    Flux<Cliente> findAll();

}
