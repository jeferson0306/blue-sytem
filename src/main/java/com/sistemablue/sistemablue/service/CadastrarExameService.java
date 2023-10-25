package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.model.exame.ExamesCadastrados;
import com.sistemablue.sistemablue.repository.CadastrarExamesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CadastrarExameService {

    private final CadastrarExamesRepository cadastrarExamesRepository;

    public Mono<ExamesCadastrados> cadastrarExames(final ExamesCadastrados examesCadastrados) {
        log.info("Cadastrando novos exames para o paciente: [{}]", examesCadastrados);
        final var exameCadastrado = cadastrarExamesRepository.save(examesCadastrados);
        log.info("Exames cadastrados para o paciente: [{}]", examesCadastrados);
        return exameCadastrado;
    }



}
