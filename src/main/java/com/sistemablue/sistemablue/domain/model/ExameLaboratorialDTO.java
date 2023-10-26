package com.sistemablue.sistemablue.domain.model;

import com.sistemablue.sistemablue.domain.entities.ResultadoExame;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ExameLaboratorialDTO {

    private Long codigo;
    private String nome;
    private String amostra;
    private Date dataCadastroExame;
    private List<ResultadoExame> resultadoExames;
}
