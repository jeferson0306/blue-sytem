package com.sistemablue.sistemablue.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "Exame")
public class Exame {

    private Long id;
    private Long codigo;
    private String nome;
    private String amostra;
    private String unidade;
    private String resultado;
    private String valorDeReferencia;
    private String abreviacaoExame;
    private String dataRealizacao;
    private String dataCadastro;
    private Boolean alteracao;

}
