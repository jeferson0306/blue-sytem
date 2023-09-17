package com.sistemablue.sistemablue.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Atendimento")
public class Atendimento {

    @Id
    private Long id;
    private Long clienteId;
    private String dataAtendimento;
    private String tipoAtendimento;
    private String observacoes;

}
