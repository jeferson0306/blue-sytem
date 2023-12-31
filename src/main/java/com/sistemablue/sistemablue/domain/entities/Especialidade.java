package com.sistemablue.sistemablue.domain.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "ESPECIALIDADE")
public class Especialidade {

    @Id
    private ObjectId objectId;
    private String nome;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
