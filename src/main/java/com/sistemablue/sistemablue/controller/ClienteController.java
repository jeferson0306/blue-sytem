package com.sistemablue.sistemablue.controller;

import com.sistemablue.sistemablue.exception.ClienteNotFoundException;
import com.sistemablue.sistemablue.model.Cliente;
import com.sistemablue.sistemablue.model.Exame;
import com.sistemablue.sistemablue.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/cpf/{cpf}")
    public Mono<Cliente> buscarClientePorCpf(@PathVariable final String cpf) {
        log.info("Recebida solicitação para buscar cliente por CPF: [{}]", cpf);
        return clienteService.buscarClientePorCpf(cpf);
    }

    @GetMapping("/id/{id}")
    public Mono<Cliente> buscarClientePorId(@PathVariable final Long id) {
        log.info("Recebida solicitação para buscar cliente por ID: [{}]", id);
        return clienteService.buscarClientePorId(id);
    }

    @GetMapping("/todos")
    public Flux<Cliente> buscarTodosClientes() {
        log.info("Buscando todos os clientes");
        return clienteService.buscarTodosClientes();
    }

    @GetMapping("/{clienteId}/exames")
    public Flux<Exame> buscarExamesDoCliente(@PathVariable final Long clienteId) {
        log.info("Buscando exames do cliente: [{}]", clienteId);
        return clienteService.buscarExamesDoCliente(clienteId);
    }

    @ExceptionHandler(ClienteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleClienteNotFoundException(ClienteNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        final var errorMessage = "ID inválido: " + ex.getValue();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
