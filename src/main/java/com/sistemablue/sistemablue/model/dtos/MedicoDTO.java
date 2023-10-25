package com.sistemablue.sistemablue.model.dtos;

import com.sistemablue.sistemablue.model.entities.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {

    private String nome;
    private String crm;
    private List<Especialidade> especialidade;
    private Date dataCadastro;
    private Date dataAtualizacao;

}
