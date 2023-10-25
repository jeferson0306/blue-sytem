package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.model.exame.ExamesCadastrados;
import com.sistemablue.sistemablue.repository.ExameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsultarExameService {

    private final ExameRepository exameRepository;

    public Flux<ExamesCadastrados> buscarExamesDoCliente(final ObjectId objectId) {
        return exameRepository.findCadastroDeExameByObjectId(objectId);
    }

    public Flux<ExamesCadastrados> buscarExamesPorDataRealizacao(final String dataCadastro) {
        return exameRepository.findByDataCadastro(dataCadastro);
    }

    public Flux<ExamesCadastrados> buscarExamesPorNomeDoCliente(final String nome) {
        return exameRepository.findByNome(nome);
    }

}
