package com.sistemablue.sistemablue.model.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "MEDICO")
public class Medico {

    @Id
    private ObjectId objectId;
    private String nome;
    private String crm;
    private List<Especialidade> especialidade;
    private Date dataCadastroNaBase;
    private Date dataAtualizacaoNaBase;
    private Date dataDeInscricao;
    private Endereco endereco;
    private Telefone telefone;
}
