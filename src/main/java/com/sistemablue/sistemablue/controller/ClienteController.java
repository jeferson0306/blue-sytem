package com.sistemablue.sistemablue.controller;

import com.sistemablue.sistemablue.model.Cliente;
import com.sistemablue.sistemablue.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
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
        log.info("Início da solicitação para buscar cliente por CPF: [{}]", cpf);
        final var cliente = clienteService.buscarClientePorCpf(cpf);
        log.info("Fim da solicitação para buscar cliente por CPF: [{}]", cpf);
        return cliente;
    }

    @GetMapping("/id/{id}")
    public Mono<Cliente> buscarClientePorId(@PathVariable final Long id) {
        log.info("Início da solicitação para buscar cliente por ID: [{}]", id);
        final var cliente = clienteService.buscarClientePorId(id);
        log.info("Fim da solicitação para buscar cliente por ID: [{}]", id);
        return cliente;
    }

    @GetMapping("/nome/{nome}")
    public Flux<Cliente> buscarClientePorNome(@PathVariable final String nome) {
        log.info("Início da solicitação para buscar clientes por nome: [{}]", nome);
        final var cliente = clienteService.buscarClientesPorNome(nome);
        log.info("Fim da solicitação para buscar clientes por nome: [{}]", nome);
        return cliente;
    }

    @GetMapping("/rg/{rg}")
    public Flux<Cliente> buscarClientesPorRg(@PathVariable final String rg) {
        log.info("Início da solicitação para buscar clientes por RG: [{}]", rg);
        final var cliente = clienteService.buscarClientePorRg(rg);
        log.info("Fim da solicitação para buscar clientes por RG: [{}]", rg);
        return cliente;
    }

    @GetMapping("/email/{email}")
    public Flux<Cliente> buscarClientesPorEmail(@PathVariable final String email) {
        log.info("Início da solicitação para buscar clientes por e-mail: [{}]", email);
        final var cliente = clienteService.buscarClientePorEmail(email);
        log.info("Fim da solicitação para buscar clientes por e-mail: [{}]", email);
        return cliente;
    }

    @GetMapping("/cidade/{cidade}")
    public Flux<Cliente> buscarClientesPorCidade(@PathVariable final String cidade) {
        log.info("Início da solicitação para buscar clientes por cidade: [{}]", cidade);
        final var cliente = clienteService.buscarClientePorCidade(cidade);
        log.info("Fim da solicitação para buscar clientes por cidade: [{}]", cidade);
        return cliente;
    }

    @GetMapping("/telefone/{numero}")
    public Flux<Cliente> buscarClientesPorNumeroTelefone(@PathVariable final String numero) {
        log.info("Início da solicitação para buscar clientes por número de telefone: [{}]", numero);
        final var cliente = clienteService.buscarClientePorNumeroTelefone(numero);
        log.info("Fim da solicitação para buscar clientes por número de telefone: [{}]", numero);
        return cliente;
    }

    @GetMapping("/dataNascimento/{dataNascimento}")
    public Flux<Cliente> buscarClientesPorDataNascimento(@PathVariable final String dataNascimento) {
        log.info("Início da solicitação para buscar clientes por data de nascimento: [{}]", dataNascimento);
        final var cliente = clienteService.buscarClientePorDataNascimento(dataNascimento);
        log.info("Fim da solicitação para buscar clientes por data de nascimento: [{}]", dataNascimento);
        return cliente;
    }

    @PostMapping("/cadastro")
    public Mono<Cliente> cadastrarNovoCliente(@RequestBody Cliente novoCliente) {
        log.info("Início da solicitação para cadastrar um novo cliente.");
        final var cliente = clienteService.cadastrarNovoCliente(novoCliente);
        log.info("Fim da solicitação para cadastrar um novo cliente.");
        return cliente;
    }

}
