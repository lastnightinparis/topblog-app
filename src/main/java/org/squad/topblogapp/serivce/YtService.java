package org.squad.topblogapp.serivce;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.config.properties.CsvProperties;
import org.squad.topblogapp.entity.YtRecord;
import org.squad.topblogapp.repository.YtRepository;
import org.squad.topblogapp.util.RecordType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class YtService {
    private YtRepository ytRepository;
    private CsvService csvService;
    private CsvProperties csvProperties;

    //todo send image to ML model, get answer and convert to domain model
    public Long uploadYtImage(MultipartFile image, String ytLink){
        YtRecord ytRecord = new YtRecord();

        ytRecord.setYt_link(ytLink);
        ytRecord.setImage(image.getOriginalFilename());
        ytRecord.setMetric(1L);

        csvService.writeCsv(ytRecord, RecordType.YT, csvProperties.getYtFile());
        return ytRepository.save(ytRecord).getId();
    }
}
