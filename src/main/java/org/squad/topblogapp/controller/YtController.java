package org.squad.topblogapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.serivce.YtService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/yt")
@AllArgsConstructor
public class YtController {
    private YtService ytService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Long uploadYtImage(@RequestParam(name = "image") MultipartFile image) {
        return ytService.uploadYtImage(image);
    }
}
