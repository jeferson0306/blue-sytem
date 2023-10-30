package com.sistemablue.sistemablue.controller;

import com.sistemablue.sistemablue.domain.entities.Cliente;
import com.sistemablue.sistemablue.domain.model.ClienteDTO;
import com.sistemablue.sistemablue.domain.model.ConsultaMedicaDTO;
import com.sistemablue.sistemablue.service.ConsultaMedicaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/consultas")
public class ConsultaController {

    private final ConsultaMedicaService consultaMedicaService;

    @PostMapping("/{cpf}/registrar-consulta")
    public ResponseEntity<Cliente> registrarConsultaMedica(@RequestBody final ConsultaMedicaDTO consultaMedicaDTO, final ClienteDTO clienteDTO) {

        log.info("Início da solicitação para consulta médica para o paciente com o cpf {}", clienteDTO.getCpf());

        final var consulta = consultaMedicaService.realizarConsultaMedica(consultaMedicaDTO, clienteDTO);

        log.info("Fim da solicitação para consulta médica para o paciente com o cpf {}", clienteDTO.getCpf());

        return new ResponseEntity<>(consulta, HttpStatus.CREATED);
    }

}