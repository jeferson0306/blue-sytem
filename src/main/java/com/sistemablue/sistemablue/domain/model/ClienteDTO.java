package com.sistemablue.sistemablue.domain.model;

import com.sistemablue.sistemablue.domain.entities.Atendimento;
import com.sistemablue.sistemablue.domain.entities.Email;
import com.sistemablue.sistemablue.domain.entities.Endereco;
import com.sistemablue.sistemablue.domain.entities.Telefone;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ClienteDTO {

    private String nome;
    private String cpf;
    private String rg;
    private String genero;
    private String dataNascimento;
    private Date dataCadastro;
    private Date dataAtualizacao;
    private Email email;
    private Telefone telefone;
    private Endereco endereco;
    private List<Atendimento> atendimento;

}
