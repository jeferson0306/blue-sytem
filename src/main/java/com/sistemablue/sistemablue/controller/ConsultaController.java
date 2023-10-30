package com.sistemablue.sistemablue.controller;

import com.sistemablue.sistemablue.domain.entities.Atendimento;
import com.sistemablue.sistemablue.domain.entities.Cliente;
import com.sistemablue.sistemablue.domain.model.ClienteDTO;
import com.sistemablue.sistemablue.domain.model.ConsultaMedicaDTO;
import com.sistemablue.sistemablue.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping("/{cpf}/cadastrar-consulta")
    public ResponseEntity<Cliente> cadastrarConsultaMedica(@RequestBody final ConsultaMedicaDTO consultaMedicaDTO, final ClienteDTO clienteDTO) {

        log.info("Início da solicitação para consulta médica para o paciente com o cpf {}", clienteDTO.getCpf());

        final var consulta = consultaService.realizarConsultaMedica(consultaMedicaDTO, clienteDTO);

        log.info("Fim da solicitação para consulta médica para o paciente com o cpf {}", clienteDTO.getCpf());

        return new ResponseEntity<>(consulta, HttpStatus.CREATED);
    }

    @GetMapping("/{cpf}/consultar-atendimentos")
    public List<Atendimento> buscarAtendimentosPorCpfCliente(@PathVariable final String cpf) {

        log.info("Início da solicitação para buscar atendimentos do cliente com CPF: [{}]", cpf);

        final var atendimentos = consultaService.buscarAtendimentosPorCliente(cpf);

        log.info("Fim da solicitação para buscar atendimentos do cliente com CPF: [{}]", cpf);

        return atendimentos;
    }

}
