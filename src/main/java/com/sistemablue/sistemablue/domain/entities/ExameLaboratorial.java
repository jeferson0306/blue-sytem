package com.sistemablue.sistemablue.domain.entities;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "EXAME_LABORATORIAL")
public class ExameLaboratorial {

    @Id
    private ObjectId objectId;
    private Long codigo;
    private String nome;
    private String amostra;
    private Date dataCadastroExame;
    private List<ResultadoExame> resultadoExames;
}
