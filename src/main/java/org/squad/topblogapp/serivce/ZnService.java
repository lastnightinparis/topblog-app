package org.squad.topblogapp.serivce;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.config.properties.CsvProperties;
import org.squad.topblogapp.entity.ZnRecord;
import org.squad.topblogapp.repository.ZnRepository;
import org.squad.topblogapp.util.RecordType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ZnService {
    private ZnRepository znRepository;
    private CsvService csvService;
    private CsvProperties csvProperties;

    //todo send image to ML model, get answer and convert to domain model
    public Long uploadZnImage(MultipartFile image, String znLink){
        ZnRecord znRecord = new ZnRecord();

        znRecord.setZn_link(znLink);
        znRecord.setImage(image.getOriginalFilename());
        znRecord.setMetric(1L);

        csvService.writeCsv(znRecord, RecordType.ZN, csvProperties.getZnFile());
        return znRepository.save(znRecord).getId();
    }
}
