package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.model.entities.Cliente;
import com.sistemablue.sistemablue.repository.ClienteRepository;
import com.sistemablue.sistemablue.util.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Mono<Cliente> buscarClientePorCpf(final String cpf) {
        log.info("Buscando cliente por CPF: [{}]", cpf);
        final var documentoValido = String.valueOf(CpfValidator.isCPF(cpf));
        log.info("Busca finalizada para o CPF [{}] com validacao = [{}]", cpf, documentoValido);
        return clienteRepository.findClienteByCpf(cpf);
    }

    public Mono<Cliente> buscarClientePorId(final ObjectId objectId) {
        log.info("Buscando cliente por ID: [{}]", objectId);
        final var cliente = clienteRepository.findClienteByObjectId(objectId);
        log.info("Busca finalizada para o ID [{}]", objectId);
        return cliente;
    }


    public Mono<Cliente> buscarClientesPorNome(final String nome) {
        log.info("Buscando clientes por nome: [{}]", nome);
        final var nomeValido = NomeValidator.isNomeValido(nome);
        log.info("Busca finalizada para o nome [{}] com validacao = [{}]", nome, nomeValido);
        return clienteRepository.findClienteByNome(nome);
    }

    public Mono<Cliente> buscarClientePorRg(final String rg) {
        log.info("Buscando clientes por rg: [{}]", rg);
        final var rgValido = RgValidator.isRgValido(rg);
        log.info("Busca finalizada para o rg [{}] com validacao = [{}]", rg, rgValido);
        return clienteRepository.findClienteByRg(rg);
    }

    public Mono<Cliente> buscarClientePorEmail(final String email) {
        log.info("Buscando clientes por e-mail: [{}]", email);
        final var emailValido = EmailValidator.isEmailValido(email);
        log.info("Busca finalizada para o e-mail [{}] com validacao = [{}]", email, emailValido);
        return clienteRepository.findClienteByEmailEmailCliente(email);
    }

    public Mono<Cliente> buscarClientePorCidade(final String cidade) {
        log.info("Buscando clientes por cidade: [{}]", cidade);
        final var cidadeValida = clienteRepository.findClienteByEnderecoCidade(cidade);
        log.info("Busca finalizada para a cidade [{}] com validacao = [{}]", cidade, cidadeValida);
        return cidadeValida;
    }

    public Mono<Cliente> buscarClientePorNumeroTelefone(final String numero) {
        log.info("Buscando clientes por número de telefone: [{}]", numero);
        final var telefoneValido = String.valueOf(TelefoneValidator.isTelefoneValido(numero));
        log.info("Busca finalizada para o número de telefone [{}] com validacao = [{}]", numero, telefoneValido);
        return clienteRepository.findClienteByTelefoneNumero(numero);
    }

    public Mono<Cliente> buscarClientePorDataNascimento(final String dataNascimento) {
        log.info("Buscando clientes por data de nascimento: [{}]", dataNascimento);
        final var dataNascimentoValida = DataValidator.isDataNascimentoValida(dataNascimento);
        log.info("Busca finalizada para a data de nascimento [{}] com validacao = [{}]", dataNascimento, dataNascimentoValida);
        return clienteRepository.findClienteByDataNascimento(dataNascimento);
    }

    public Mono<Cliente> cadastrarNovoCliente(final Cliente cliente) {
        log.info("Cadastrando um novo cliente: [{}]", cliente.getNome());
        final var clienteCadastrado = clienteRepository.save(cliente);
        log.info("Cliente cadastrado com sucesso [{}] com validacao = [{}]", cliente.getNome(), clienteCadastrado);
        return clienteCadastrado;
    }

}
