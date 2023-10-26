package com.sistemablue.sistemablue.domain.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "TELEFONE")
public class Telefone {

    @Id
    private ObjectId objectId;
    private String numero;
    private String tipo;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
