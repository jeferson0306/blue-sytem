package com.sistemablue.sistemablue.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Prazo")
public class Prazo {

    private String executora;
    private String origem;
    private String total;

}
