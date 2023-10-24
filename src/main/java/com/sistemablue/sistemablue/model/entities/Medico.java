package com.sistemablue.sistemablue.model.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Medico")
public class Medico {

    @Id
    private ObjectId objectId;
    private String nome;
    private String crm;
    private Especialidade especialidade;
    private Date dataCadastro;
    private Date dataAtualizacao;
}
