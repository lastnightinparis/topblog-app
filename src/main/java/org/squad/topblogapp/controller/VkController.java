package org.squad.topblogapp.controller;

import java.io.ByteArrayOutputStream;
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
import org.squad.topblogapp.serivce.VkService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vk")
@AllArgsConstructor
public class VkController {
    private VkService vkService;
    private CsvProperties csvProperties;
    private CsvService csvService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Long uploadVkImage(@RequestParam(name = "image") MultipartFile image,
                              @RequestParam(name = "vk_link") String vkLink) {
        return vkService.uploadVkImage(image, vkLink);
    }

    @GetMapping(value = "/download", produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public byte[] downloadVkExcel() throws IOException {
        return csvService.getWorkbook(csvProperties.getVkFile());
    }
}
