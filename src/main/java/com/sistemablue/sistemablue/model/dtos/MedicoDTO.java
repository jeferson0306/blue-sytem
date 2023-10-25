package com.sistemablue.sistemablue.model.dtos;

import com.sistemablue.sistemablue.model.entities.Endereco;
import com.sistemablue.sistemablue.model.entities.Especialidade;
import com.sistemablue.sistemablue.model.entities.Telefone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {

    private String nome;
    private String crm;
    private List<Especialidade> especialidade;
    private Date dataCadastroNaBase;
    private Date dataAtualizacaoNaBase;
    private Date dataDeInscricao;
    private Endereco endereco;
    private Telefone telefone;

}
