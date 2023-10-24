package com.sistemablue.sistemablue.controller.exame;

import com.sistemablue.sistemablue.model.cliente.ClienteDto;
import com.sistemablue.sistemablue.model.exame.ExamesCadastrados;
import com.sistemablue.sistemablue.service.CadastrarExameService;
import com.sistemablue.sistemablue.service.ProcessamentoExamesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exames")
public class CadastrarExameController {

    private final CadastrarExameService cadastrarExameService;
    private final ProcessamentoExamesService processamentoExamesService;

    @PostMapping("/cadastrar-exames-paciente")
    public Mono<ExamesCadastrados> cadastrarExamesPaciente(@RequestBody final ExamesCadastrados examesCadastrados) {
        log.info("Início da solicitação para cadastrar exames para um paciente.");
        final var exameCadastrado = cadastrarExameService.cadastrarExames(examesCadastrados);
        log.info("Fim da solicitação para cadastrar exames para um paciente.");
        return exameCadastrado;
    }

    @PostMapping("/processar-exames-paciente")
    public Mono<ClienteDto> processarExamesPaciente(@RequestBody final ClienteDto clienteDto) {
        log.info("Início da solicitação para processar exames para um paciente.");
        final var resultadoDosExames = processamentoExamesService.processarExames(clienteDto);
        log.info("Fim da solicitação para processar exames para um paciente.");
        return resultadoDosExames;
    }

}
