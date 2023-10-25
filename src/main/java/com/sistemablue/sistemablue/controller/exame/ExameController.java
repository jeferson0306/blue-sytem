package com.sistemablue.sistemablue.controller.exame;

import com.sistemablue.sistemablue.exception.ExameException;
import com.sistemablue.sistemablue.model.exame.ExamesCadastrados;
import com.sistemablue.sistemablue.service.CadastrarExameService;
import com.sistemablue.sistemablue.service.ConsultarExameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exames")
public class ExameController {

    private final ConsultarExameService consultarExameService;
    private final CadastrarExameService cadastrarExameService;

    @GetMapping("/consultar-exames-objectid/{objectId}")
    public Flux<ExamesCadastrados> buscarExamesDoCliente(@PathVariable final ObjectId objectId) {
        log.info("Buscando exames do cliente: [{}]", objectId);
        final var cliente = consultarExameService.buscarExamesDoCliente(objectId);
        log.info("Exames do cliente: [{}] encontrados para o id: [{}]", cliente, objectId);
        return cliente;
    }

    @GetMapping("/consultar-exames-por-nome-do-cliente/{nomeDoCliente}/")
    public Flux<ExamesCadastrados> buscarExamesPorNomeDoCliente(@PathVariable final String nomeDoCliente) {
        log.info("Buscando exames do cliente por nome: [{}]", nomeDoCliente);
        final var cliente = consultarExameService.buscarExamesPorNomeDoCliente(nomeDoCliente);
        log.info("Exames do cliente: [{}] encontrados para o nome: [{}]", cliente, nomeDoCliente);
        return cliente;
    }

    @GetMapping("/consultar-exames-por-data-de-cadastro/{dataRealizacao}")
    public Flux<ExamesCadastrados> buscarExamesPorDataRealizacao(@PathVariable final String dataCadastro) {
        log.info("Buscando exames do cliente por data de realização: [{}]", dataCadastro);
        final var cliente = consultarExameService.buscarExamesPorDataRealizacao(dataCadastro);
        log.info("Exames do cliente: [{}] encontrados para a data: [{}]", cliente, dataCadastro);
        return cliente;
    }

    @PostMapping("/cadastrar-exames-paciente")
    public Mono<ExamesCadastrados> cadastrarExamesPaciente(@RequestBody final ExamesCadastrados examesCadastrados) {
        log.info("Início da solicitação para cadastrar exames para um paciente.");
        final var exameCadastrado = cadastrarExameService.cadastrarExames(examesCadastrados);
        log.info("Fim da solicitação para cadastrar exames para um paciente.");
        return exameCadastrado;
    }

    @ExceptionHandler(ExameException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleExameNotFoundException(ExameException ex) {
        return ex.getMessage();
    }

}
