package com.sistemablue.sistemablue.domain.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "ATENDIMENTO")
public class Atendimento {

    @Id
    private ObjectId objectId;
    private Date dataAtendimento;
    private List<ConsultaMedica> consultasMedicas;
    private List<ExameLaboratorial> examesLaboratoriais;

}
