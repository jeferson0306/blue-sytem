package com.sistemablue.sistemablue.model.exame;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class ExamesCadastrados {

    @Id
    private ObjectId objectId;
    private Long codigo;
    private String nome;
    private String amostra;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
