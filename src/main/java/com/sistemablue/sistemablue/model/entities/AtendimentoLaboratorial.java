package com.sistemablue.sistemablue.model.entities;


import com.sistemablue.sistemablue.model.exame.ExamesCadastrados;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "ATENDIMENTO_LABORATORIAL")
public class AtendimentoLaboratorial {

    @Id
    private ObjectId objectId;
    private Date dataCadastro;
    private Date dataAtualizacao;
    private List<ExamesCadastrados> examesCadastrados;

}
