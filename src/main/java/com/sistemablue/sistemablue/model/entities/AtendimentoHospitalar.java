package com.sistemablue.sistemablue.model.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "ATENDIMENTO_HOSPITALAR")
public class AtendimentoHospitalar {

    @Id
    private ObjectId objectId;
    private String tipoAtendimento;
    private Medico medico;
    private String observacoes;
    private Date dataCadastro;
    private Date dataAtualizacao;
}
