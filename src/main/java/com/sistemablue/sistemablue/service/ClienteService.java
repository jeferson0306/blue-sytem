package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.exception.ClienteNotFoundException;
import com.sistemablue.sistemablue.model.Cliente;
import com.sistemablue.sistemablue.model.Exame;
import com.sistemablue.sistemablue.repository.ClienteRepository;
import com.sistemablue.sistemablue.repository.ExameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Mono<Cliente> buscarClientePorCpf(String cpf) {
        log.info("Buscando cliente por CPF: [{}]", cpf);
        return clienteRepository.findByCpf(cpf)
                .switchIfEmpty(Mono.error(new ClienteNotFoundException(cpf)));
    }

    public Mono<Cliente> buscarClientePorId(Long id) {
        log.info("Buscando cliente por ID: [{}]", id);
        return clienteRepository.findById(id)
                .switchIfEmpty(Mono.error(new ClienteNotFoundException(id.toString())));
    }

    public Flux<Cliente> buscarClientesPorNome(String nome) {
        log.info("Buscando clientes por nome: [{}]", nome);
        return clienteRepository.findByNome(nome);
    }

    public Flux<Cliente> buscarClientesPorRg(String rg) {
        log.info("Buscando clientes por RG: [{}]", rg);
        return clienteRepository.findByRg(rg);
    }

    public Flux<Cliente> buscarClientesPorEmail(String email) {
        log.info("Buscando clientes por e-mail: [{}]", email);
        return clienteRepository.findByEmailsEmail(email);
    }

    public Flux<Cliente> buscarClientesPorCidade(String cidade) {
        log.info("Buscando clientes por cidade: [{}]", cidade);
        return clienteRepository.findByEnderecosCidade(cidade);
    }

    public Flux<Cliente> buscarClientesPorNumeroTelefone(String numero) {
        log.info("Buscando clientes por número de telefone: [{}]", numero);
        return clienteRepository.findByTelefonesNumero(numero);
    }

    public Flux<Cliente> buscarClientesPorDataNascimento(String dataNascimento) {
        log.info("Buscando clientes por data de nascimento: [{}]", dataNascimento);
        return clienteRepository.findByDataNascimento(dataNascimento);
    }

    public Mono<Cliente> cadastrarNovoCliente(Cliente cliente) {
        log.info("Cadastrando um novo cliente: [{}]", cliente.getNome());
        return clienteRepository.save(cliente);
    }

}
