package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.domain.entities.Medico;
import com.sistemablue.sistemablue.domain.model.MedicoDTO;
import com.sistemablue.sistemablue.repository.MedicoRepository;
import com.sistemablue.sistemablue.util.NomeValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
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

    public Flux<Medico> buscarMedicosPorParteDoNome(final String parteDoNome) {

        log.info("Buscando médicos por parte do nome [{}]", parteDoNome);

        if (parteDoNome == null || parteDoNome.isEmpty()) {
            return Flux.error(new RuntimeException("O nome não pode estar vazia."));
        }

        final var regex = ".*" + parteDoNome + ".*";
        final var medicos = medicoRepository.findAllByNomeRegex(regex);

        log.info("Busca finalizada para a parte do nome [{}]", parteDoNome);
        return medicos;
    }


    public Mono<Medico> cadastrarMedico(final MedicoDTO medicoDTO) {

        log.info("Iniciando cadastro do médico {} com os dados {}", medicoDTO.getNome(), medicoDTO);

        final var medico = new Medico();

        if (medicoDTO.getTelefone() == null || medicoDTO.getEndereco() == null) {
            log.info("Exibição não autorizada pelo médico");
            medico.setEspecialidade(null);
            medico.setTelefone(null);
        }

        medico.setNome(medicoDTO.getNome());
        medico.setCrm(medicoDTO.getCrm());
        medico.setEspecialidade(medicoDTO.getEspecialidade());
        medico.setDataCadastroNaBase(new Date());
        medico.setDataAtualizacaoNaBase(new Date());
        medico.setDataDeInscricao(medicoDTO.getDataDeInscricao());
        medico.setEndereco(medicoDTO.getEndereco());
        medico.setTelefone(medicoDTO.getTelefone());

        final var medicoCadastrado = medicoRepository.save(medico);

        log.info("Cadastro finalizado para o médico {} com os dados", medico.getNome());

        return medicoCadastrado;
    }
}
