package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.domain.entities.Atendimento;
import com.sistemablue.sistemablue.domain.entities.Cliente;
import com.sistemablue.sistemablue.domain.entities.ConsultaMedica;
import com.sistemablue.sistemablue.domain.model.ClienteDTO;
import com.sistemablue.sistemablue.domain.model.ConsultaMedicaDTO;
import com.sistemablue.sistemablue.repository.AtendimentoRepository;
import com.sistemablue.sistemablue.repository.ClienteCadastralRepository;
import com.sistemablue.sistemablue.repository.ClienteConsultasRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final AtendimentoRepository atendimentoRepository;
    private final ClienteCadastralRepository clienteCadastralRepository;
    private final ClienteConsultasRepository clienteConsultasRepository;

    public Cliente realizarConsultaMedica(final ConsultaMedicaDTO consultaMedicaDTO, final ClienteDTO clienteDTO) {

        log.info("Iniciando solicitação de consulta médica para o cpf {}", clienteDTO.getCpf());

        final var cliente = clienteCadastralRepository.findByCpf(clienteDTO.getCpf());

        log.info("Cliente cpf {} encontrado na base, criando nova consulta médica", clienteDTO.getCpf());

        cliente.setAtendimentos(new ArrayList<>());

        final var atendimento = new Atendimento();

        atendimento.setDataAtendimento(new Date());
        atendimento.setConsultasMedicas(new ArrayList<>());
        atendimento.setExamesLaboratoriais(null);

        final var consulta = new ConsultaMedica();

        consulta.setTipoAtendimento(consultaMedicaDTO.getTipoAtendimento());
        consulta.setMedico(consultaMedicaDTO.getMedico());
        consulta.setCid(consultaMedicaDTO.getCid());
        consulta.setObservacoes(consultaMedicaDTO.getObservacoes());
        consulta.setDataConsulta(consultaMedicaDTO.getDataConsulta());

        atendimento.getConsultasMedicas().add(consulta);

        cliente.getAtendimentos().add(atendimento);

        final var clienteSalvo = clienteCadastralRepository.save(cliente);

        log.info("Consulta médica cadastrada com sucesso para o cliente cpf {}", clienteDTO.getCpf());

        return clienteSalvo;
    }

    public List<Atendimento> buscarAtendimentosPorCliente(final String cpf) {

        log.info("Iniciando solicitação para buscar atendimentos do cliente com cpf {}", cpf);

        final var cliente = clienteConsultasRepository.findByCpf(cpf);

        log.info("Cliente com cpf {} encontrado na base, buscando atendimentos", cpf);

        final var atendimentos = atendimentoRepository.findByCliente(cliente);

        log.info("Atendimentos do cliente com cpf {} encontrados na base", cpf);

        return atendimentos;
    }

}
