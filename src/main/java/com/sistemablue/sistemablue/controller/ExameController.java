package com.sistemablue.sistemablue.controller;

import com.sistemablue.sistemablue.model.Exame;
import com.sistemablue.sistemablue.service.ExameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exames")
public class ExameController {

    private final ExameService exameService;

    @GetMapping("/{clienteId}/exames")
    public Flux<Exame> buscarExamesDoCliente(@PathVariable final Long clienteId) {
        log.info("Buscando exames do cliente: [{}]", clienteId);
        return exameService.buscarExamesDoCliente(clienteId);
    }

    @GetMapping("/cliente/{nomeDoCliente}/exames")
    public Flux<Exame> buscarExamesPorNomeDoCliente(@PathVariable final String nome) {
        log.info("Buscando exames do cliente por nome: [{}]", nome);
        return exameService.buscarExamesPorNomeDoCliente(nome);
    }

    @GetMapping("/data/{dataRealizacao}/exames")
    public Flux<Exame> buscarExamesPorDataRealizacao(@PathVariable final String dataRealizacao) {
        log.info("Buscando exames do cliente por data de realização: [{}]", dataRealizacao);
        return exameService.buscarExamesPorDataRealizacao(dataRealizacao);
    }

    @PostMapping("/cadastro")
    public Mono<Exame> cadastrarNovoExame(@RequestBody Exame exame) {
        log.info("Recebida solicitação para cadastrar um novo exame.");
        return exameService.cadastrarNovoExame(exame);
    }

}
