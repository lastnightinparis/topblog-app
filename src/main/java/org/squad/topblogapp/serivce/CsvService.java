package org.squad.topblogapp.serivce;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.squad.topblogapp.config.properties.CsvProperties;
import org.squad.topblogapp.entity.Record;
import org.squad.topblogapp.util.RecordType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CsvService {

    private CsvProperties csvProperties;
    //todo use properties and type to create file with header
    public <T extends Record> void writeCsv(T record, RecordType type, String filename) {
        Path path = Paths.get(filename);
        if (Files.exists(path)) {
            try (FileInputStream file = new FileInputStream(filename);
                 FileOutputStream outputStream = new FileOutputStream(filename);
                 Workbook workbook = new XSSFWorkbook(file)) {
                Sheet sheet = workbook.getSheetAt(0);
                Row row = sheet.createRow(sheet.getLastRowNum() + 1);
                Cell metric = row.createCell(0);
                Cell image = row.createCell(1);
                metric.setCellValue(record.getMetric());
                image.setCellValue(record.getImage());
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
