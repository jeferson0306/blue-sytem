package com.sistemablue.sistemablue.model.exame;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoDeExame {

    @Id
    private ObjectId objectId;
    private String nome;
    private double resultado;
    private String unidade;
    private String flag;
    private String observacao;
    private Date dataRealizacao;

}
