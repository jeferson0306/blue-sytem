package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.model.Exame;
import com.sistemablue.sistemablue.repository.ExameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExameService {

    private final ExameRepository exameRepository;

    public Flux<Exame> buscarExamesDoCliente(Long clienteId) {
        return exameRepository.findExamesById(clienteId);
    }

    public Flux<Exame> buscarExamesPorDataRealizacao(String dataRealizacao) {
        return exameRepository.findByDataRealizacao(dataRealizacao);
    }

    public Flux<Exame> buscarExamesPorNomeDoCliente(String nomeDoCliente) {
        return exameRepository.findByNomeDoCliente(nomeDoCliente);
    }

    public Mono<Exame> cadastrarNovoExame(Exame exame) {
        log.info("Cadastrando um novo exame: [{}]", exame.getNome());
        return exameRepository.save(exame);
    }

}
