package com.sistemablue.sistemablue.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Telefone")
public class Telefone {

    private Long id;
    private String numero;
    private String tipo;
    private String dataCadastro;

}
