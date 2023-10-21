package com.sistemablue.sistemablue.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Endereco")
public class Endereco {

    @Id
    private ObjectId objectId;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private String complemento;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
