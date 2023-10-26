package com.sistemablue.sistemablue.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class TelefoneDTO {

    private String numero;
    private String tipo;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
