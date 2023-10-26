package com.sistemablue.sistemablue.domain.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "EMAIL")
public class Email {

    @Id
    private ObjectId objectId;
    private String emailCliente;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
