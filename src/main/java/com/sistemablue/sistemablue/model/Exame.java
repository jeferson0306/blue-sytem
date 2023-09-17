package com.sistemablue.sistemablue.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "Exame")
public class Exame {

    private Long id;
    private String nome;
    private String dataRealizacao;
    private String resultado;

}
