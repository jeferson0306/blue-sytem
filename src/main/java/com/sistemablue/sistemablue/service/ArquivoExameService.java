package com.sistemablue.sistemablue.service;

import com.sistemablue.sistemablue.model.ValoresDeReferenciaExames;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Slf4j
@Service
public class ArquivoExameService {

    @Value("${arquivo.excel.path}")
    private String arquivoExcelPath;

    @Value("${arquivo.name}")
    private String arquivoName;

    @Value("${arquivo.json.name.path}")
    private String arquivoJsonPath;

    public List<ValoresDeReferenciaExames> lerExamesDoExcel() throws IOException {

        try (final var fileInputStream = new FileInputStream(arquivoExcelPath)) {

            final var workbook = new XSSFWorkbook(fileInputStream);
            final var sheet = workbook.getSheetAt(0);

            final var rowStream = StreamSupport.stream(sheet.spliterator(), false);
            final var rowIterator = rowStream.iterator();

            rowIterator.next();

            final var exames = new ArrayList<ValoresDeReferenciaExames>();

            while (rowIterator.hasNext()) {

                final var row = rowIterator.next();
                final var cellIterator = row.cellIterator();
                final var exame = cellIterator.next().getStringCellValue();
                final var valorMinimo = cellIterator.next().getStringCellValue();
                final var valorMaximo = cellIterator.next().getStringCellValue();
                final var unidadeReferencia = cellIterator.next().getStringCellValue();
                final var resultado = new ValoresDeReferenciaExames(exame, valorMinimo, valorMaximo, unidadeReferencia);
                exames.add(resultado);
            }

            return exames;
        }
    }

    public String lerArquivoJson() {

        try {

            log.info("Iniciando a leitura do arquivo json {}", arquivoName);

            final var resource = new ClassPathResource(arquivoJsonPath);

            if (resource.exists()) {

                final var fileData = FileCopyUtils.copyToByteArray(resource.getInputStream());
                final var jsonContent = new String(fileData, StandardCharsets.UTF_8);

                log.info("Arquivo json lido com sucesso");

                return jsonContent;
            } else {
                log.error("Arquivo json não encontrado.");
            }
        } catch (final Exception e) {
            log.error("Erro ao ler o arquivo json: [{}]", e.getMessage());
        }
        return null;
    }

}
