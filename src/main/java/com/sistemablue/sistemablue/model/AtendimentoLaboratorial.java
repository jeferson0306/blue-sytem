package com.sistemablue.sistemablue.model;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "AtendimentoLaboratorial")
public class AtendimentoLaboratorial {

    @Id
    private ObjectId objectId;
    private String tipoAtendimento;
    private String observacoes;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
