package com.sistemablue.sistemablue.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Atendimento")
public class Atendimento {

    @Id
    private ObjectId objectId;
    private AtendimentoHospitalar atendimentoHospitalar;
    private AtendimentoLaboratorial atendimentoLaboratorial;
    private CadastroDeExame cadastroDeExame;
    private ResultadoDeExame resultadoDeExame;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
