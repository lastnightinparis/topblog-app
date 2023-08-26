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
import org.squad.topblogapp.serivce.TgService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/tg")
@AllArgsConstructor
public class TgController {
    private TgService tgService;
    private CsvProperties csvProperties;
    private CsvService csvService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Long uploadTgImage(@RequestParam(name = "image") MultipartFile image,
                              @RequestParam(name = "platform_link") String tgLink) {
        return tgService.uploadTgImage(image, tgLink);
    }

    @GetMapping(value = "/download", produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public byte[] downloadTgExcel() throws IOException {
        return csvService.getWorkbook(csvProperties.getTgFile());
    }
}
