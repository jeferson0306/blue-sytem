package com.sistemablue.sistemablue.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class ResultadoExameDTO {

    private String nome;
    private double resultado;
    private String alterado;
    private String valorDeReferencia;
    private String unidade;
    private String observacao;
    private Date dataRealizacaoExame;

}
