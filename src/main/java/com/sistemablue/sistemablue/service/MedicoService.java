package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.model.dtos.MedicoDTO;
import com.sistemablue.sistemablue.model.entities.Cliente;
import com.sistemablue.sistemablue.model.entities.Especialidade;
import com.sistemablue.sistemablue.model.entities.Medico;
import com.sistemablue.sistemablue.repository.MedicoRepository;
import com.sistemablue.sistemablue.util.NomeValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public Mono<Medico> buscarMedicoPorNome(final String nome) {
        log.info("Buscando medico pelo nome [{}]", nome);
        final var nomeValido = String.valueOf(NomeValidator.isNomeValido(nome));
        log.info("Busca finalizada para o medico [{}]", nome);
        return medicoRepository.findMedicoByNome(nomeValido);
    }

    public Mono<Medico> buscarMedicoPorCrm(final String crm) {
        log.info("Buscando medico pelo crm [{}]", crm);
        final var medicoCrm = medicoRepository.findMedicoByCrm(crm);
        log.info("Busca finalizada para o crm [{}]", crm);
        return medicoCrm;
    }

    public Mono<Medico> buscarMedicoPorObjectId(final ObjectId objectId) {
        log.info("Buscando medico pelo nome [{}]", objectId);
        final var medicoObjectId = medicoRepository.findMedicoByObjectId(objectId);
        log.info("Busca finalizada para o medico [{}]", objectId);
        return medicoObjectId;
    }

    public Mono<Medico> cadastrarMedico(final MedicoDTO medicoDTO) {

        log.info("Iniciando cadastro do médico {} com os dados {}", medicoDTO.getNome(), medicoDTO);

        final var medico = new Medico();
        medico.setNome(medicoDTO.getNome());
        medico.setCrm(medicoDTO.getCrm());
        medico.setEspecialidade(medicoDTO.getEspecialidade());
        medico.setDataCadastro(new Date());

        final var medicoCadastrado = medicoRepository.save(medico);

        log.info("Cadastro finalizado para o médico {} com os dados {}", medico.getNome(), medicoDTO);

        return medicoCadastrado;
    }


}
