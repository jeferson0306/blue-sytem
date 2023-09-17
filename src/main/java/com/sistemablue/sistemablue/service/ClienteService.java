package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.exception.ClienteNotFoundException;
import com.sistemablue.sistemablue.model.Cliente;
import com.sistemablue.sistemablue.model.Exame;
import com.sistemablue.sistemablue.repository.ClienteRepository;
import com.sistemablue.sistemablue.repository.ExameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ExameRepository exameRepository;

    public Mono<Cliente> buscarClientePorCpf(String cpf) {
        log.info("Buscando cliente por CPF: [{}]", cpf);
        return clienteRepository.findByCpf(cpf)
                .switchIfEmpty(Mono.error(new ClienteNotFoundException(cpf)));
    }

    public Mono<Cliente> buscarClientePorId(Long id) {
        log.info("Buscando cliente por ID: [{}]", id);
        return clienteRepository.findById(id)
                .switchIfEmpty(Mono.error(new ClienteNotFoundException(id.toString())));
    }

    public Flux<Cliente> buscarTodosClientes() {
        log.info("Clientes encontrados: [{}]", clienteRepository.findAll());
        return clienteRepository.findAll();
    }

    public Flux<Exame> buscarExamesDoCliente(Long clienteId) {
        return exameRepository.findExamesById(clienteId);
    }

}
