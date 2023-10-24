package com.sistemablue.sistemablue.model.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Telefone")
public class Telefone {

    @Id
    private ObjectId objectId;
    private String numero;
    private String tipo;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
