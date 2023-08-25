package org.squad.topblogapp.serivce;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.entity.ZnRecord;
import org.squad.topblogapp.repository.ZnRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ZnService {
    private ZnRepository znRepository;

    //todo send image to ML model, get answer and convert to domain model
    public Long uploadZnImage(MultipartFile image){
        ZnRecord znRecord = new ZnRecord();
        znRecord.setImage(image.getName());
        znRecord.setMetric(1L);
        return znRepository.save(znRecord).getId();
    }
}
