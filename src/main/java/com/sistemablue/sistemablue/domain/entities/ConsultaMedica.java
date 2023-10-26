package com.sistemablue.sistemablue.domain.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "CONSULTA_MEDICA")
public class ConsultaMedica {

    @Id
    private ObjectId objectId;
    private String tipoAtendimento;
    private Medico medico;
    private String cid;
    private String observacoes;
    private Date dataConsulta;

}
