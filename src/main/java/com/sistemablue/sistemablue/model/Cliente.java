package com.sistemablue.sistemablue.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Cliente")
public class Cliente {

    @Id
    private ObjectId objectId;
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String genero;
    private String dataNascimento;
    private String dataCadastro;
    private List<Email> emails;
    private List<Telefone> telefones;
    private List<Endereco> enderecos;
    private List<Exame> exames;
    private Atendimento atendimento;

}
