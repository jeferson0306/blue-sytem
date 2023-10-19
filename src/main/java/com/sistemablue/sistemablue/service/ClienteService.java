package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.model.Cliente;
import com.sistemablue.sistemablue.repository.ClienteRepository;
import com.sistemablue.sistemablue.util.*;
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

    public Mono<Cliente> buscarClientePorCpf(final String cpf) {
        log.info("Buscando cliente por CPF: [{}]", cpf);
        final var documentoValido = String.valueOf(CpfValidator.isCPF(cpf));
        log.info("Busca finalizada para o CPF: [{}]", documentoValido);
        return clienteRepository.findByCpf(cpf);
    }

    public Mono<Cliente> buscarClientePorId(final Long id) {
        log.info("Buscando cliente por ID: [{}]", id);
        final var cliente = clienteRepository.findById(id);
        log.info("Busca finalizada para o ID: [{}]", id);
        return cliente;
    }

    public Flux<Cliente> buscarClientesPorNome(final String nome) {
        log.info("Buscando clientes por nome: [{}]", nome);
        final var nomeValido = NomeValidator.isNomeValido(nome);
        log.info("Busca finalizada para o nome: [{}]", nomeValido);
        return clienteRepository.findByNome(nome);
    }

    public Flux<Cliente> buscarClientePorRg(final String rg) {
        log.info("Buscando clientes por RG: [{}]", rg);
        final var rgValido = RgValidator.isRgValido(rg);
        log.info("Busca finalizada para o rg [{}]", rgValido);
        return clienteRepository.findByRg(rg);
    }

    public Flux<Cliente> buscarClientePorEmail(final String email) {
        log.info("Buscando clientes por e-mail: [{}]", email);
        final var emailValido = EmailValidator.isEmailValido(email);
        log.info("Busca finalizada para o e-mail: [{}]", emailValido);
        return clienteRepository.findByEmailsEmail(email);
    }

    public Flux<Cliente> buscarClientePorCidade(final String cidade) {
        log.info("Buscando clientes por cidade: [{}]", cidade);
        final var cliente = clienteRepository.findByEnderecosCidade(cidade);
        log.info("Busca finalizada para a cidade: [{}]", cidade);
        return cliente;
    }

    public Flux<Cliente> buscarClientePorNumeroTelefone(final String numero) {
        log.info("Buscando clientes por número de telefone: [{}]", numero);
        final var telefone = String.valueOf(TelefoneValidator.isTelefoneValido(numero));
        log.info("Busca finalizada para o número de telefone: [{}]", telefone);
        return clienteRepository.findByTelefonesNumero(telefone);
    }

    public Flux<Cliente> buscarClientePorDataNascimento(final String dataNascimento) {
        log.info("Buscando clientes por data de nascimento: [{}]", dataNascimento);
        final var dataNascimentoValida = DataNascimentoValidator.isDataNascimentoValida(dataNascimento);
        log.info("Busca finalizada para a data de nascimento: [{}]", dataNascimentoValida);
        return clienteRepository.findByDataNascimento(dataNascimento);
    }

    public Mono<Cliente> cadastrarNovoCliente(final Cliente cliente) {
        log.info("Cadastrando um novo cliente: [{}]", cliente.getNome());
        final var clienteCadastrado = clienteRepository.save(cliente);
        log.info("Cliente cadastrado com sucesso: [{}]", cliente.getNome());
        return clienteCadastrado;
    }

}
