package com.sistemablue.sistemablue.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class EnderecoDTO {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private String complemento;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
