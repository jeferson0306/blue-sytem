package com.sistemablue.sistemablue.model.exame;

import lombok.Data;

import java.util.Date;

@Data
public class RealizacaoExame {

    private String nomeExame;
    private String amostra;
    private String resultado;
    private Boolean alteracao;
    private String valorDeReferencia;
    private String unidade;
    private Date dataRealizacao;
    private Date dataAtualizacao;

}
