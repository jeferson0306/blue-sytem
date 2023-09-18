package com.sistemablue.sistemablue.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "SaoFranciscoSaude")
public class SaoFranciscoSaude {

    private Long id;
    private String exame;

}
