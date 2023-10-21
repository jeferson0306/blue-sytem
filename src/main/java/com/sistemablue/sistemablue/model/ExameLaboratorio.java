package com.sistemablue.sistemablue.model;

import lombok.Data;


@Data
public class ExameLaboratorio {

    private String nome;
    private String amostra;
    private String unidade;
    private String resultado;
    private String valorDeReferencia;
    private Boolean alteracao;

}
