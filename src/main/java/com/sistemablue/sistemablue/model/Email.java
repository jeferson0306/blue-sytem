package com.sistemablue.sistemablue.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "Email")
public class Email {

    private UUID id;
    private String email;
    private String dataCadastro;

}
