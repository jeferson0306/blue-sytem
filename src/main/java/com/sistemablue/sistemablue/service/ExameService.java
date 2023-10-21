package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.model.CadastroDeExame;
import com.sistemablue.sistemablue.repository.ExameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExameService {

    private final ExameRepository exameRepository;
    private final ProcessarExamesService processarExamesService;

    public Flux<CadastroDeExame> buscarExamesDoCliente(final ObjectId objectId) {
        return exameRepository.findCadastroDeExameByObjectId(objectId);
    }

    public Flux<CadastroDeExame> buscarExamesPorDataRealizacao(final String dataRealizacao) {
        return exameRepository.findByDataRealizacao(dataRealizacao);
    }

    public Flux<CadastroDeExame> buscarExamesPorNomeDoCliente(final String nome) {
        return exameRepository.findByNome(nome);
    }

    public Mono<CadastroDeExame> cadastrarNovoExame(final CadastroDeExame cadastroDeExame) {
        log.info("Iniciando o cadastro de novos exames: [{}]", cadastroDeExame.getNome());
        final var exames = List.of(cadastroDeExame);
        processarExamesService.processarExames(exames);
        log.info("Finalizado o processamento dos exames: [{}]", cadastroDeExame.getNome());
        return exameRepository.save(cadastroDeExame);
    }

}
