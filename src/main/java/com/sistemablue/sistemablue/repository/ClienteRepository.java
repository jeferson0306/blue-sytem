package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.model.entities.Cliente;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, ObjectId> {

    Mono<Cliente> findClienteByObjectId(final ObjectId objectId);
    Mono<Cliente> findClienteByNome(final String nome);
    Mono<Cliente> findClienteByCpf(final String cpf);
    Mono<Cliente> findClienteByRg(final String rg);
    Mono<Cliente> findClienteByDataNascimento(final String dataNascimento);
    Mono<Cliente> findClienteByEmailEmailCliente(final String email);
    Mono<Cliente> findClienteByTelefoneNumero(final String numero);
    Mono<Cliente> findClienteByEnderecoCidade(final String cidade);

}
