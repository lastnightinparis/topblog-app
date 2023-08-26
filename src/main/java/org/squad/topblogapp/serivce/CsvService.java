package org.squad.topblogapp.serivce;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
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
            try {
                FileInputStream fis = new FileInputStream(filename);
                Workbook workbook = WorkbookFactory.create(fis);
                Sheet sheet = workbook.getSheetAt(0);
                Row row = sheet.createRow(sheet.getLastRowNum() + 1);
                Cell metric = row.createCell(0);
                Cell image = row.createCell(1);
                metric.setCellValue(record.getMetric());
                image.setCellValue(record.getImage());
                IOUtils.closeQuietly(fis);
                FileOutputStream fos = new FileOutputStream(filename);
                workbook.write(fos);
                workbook.close();
                IOUtils.closeQuietly(fos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public byte[] getWorkbook(String filename) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        FileInputStream fis = new FileInputStream(filename);
        Workbook workbook = WorkbookFactory.create(fis);
        try {
            workbook.write(bos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bos.close();
        }
        workbook.close();
        return bos.toByteArray();
    }
}
