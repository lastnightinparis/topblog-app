package org.squad.topblogapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.serivce.TgService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/tg")
@AllArgsConstructor
public class TgController {
    private TgService tgService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Long uploadTgImage(@RequestParam(name = "image") MultipartFile image) {
        return tgService.uploadTgImage(image);
    }
}
