package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.model.exame.CadastrarExame;
import com.sistemablue.sistemablue.repository.ExameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExameService {

    private final ExameRepository exameRepository;

    public Flux<CadastrarExame> buscarExamesDoCliente(final ObjectId objectId) {
        return exameRepository.findCadastroDeExameByObjectId(objectId);
    }

    public Flux<CadastrarExame> buscarExamesPorDataRealizacao(final String dataRealizacao) {
        return exameRepository.findByDataRealizacao(dataRealizacao);
    }

    public Flux<CadastrarExame> buscarExamesPorNomeDoCliente(final String nome) {
        return exameRepository.findByNome(nome);
    }

}
