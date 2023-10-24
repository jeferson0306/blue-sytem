package com.sistemablue.sistemablue.model.cliente;

import com.sistemablue.sistemablue.model.entities.AtendimentoPaciente;
import com.sistemablue.sistemablue.model.entities.Email;
import com.sistemablue.sistemablue.model.entities.Endereco;
import com.sistemablue.sistemablue.model.entities.Telefone;
import lombok.Data;

import java.util.Date;

@Data
public class ClienteDto {

    private String nome;
    private String cpf;
    private String rg;
    private String genero;
    private String dataNascimento;
    private Date dataCadastro;
    private Email email;
    private Telefone telefone;
    private Endereco endereco;
    private AtendimentoPaciente atendimentoPaciente;

}
