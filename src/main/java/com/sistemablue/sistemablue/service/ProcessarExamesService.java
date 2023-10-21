package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.model.CadastroDeExame;
import com.sistemablue.sistemablue.model.ExameLaboratorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessarExamesService {

    public List<ExameLaboratorio> processarExames(final List<CadastroDeExame> cadastroDeExames) {

        log.info("Iniciando o processamento dos exames: [{}]", cadastroDeExames);

        final var examesLaboratorio = new ArrayList<ExameLaboratorio>();

        examesLaboratorio.addAll(processarBilirrubina(cadastroDeExames));
        examesLaboratorio.addAll(processarPerfilLipidico(cadastroDeExames));

        log.info("Processamento dos exames concluído: [{}]", examesLaboratorio);

        return examesLaboratorio;
    }

    private List<ExameLaboratorio> processarBilirrubina(final List<CadastroDeExame> cadastroDeExames) {

        log.info("Iniciando o processamento da bilirrubina: [{}]", cadastroDeExames);

        final var examesLaboratorio = new ArrayList<ExameLaboratorio>();

        final var bilirrubinaCadastrada = cadastroDeExames.stream().anyMatch(exame -> "bilirrubina".equalsIgnoreCase(exame.getNome()));

        if (bilirrubinaCadastrada) {

            final var bilirrubinaTotal = cadastroDeExames.stream().filter(exame -> "bilirrubina total".equalsIgnoreCase(exame.getNome())).findFirst();
            final var bilirrubinaIndireta = cadastroDeExames.stream().filter(exame -> "bilirrubina indireta".equalsIgnoreCase(exame.getNome())).findFirst();

            if (bilirrubinaTotal.isPresent() && bilirrubinaIndireta.isPresent()) {

                log.info("Iniciando o processamento de cálculo das frações da bilirrubina: [{} - {}]", bilirrubinaTotal, bilirrubinaIndireta);

                final var total = Double.parseDouble(bilirrubinaTotal.get().getResultado());
                final var indireta = Double.parseDouble(bilirrubinaIndireta.get().getResultado());
                final var direta = total - indireta;

                log.info("Resultado do cálculo das frações: [BT({}) - BI({}) = DB({})]", total, indireta, direta);

                final var bilirrubinaDireta = new ExameLaboratorio();
                bilirrubinaDireta.setNome("bilirrubina direta");
                bilirrubinaDireta.setResultado(Double.toString(direta));

                log.info("Exame de bilirrubina direta adicionado: [{}]", bilirrubinaDireta);

                examesLaboratorio.add(bilirrubinaDireta);
            }
        }

        return examesLaboratorio;
    }

    private List<ExameLaboratorio> processarPerfilLipidico(final List<CadastroDeExame> cadastroDeExames) {

        log.info("Iniciando o processamento do perfil lipídico: [{}]", cadastroDeExames);

        final var examesLaboratorio = new ArrayList<ExameLaboratorio>();

        final var colesterolTotalPresente = cadastroDeExames.stream().anyMatch(exame -> exame.getNome().equalsIgnoreCase("Colesterol Total"));

        final var hdlColesterolPresente = cadastroDeExames.stream().anyMatch(exame -> exame.getNome().equalsIgnoreCase("HDL-Colesterol"));

        final var triglicerideosPresente = cadastroDeExames.stream().anyMatch(exame -> exame.getNome().equalsIgnoreCase("Triglicerídeos"));

        if (colesterolTotalPresente && hdlColesterolPresente && triglicerideosPresente) {

            final var colesterolTotal = cadastroDeExames.stream().filter(exame -> exame.getNome().equalsIgnoreCase("Colesterol Total")).findFirst().orElse(null);

            final var hdlColesterol = cadastroDeExames.stream().filter(exame -> exame.getNome().equalsIgnoreCase("HDL-Colesterol")).findFirst().orElse(null);

            final var triglicerideos = cadastroDeExames.stream().filter(exame -> exame.getNome().equalsIgnoreCase("Triglicerídeos")).findFirst().orElse(null);

            if (colesterolTotal != null && hdlColesterol != null && triglicerideos != null) {

                final var colesterolTotalValor = Double.parseDouble(colesterolTotal.getResultado());
                final var hdlColesterolValor = Double.parseDouble(hdlColesterol.getResultado());
                final var triglicerideosValor = Double.parseDouble(triglicerideos.getResultado());

                final var vldlColesterolValor = triglicerideosValor / 5;
                final var ldlColesterolValor = colesterolTotalValor - hdlColesterolValor - vldlColesterolValor;

                final var vldlColesterol = new ExameLaboratorio();
                vldlColesterol.setNome("VLDL-Colesterol");
                vldlColesterol.setResultado(String.valueOf(vldlColesterolValor));
                examesLaboratorio.add(vldlColesterol);

                final var ldlColesterol = new ExameLaboratorio();
                ldlColesterol.setNome("LDL-Colesterol");
                ldlColesterol.setResultado(String.valueOf(ldlColesterolValor));
                examesLaboratorio.add(ldlColesterol);
            }
        }

        return examesLaboratorio;
    }
}
