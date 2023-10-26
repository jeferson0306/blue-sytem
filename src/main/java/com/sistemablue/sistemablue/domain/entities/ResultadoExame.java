package com.sistemablue.sistemablue.domain.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "RESULTADO_EXAME")
public class ResultadoExame {

    @Id
    private ObjectId objectId;
    private String nome;
    private double resultado;
    private String alterado;
    private String valorDeReferencia;
    private String unidade;
    private String observacao;
    private Date dataRealizacaoExame;

}
