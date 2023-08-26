package org.squad.topblogapp.serivce;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.config.properties.CsvProperties;
import org.squad.topblogapp.entity.TgRecord;
import org.squad.topblogapp.repository.TgRepository;
import org.squad.topblogapp.util.RecordType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TgService {
    private TgRepository tgRepository;
    private CsvService csvService;
    private CsvProperties csvProperties;

    //todo send image to ML model, get answer and convert to domain model
    public Long uploadTgImage(MultipartFile image, String tgLink){
        TgRecord tgRecord = new TgRecord();

        tgRecord.setTg_link(tgLink);
        tgRecord.setImage(image.getOriginalFilename());
        tgRecord.setMetric(1L);

        csvService.writeCsv(tgRecord, RecordType.TG, csvProperties.getTgFile());
        return tgRepository.save(tgRecord).getId();
    }
}
