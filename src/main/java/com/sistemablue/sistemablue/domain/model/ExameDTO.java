package com.sistemablue.sistemablue.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class ExameDTO {

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

}
