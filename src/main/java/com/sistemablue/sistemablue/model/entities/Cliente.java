package com.sistemablue.sistemablue.model.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "CLIENTE")
public class Cliente {

    @Id
    private ObjectId objectId;
    private String nome;
    private String cpf;
    private String rg;
    private String genero;
    private String dataNascimento;
    private Date dataCadastro;
    private Email email;
    private Telefone telefone;
    private Endereco endereco;
    private AtendimentoPaciente atendimentoPaciente;

}
