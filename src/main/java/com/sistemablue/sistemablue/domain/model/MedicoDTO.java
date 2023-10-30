package com.sistemablue.sistemablue.domain.model;

import com.sistemablue.sistemablue.domain.entities.Especialidade;
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
    private String telefone;
    private String endereco;
    private String genero;
    private List<Especialidade> especialidade;
    private Date dataDeInscricao;
    private Date dataCadastroNaBase;
    private Date dataAtualizacaoNaBase;

}

