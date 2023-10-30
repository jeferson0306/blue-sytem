package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.domain.entities.Cliente;
import com.sistemablue.sistemablue.domain.model.ClienteDTO;
import com.sistemablue.sistemablue.repository.ClienteRepository;
import com.sistemablue.sistemablue.util.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private static Cliente preencherNovoCliente(ClienteDTO clienteDTO) {
        final var novoCliente = new Cliente();
        novoCliente.setNome(clienteDTO.getNome());
        novoCliente.setCpf(clienteDTO.getCpf());
        novoCliente.setRg(clienteDTO.getRg());
        novoCliente.setGenero(clienteDTO.getGenero());
        novoCliente.setDataNascimento(clienteDTO.getDataNascimento());
        novoCliente.setEmail(clienteDTO.getEmail());
        novoCliente.setTelefone(clienteDTO.getTelefone());
        novoCliente.setEndereco(clienteDTO.getEndereco());
        novoCliente.setDataCadastro(new Date());
        novoCliente.setDataAtualizacao(new Date());
        novoCliente.setAtendimentos(null);
        return novoCliente;
    }

    @Cacheable("buscar-cpf")
    public Mono<Cliente> buscarClientePorCpf(final String cpf) {
        log.info("Buscando cliente por CPF: [{}]", cpf);
        final var documentoValido = String.valueOf(DocumentoValidator.isCpf(cpf));
        log.info("Busca finalizada para o CPF [{}] com validacao = [{}]", cpf, documentoValido);
        return clienteRepository.findByCpf(cpf);
    }

    public Mono<Cliente> buscarClientePorId(final ObjectId objectId) {
        log.info("Buscando cliente por ID: [{}]", objectId);
        final var cliente = clienteRepository.findClienteByObjectId(objectId);
        log.info("Busca finalizada para o ID [{}]", objectId);
        return cliente;
    }

    public Mono<Cliente> buscarClientesPorNome(final String nome) {
        log.info("Buscando clientes por nome: [{}]", nome);
        final var nomeValido = NomeValidator.isNome(nome);
        log.info("Busca finalizada para o nome [{}] com validacao = [{}]", nome, nomeValido);
        return clienteRepository.findByNome(nome);
    }

    public Mono<Cliente> buscarClientePorRg(final String rg) {
        log.info("Buscando clientes por rg: [{}]", rg);
        final var rgValido = DocumentoValidator.isRgValido(rg);
        log.info("Busca finalizada para o rg [{}] com validacao = [{}]", rg, rgValido);
        return clienteRepository.findByRg(rg);
    }

    public Mono<Cliente> buscarClientePorEmail(final String email) {
        log.info("Buscando clientes por e-mail: [{}]", email);
        final var emailValido = EmailValidator.isEmail(email);
        log.info("Busca finalizada para o e-mail [{}] com validacao = [{}]", email, emailValido);
        return clienteRepository.findByEmail(email);
    }

    public Mono<Cliente> buscarClientePorCidade(final String cidade) {
        log.info("Buscando clientes por cidade: [{}]", cidade);
        final var cidadeValida = clienteRepository.findByEndereco(cidade);
        log.info("Busca finalizada para a cidade [{}] com validacao = [{}]", cidade, cidadeValida);
        return cidadeValida;
    }

    public Mono<Cliente> buscarClientePorNumeroTelefone(final String numero) {
        log.info("Buscando clientes por número de telefone: [{}]", numero);
        final var telefoneValido = String.valueOf(TelefoneValidator.isTelefone(numero));
        log.info("Busca finalizada para o número de telefone [{}] com validacao = [{}]", numero, telefoneValido);
        return clienteRepository.findByTelefone(numero);
    }

    public Mono<Cliente> buscarClientePorDataNascimento(final String dataNascimento) {
        log.info("Buscando clientes por data de nascimento: [{}]", dataNascimento);
        final var dataNascimentoValida = DataValidator.isData(dataNascimento);
        log.info("Busca finalizada para a data de nascimento [{}] com validacao = [{}]", dataNascimento, dataNascimentoValida);
        return clienteRepository.findByDataNascimento(dataNascimento);
    }

    public Mono<Cliente> cadastrarCliente(final ClienteDTO clienteDTO) {

        log.info("Verificando a existência do cliente com o cpf {}", clienteDTO.getCpf());

        return clienteRepository.findByCpf(clienteDTO.getCpf()).flatMap(clienteCadastrado -> {

            log.info("Cliente {} portador do cpf {} já existente na base, atualizando os dados", clienteDTO.getNome(), clienteDTO.getCpf());

            clienteCadastrado.setNome(clienteDTO.getNome());
            clienteCadastrado.setRg(clienteDTO.getRg());
            clienteCadastrado.setGenero(clienteDTO.getGenero());
            clienteCadastrado.setDataNascimento(clienteDTO.getDataNascimento());
            clienteCadastrado.setEmail(clienteDTO.getEmail());
            clienteCadastrado.setTelefone(clienteDTO.getTelefone());
            clienteCadastrado.setEndereco(clienteDTO.getEndereco());
            clienteCadastrado.setDataAtualizacao(new Date());

            log.info("Cliente {} portador do cpf {} atualizado com sucesso", clienteDTO.getNome(), clienteDTO.getCpf());

            return clienteRepository.save(clienteCadastrado).doOnNext(clienteSalvo -> log.info("Cliente {} portador do cpf {} salvo com sucesso", clienteDTO.getNome(), clienteDTO.getCpf()));
        }).switchIfEmpty(Mono.defer(() -> {

            log.info("Cliente {} portador do cpf {} não existente na base, cadastrando os dados", clienteDTO.getNome(), clienteDTO.getCpf());

            final var novoCliente = preencherNovoCliente(clienteDTO);

            log.info("Cliente {} portador do cpf {} cadastrado com sucesso", clienteDTO.getNome(), clienteDTO.getCpf());

            return clienteRepository.save(novoCliente).doOnNext(clienteSalvo -> log.info("Cliente {} portador do cpf {} salvo com sucesso", clienteDTO.getNome(), clienteDTO.getCpf()));
        }));
    }
}
