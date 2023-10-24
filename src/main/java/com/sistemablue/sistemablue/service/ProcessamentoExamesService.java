package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.model.cliente.ClienteDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessamentoExamesService {

    private static final String BILIRRUBINA = "bilirrubina";
    private static final String BILIRRUBINA_TOTAL = "bilirrubinaTotal";
    private static final String BILIRRUBINA_DIRETA = "bilirrubinaDireta";
    private static final String BILIRRUBINA_INDIRETA = "bilirrubinaIndireta";
    private static final String ALTO = "alto";
    private static final String NORMAL = "normal";
    private static final String BAIXO = "baixo";

    public Mono<ClienteDto> processarExames(final ClienteDto clienteDto) {
        log.info("Processamento exames para o paciente: [{}]", clienteDto.getNome());
        final var resultadoDoProcessamento = processarExamesCadastrados(clienteDto);
        log.info("Exames cadastrados para o paciente: [{}]", clienteDto.getNome());
        return resultadoDoProcessamento;
    }

    private Mono<ClienteDto> processarExamesCadastrados(final ClienteDto clienteDto) {

        ClienteDto cliente = new ClienteDto();
        cliente.getAtendimentoPaciente().getAtendimentoLaboratorial().getExamesCadastrados().getNome();

        if (clienteDto.getAtendimentoPaciente().getAtendimentoLaboratorial().getExamesCadastrados().getNome().equals("bilirrubina")) {
            clienteDto.getAtendimentoPaciente().getResultadoDeExame().setResultado(processamentoBilirrubina(clienteDto));
        }

        return Mono.just(clienteDto);
    }

    private String processamentoBilirrubina(final ClienteDto clienteDto) {

    }

}
