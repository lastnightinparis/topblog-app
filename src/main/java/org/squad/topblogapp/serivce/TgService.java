package org.squad.topblogapp.serivce;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.config.properties.CsvProperties;
import org.squad.topblogapp.entity.TgRecord;
import org.squad.topblogapp.ml.RemoteMLService;
import org.squad.topblogapp.repository.TgRepository;
import org.squad.topblogapp.util.RecordType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TgService {
    private RemoteMLService remoteMLService;
    private CsvService csvService;
    private TgRepository tgRepository;
    private CsvProperties csvProperties;

    public Long uploadTgImage(MultipartFile image, String tgLink){
        TgRecord tgRecord = new TgRecord();

        tgRecord.setTg_link(tgLink);
        tgRecord.setImage(image.getOriginalFilename());
        tgRecord.setMetric(remoteMLService.getMetricFromMlModel(image, RecordType.TG));

        csvService.writeCsv(tgRecord, RecordType.TG, csvProperties.getTgFile());
        return tgRepository.save(tgRecord).getId();
    }
}
