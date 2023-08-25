package org.squad.topblogapp.serivce;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.entity.TgRecord;
import org.squad.topblogapp.repository.TgRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TgService {
    private TgRepository tgRepository;

    //todo send image to ML model, get answer and convert to domain model
    public Long uploadTgImage(MultipartFile image){
        TgRecord tgRecord = new TgRecord();
        tgRecord.setImage(image.getName());
        tgRecord.setMetric(1L);
        return tgRepository.save(tgRecord).getId();
    }
}
