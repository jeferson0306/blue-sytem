package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.model.Cliente;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, Long> {

    Flux<Cliente> findByNome(String nome);
    Mono<Cliente> findByCpf(String cpf);
    Flux<Cliente> findByRg(String rg);
    Flux<Cliente> findByEmailsEmail(String email);
    Flux<Cliente> findByEnderecosCidade(String cidade);
    Flux<Cliente> findByDataNascimento(String dataNascimento);
    Flux<Cliente> findByTelefonesNumero(String numero);
    Mono<Cliente> findById(String id);
    Flux<Cliente> findAll();
    Cliente findById(ObjectId objectId);
    Mono<Cliente> findById(Long id);

}
