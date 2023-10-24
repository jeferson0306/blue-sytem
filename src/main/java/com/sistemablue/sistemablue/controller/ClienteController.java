package com.sistemablue.sistemablue.controller;

import com.sistemablue.sistemablue.model.entities.Cliente;
import com.sistemablue.sistemablue.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/cpf/{cpf}")
    public Mono<Cliente> buscarClientePorCpf(@PathVariable final String cpf) {
        log.info("Início da solicitação para buscar cliente por CPF: [{}]", cpf);
        final var cliente = clienteService.buscarClientePorCpf(cpf);
        log.info("Fim da solicitação para buscar cliente por CPF: [{}]", cpf);
        return cliente;
    }

    @GetMapping("/objectId/{objectId}")
    public Mono<Cliente> buscarClientePorId(@PathVariable final ObjectId objectId) {
        log.info("Início da solicitação para buscar cliente por ID: [{}]", objectId);
        final var clienteretorno = clienteService.buscarClientePorId(objectId);
        log.info("Fim da solicitação para buscar cliente por ID: [{}]", objectId);
        return clienteretorno;
    }

    @GetMapping("/nome/{nome}")
    public Mono<Cliente> buscarClientePorNome(@PathVariable final String nome) {
        log.info("Início da solicitação para buscar clientes por nome: [{}]", nome);
        final var clientes = clienteService.buscarClientesPorNome(nome);
        log.info("Fim da solicitação para buscar clientes por nome: [{}]", nome);
        return clientes;
    }

    @GetMapping("/rg/{rg}")
    public Mono<Cliente> buscarClientesPorRg(@PathVariable final String rg) {
        log.info("Início da solicitação para buscar clientes por RG: [{}]", rg);
        final var clientes = clienteService.buscarClientePorRg(rg);
        log.info("Fim da solicitação para buscar clientes por RG: [{}]", rg);
        return clientes;
    }

    @GetMapping("/email/{email}")
    public Mono<Cliente> buscarClientesPorEmail(@PathVariable final String email) {
        log.info("Início da solicitação para buscar clientes por e-mail: [{}]", email);
        final var clientes = clienteService.buscarClientePorEmail(email);
        log.info("Fim da solicitação para buscar clientes por e-mail: [{}]", email);
        return clientes;
    }

    @GetMapping("/cidade/{cidade}")
    public Mono<Cliente> buscarClientesPorCidade(@PathVariable final String cidade) {
        log.info("Início da solicitação para buscar clientes por cidade: [{}]", cidade);
        final var clientes = clienteService.buscarClientePorCidade(cidade);
        log.info("Fim da solicitação para buscar clientes por cidade: [{}]", cidade);
        return clientes;
    }

    @GetMapping("/telefone/{numero}")
    public Mono<Cliente> buscarClientesPorNumeroTelefone(@PathVariable final String numero) {
        log.info("Início da solicitação para buscar clientes por número de telefone: [{}]", numero);
        final var clientes = clienteService.buscarClientePorNumeroTelefone(numero);
        log.info("Fim da solicitação para buscar clientes por número de telefone: [{}]", numero);
        return clientes;
    }

    @GetMapping("/dataNascimento/{dataNascimento}")
    public Mono<Cliente> buscarClientesPorDataNascimento(@PathVariable final String dataNascimento) {
        log.info("Início da solicitação para buscar clientes por data de nascimento: [{}]", dataNascimento);
        final var clientes = clienteService.buscarClientePorDataNascimento(dataNascimento);
        log.info("Fim da solicitação para buscar clientes por data de nascimento: [{}]", dataNascimento);
        return clientes;
    }

    @PostMapping("/cadastro")
    public Mono<Cliente> cadastrarNovoCliente(@RequestBody Cliente novoCliente) {
        log.info("Início da solicitação para cadastrar um novo cliente.");
        final var cliente = clienteService.cadastrarNovoCliente(novoCliente);
        log.info("Fim da solicitação para cadastrar um novo cliente.");
        return cliente;
    }
}
