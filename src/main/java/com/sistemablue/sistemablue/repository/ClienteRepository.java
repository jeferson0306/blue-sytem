package com.sistemablue.sistemablue.repository;

import com.sistemablue.sistemablue.model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, Long> {

    Mono<Cliente> findById(Long id);
    Flux<Cliente> findByNome(String nome);
    Mono<Cliente> findByCpf(String cpf);
    Flux<Cliente> findByRg(String rg);
    Flux<Cliente> findByDataNascimento(String dataNascimento);
    Flux<Cliente> findByEmailsEmail(String email);
    Flux<Cliente> findByTelefonesNumero(String numero);
    Flux<Cliente> findByEnderecosCidade(String cidade);
    Flux<Cliente> findAll();

}
