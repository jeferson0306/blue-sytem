package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, Long> {

    Mono<Cliente> findById(final Long id);
    Flux<Cliente> findByNome(final String nome);
    Mono<Cliente> findByCpf(final String cpf);
    Flux<Cliente> findByRg(final String rg);
    Flux<Cliente> findByDataNascimento(final String dataNascimento);
    Flux<Cliente> findByEmailsEmail(final String email);
    Flux<Cliente> findByTelefonesNumero(final String numero);
    Flux<Cliente> findByEnderecosCidade(final String cidade);
    Flux<Cliente> findAll();

}
