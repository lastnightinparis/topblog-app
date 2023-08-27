package org.squad.topblogapp.serivce;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.config.properties.CsvProperties;
import org.squad.topblogapp.entity.ZnRecord;
import org.squad.topblogapp.ml.RemoteMLService;
import org.squad.topblogapp.repository.ZnRepository;
import org.squad.topblogapp.util.RecordType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ZnService {
    private RemoteMLService remoteMLService;
    private CsvService csvService;
    private ZnRepository znRepository;
    private CsvProperties csvProperties;

    public Long uploadZnImage(MultipartFile image, String znLink){
        ZnRecord znRecord = new ZnRecord();

        znRecord.setZn_link(znLink);
        znRecord.setImage(image.getOriginalFilename());
        znRecord.setMetric(remoteMLService.getMetricFromMlModel(image, RecordType.ZN));

        csvService.writeCsv(znRecord, RecordType.ZN, csvProperties.getZnFile());
        return znRepository.save(znRecord).getId();
    }
}
