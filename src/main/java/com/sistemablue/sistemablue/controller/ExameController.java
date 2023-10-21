package com.sistemablue.sistemablue.controller;

import com.sistemablue.sistemablue.exception.ExameException;
import com.sistemablue.sistemablue.model.CadastroDeExame;
import com.sistemablue.sistemablue.service.ArquivoExameService;
import com.sistemablue.sistemablue.service.ExameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exames")
public class ExameController {

    private final ExameService exameService;

    @GetMapping("/{objectId}/exames")
    public Flux<CadastroDeExame> buscarExamesDoCliente(@PathVariable final ObjectId objectId) {
        log.info("Buscando exames do cliente: [{}]", objectId);
        final var cliente = exameService.buscarExamesDoCliente(objectId);
        log.info("Exames do cliente: [{}] encontrados para o id: [{}]", cliente, objectId);
        return cliente;
    }

    @GetMapping("/cliente/{nomeDoCliente}/exames")
    public Flux<CadastroDeExame> buscarExamesPorNomeDoCliente(@PathVariable final String nomeDoCliente) {
        log.info("Buscando exames do cliente por nome: [{}]", nomeDoCliente);
        final var cliente = exameService.buscarExamesPorNomeDoCliente(nomeDoCliente);
        log.info("Exames do cliente: [{}] encontrados para o nome: [{}]", cliente, nomeDoCliente);
        return cliente;
    }

    @GetMapping("/data/{dataRealizacao}/exames")
    public Flux<CadastroDeExame> buscarExamesPorDataRealizacao(@PathVariable final String dataRealizacao) {
        log.info("Buscando exames do cliente por data de realização: [{}]", dataRealizacao);
        final var cliente = exameService.buscarExamesPorDataRealizacao(dataRealizacao);
        log.info("Exames do cliente: [{}] encontrados para a data: [{}]", cliente, dataRealizacao);
        return cliente;
    }

    @PostMapping("/cadastro")
    public Mono<CadastroDeExame> cadastrarNovoExame(@RequestBody final CadastroDeExame cadastroDeExame) {
        log.info("Recebida solicitação para cadastrar um novo exame.");
        final var exameCadastrado = exameService.cadastrarNovoExame(cadastroDeExame);
        log.info("Finalizada a solicitação de cadastro: [{}]", exameCadastrado);
        return exameCadastrado;
    }

    @ExceptionHandler(ExameException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleExameNotFoundException(ExameException ex) {
        return ex.getMessage();
    }

}
