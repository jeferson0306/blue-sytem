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

    @GetMapping("/nome/{nome}")
    public Flux<Cliente> buscarClientesPorNome(@PathVariable final String nome) {
        log.info("Recebida solicitação para buscar clientes por nome: [{}]", nome);
        return clienteService.buscarClientesPorNome(nome);
    }

    @GetMapping("/rg/{rg}")
    public Flux<Cliente> buscarClientesPorRg(@PathVariable final String rg) {
        log.info("Recebida solicitação para buscar clientes por RG: [{}]", rg);
        return clienteService.buscarClientesPorRg(rg);
    }

    @GetMapping("/email/{email}")
    public Flux<Cliente> buscarClientesPorEmail(@PathVariable final String email) {
        log.info("Recebida solicitação para buscar clientes por e-mail: [{}]", email);
        return clienteService.buscarClientesPorEmail(email);
    }

    @GetMapping("/cidade/{cidade}")
    public Flux<Cliente> buscarClientesPorCidade(@PathVariable final String cidade) {
        log.info("Recebida solicitação para buscar clientes por cidade: [{}]", cidade);
        return clienteService.buscarClientesPorCidade(cidade);
    }

    @GetMapping("/telefone/{numero}")
    public Flux<Cliente> buscarClientesPorNumeroTelefone(@PathVariable final String numero) {
        log.info("Recebida solicitação para buscar clientes por número de telefone: [{}]", numero);
        return clienteService.buscarClientesPorNumeroTelefone(numero);
    }

    @GetMapping("/dataNascimento/{dataNascimento}")
    public Flux<Cliente> buscarClientesPorDataNascimento(@PathVariable final String dataNascimento) {
        log.info("Recebida solicitação para buscar clientes por data de nascimento: [{}]", dataNascimento);
        return clienteService.buscarClientesPorDataNascimento(dataNascimento);
    }

    @PostMapping("/cadastro")
    public Mono<Cliente> cadastrarNovoCliente(@RequestBody Cliente cliente) {
        log.info("Recebida solicitação para cadastrar um novo cliente.");
        return clienteService.cadastrarNovoCliente(cliente);
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
