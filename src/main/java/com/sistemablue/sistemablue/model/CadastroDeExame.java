package com.sistemablue.sistemablue.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@Document(collection = "Exame")
public class CadastroDeExame {

    @Id
    private ObjectId objectId;
    private Long codigo;
    private String codigoUnimed;
    private String codigoTiss;
    private String nome;
    private String amostra;
    private String unidade;
    private String resultado;
    private String valorDeReferencia;
    private String abreviacaoExame;
    private Boolean alteracao;
    private Date dataRealizacao;
    private Date dataCadastro;
    private Date dataAtualizacao;
    private Unimed unimed;
}
