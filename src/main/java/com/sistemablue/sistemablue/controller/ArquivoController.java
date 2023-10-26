package com.sistemablue.sistemablue.controller;

import com.sistemablue.sistemablue.domain.model.ArquivoDTO;
import com.sistemablue.sistemablue.service.ArquivoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/arquivos")
@RequiredArgsConstructor
public class ArquivoController {

    private final ArquivoService arquivoService;

    @Value("${arquivo.name}")
    private String arquivoName;

    @GetMapping("/ler-excel")
    public List<ArquivoDTO> lerExcel() throws IOException {
        log.info("Iniciando a leitura do arquivo {}", arquivoName);
        final var excelReader = new ArquivoService();
        log.info("Finalizando a leitura do arquivo {}", arquivoName);
        return excelReader.lerExamesDoExcel();
    }

    @ResponseBody
    @GetMapping("/ler-json")
    public String buscarExamesJson() {
        log.info("Recebida solicitação para ler o arquivo json.");
        final var json = arquivoService.lerArquivoJson();
        log.info("Finalizada a solicitação de leitura do arquivo json.");
        return json;
    }
}
