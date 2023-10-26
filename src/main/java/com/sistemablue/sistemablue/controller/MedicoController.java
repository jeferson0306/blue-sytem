package com.sistemablue.sistemablue.controller;

import com.sistemablue.sistemablue.domain.model.MedicoDTO;
import com.sistemablue.sistemablue.domain.entities.Medico;
import com.sistemablue.sistemablue.service.MedicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    @GetMapping("/consultar-medico-por-nome/{nome}")
    public Mono<Medico> buscarMedicoPorNome(@PathVariable final String nome) {
        log.info("Início da solicitação para buscar medico por nome: [{}]", nome);
        final var medico = medicoService.buscarMedicoPorNome(nome);
        log.info("Fim da solicitação para buscar medico por nome: [{}]", nome);
        return medico;
    }

    @GetMapping("/consultar-medico-por-crm/{crm}")
    public Mono<Medico> buscarMedicoPorCrm(@PathVariable final String crm) {
        log.info("Início da solicitação para buscar medico por crm: [{}]", crm);
        final var medico = medicoService.buscarMedicoPorCrm(crm);
        log.info("Fim da solicitação para buscar medico por crm: [{}]", crm);
        return medico;
    }

    @GetMapping("/consultar-medico-por-id/{objectId}")
    public Mono<Medico> buscarMedicoPorObjectId(@PathVariable final ObjectId objectId) {
        log.info("Início da solicitação para buscar medico por objectId: [{}]", objectId);
        final var medico = medicoService.buscarMedicoPorObjectId(objectId);
        log.info("Fim da solicitação para buscar medico por objectId: [{}]", objectId);
        return medico;
    }

    @GetMapping("/consultar-medicos-por-nome/{nome}")
    public Flux<Medico> buscarMedicosPorParteDoNome(@PathVariable final String nome) {
        log.info("Início da solicitação para buscar médicos por parte do nome: [{}]", nome);
        final var medicos = medicoService.buscarMedicosPorParteDoNome(nome);
        log.info("Fim da solicitação para buscar médicos por parte do nome: [{}]", nome);
        return medicos;
    }

    @PostMapping("/cadastrar-medico")
    public Mono<Medico> cadastrarMedico(@RequestBody final MedicoDTO medico) {
        log.info("Início da solicitação de cadastro para o medico [{}]", medico.getNome());
        final var medicoCadastrado = medicoService.cadastrarMedico(medico);
        log.info("Fim da solicitação de cadastro para o medico [{}]", medico.getNome());
        return medicoCadastrado;
    }
}
