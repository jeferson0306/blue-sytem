package com.sistemablue.sistemablue.model.exame;

import com.sistemablue.sistemablue.model.procedimentos.TabelaProcedimentos;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class ExamesCadastrados {

    @Id
    private ObjectId objectId;
    private Long codigo;
    private String nome;
    private String amostra;
    private String unidade;
    private Date dataCadastro;
    private Date dataRealizacao;
    private Date dataAtualizacao;
    private TabelaProcedimentos tabelaProcedimentos;

}
