package com.sistemablue.sistemablue.model.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Bensaude")
public class Bensaude {

    private Long id;
    private String exame;

}
