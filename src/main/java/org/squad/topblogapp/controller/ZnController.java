package org.squad.topblogapp.controller;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.config.properties.CsvProperties;
import org.squad.topblogapp.serivce.CsvService;
import org.squad.topblogapp.serivce.ZnService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/zn")
@AllArgsConstructor
public class ZnController {
    private ZnService znService;
    private CsvProperties csvProperties;
    private CsvService csvService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Long uploadZnImage(@RequestParam(name = "image") MultipartFile image) {
        return znService.uploadZnImage(image);
    }

    @GetMapping(value = "/download", produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public byte[] downloadZnExcel() throws IOException {
        return csvService.getWorkbook(csvProperties.getZnFile());
    }
}
