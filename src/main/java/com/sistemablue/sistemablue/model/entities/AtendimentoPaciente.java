package com.sistemablue.sistemablue.model.entities;

import com.sistemablue.sistemablue.model.exame.ResultadoDeExame;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "ATENDIMENTO_PACIENTE")
public class AtendimentoPaciente {

    @Id
    private ObjectId objectId;
    private AtendimentoHospitalar atendimentoHospitalar;
    private AtendimentoLaboratorial atendimentoLaboratorial;
    private ResultadoDeExame resultadoDeExame;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
