package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.domain.entities.Atendimento;
import com.sistemablue.sistemablue.domain.entities.Cliente;
import com.sistemablue.sistemablue.domain.entities.ConsultaMedica;
import com.sistemablue.sistemablue.domain.model.ClienteDTO;
import com.sistemablue.sistemablue.domain.model.ConsultaMedicaDTO;
import com.sistemablue.sistemablue.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class AtendimentoMedicoService {

    private final ClienteRepository clienteRepository;

    public Mono<Cliente> realizarConsultaMedica(final ConsultaMedicaDTO consultaMedicaDTO, final ClienteDTO clienteDTO) {

        log.info("Iniciando solicitação de consulta médica para o cpf {}", clienteDTO.getCpf());

        return clienteRepository.findByCpf(clienteDTO.getCpf()).flatMap(cliente -> {

            log.info("Cliente cpf {} encontrado na base, criando nova consulta médica", clienteDTO.getCpf());

            final var consulta = new ConsultaMedica();
            final var novoAtendimento = new Atendimento();

            consulta.setTipoAtendimento(consultaMedicaDTO.getTipoAtendimento());
            consulta.setMedico(consultaMedicaDTO.getMedico());
            consulta.setCid(consultaMedicaDTO.getCid());
            consulta.setObservacoes(consultaMedicaDTO.getObservacoes());
            consulta.setDataConsulta(consultaMedicaDTO.getDataConsulta());

            novoAtendimento.setConsultaMedica(new ArrayList<>());
            novoAtendimento.getConsultaMedica().add(consulta);

            cliente.getAtendimento().add(novoAtendimento);

            return clienteRepository.save(cliente);

        }).doOnNext(savedClient -> log.info("Consulta médica cadastrada com sucesso para o cliente cpf {}", clienteDTO.getCpf()));
    }
}
