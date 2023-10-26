package com.sistemablue.sistemablue.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class EspecialidadeDTO {

    private String nome;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
