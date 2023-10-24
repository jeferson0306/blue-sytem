package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.model.entities.Cliente;
import com.sistemablue.sistemablue.model.exame.RealizacaoExame;
import com.sistemablue.sistemablue.model.exame.ValorReferencia;
import com.sistemablue.sistemablue.model.exame.ResultadoDeExame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ResultadoExameService {

    private static final String NORMAL = "normal";
    private static final String BAIXO = "baixo";
    private static final String ALTO = "alto";

//    List<ExameReferencia> referencias = carregarDadosDeReferencia();

    public static void verificarResultados(final Cliente cliente, final List<ResultadoDeExame> resultados, final List<ValorReferencia> referencias) {

        resultados.forEach(resultadoDeExame -> referencias.stream().filter(referencia -> referencia.getNomeExame().equalsIgnoreCase(resultadoDeExame.getNome())).findFirst().ifPresent(referencia -> {

            final var valorResultado = resultadoDeExame.getResultado();
            final var valorMinimo = referencia.getValorReferenciaMinimo();
            final var valorMaximo = referencia.getValorReferenciaMaximo();

            var flag = NORMAL;

            if (valorResultado < valorMinimo) {
                flag = BAIXO;
            } else if (valorResultado > valorMaximo) {
                flag = ALTO;
            } else {
                flag = NORMAL;
            }

            resultadoDeExame.setFlag(flag);

            final var exameLaboratorio = new RealizacaoExame();
            exameLaboratorio.setNomeExame(resultadoDeExame.getNome());
            exameLaboratorio.setUnidade(referencia.getUnidade());
            exameLaboratorio.setResultado(String.valueOf(resultadoDeExame.getResultado()));
            exameLaboratorio.setValorDeReferencia(String.format("%s - %s", valorMinimo, valorMaximo));
            exameLaboratorio.setAlteracao(!NORMAL.equalsIgnoreCase(flag));

            log.info("Resultado do exame {} do cliente '{}' é '{}' (Ref: {} - {})", resultadoDeExame.getNome(), cliente.getNome(), resultadoDeExame.getResultado(), valorMinimo, valorMaximo);
        }));
    }


}
