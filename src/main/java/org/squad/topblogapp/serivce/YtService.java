package org.squad.topblogapp.serivce;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.entity.YtRecord;
import org.squad.topblogapp.repository.YtRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class YtService {
    private YtRepository ytRepository;

    //todo send image to ML model, get answer and convert to domain model
    public Long uploadYtImage(MultipartFile image){
        YtRecord ytRecord = new YtRecord();
        ytRecord.setImage(image.getName());
        ytRecord.setMetric(1L);
        return ytRepository.save(ytRecord).getId();
    }
}
