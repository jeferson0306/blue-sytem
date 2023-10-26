package com.sistemablue.sistemablue.domain.model;

import com.sistemablue.sistemablue.domain.entities.ConsultaMedica;
import com.sistemablue.sistemablue.domain.entities.ExameLaboratorial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtendimentoDTO {

    private List<ConsultaMedica> consultaMedica;
    private List<ExameLaboratorial> exameLaboratorial;
    private Date dataAtendimento;

}
