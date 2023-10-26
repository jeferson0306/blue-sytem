package com.sistemablue.sistemablue.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class EmailDTO {

    private String emailCliente;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
