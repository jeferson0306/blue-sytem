package com.sistemablue.sistemablue.domain.model;

import com.sistemablue.sistemablue.domain.entities.Endereco;
import com.sistemablue.sistemablue.domain.entities.Especialidade;
import com.sistemablue.sistemablue.domain.entities.Telefone;
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
    private String endereco;
    private String telefone;

}
