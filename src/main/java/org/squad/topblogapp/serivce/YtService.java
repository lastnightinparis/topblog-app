package org.squad.topblogapp.serivce;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.config.properties.CsvProperties;
import org.squad.topblogapp.entity.YtRecord;
import org.squad.topblogapp.ml.RemoteMLService;
import org.squad.topblogapp.repository.YtRepository;
import org.squad.topblogapp.util.RecordType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class YtService {
    private RemoteMLService remoteMLService;
    private CsvService csvService;
    private YtRepository ytRepository;
    private CsvProperties csvProperties;

    public Long uploadYtImage(MultipartFile image, String ytLink){
        YtRecord ytRecord = new YtRecord();

        ytRecord.setYt_link(ytLink);
        ytRecord.setImage(image.getOriginalFilename());
        ytRecord.setMetric(remoteMLService.getMetricFromMlModel(image, RecordType.YT));

        csvService.writeCsv(ytRecord, RecordType.YT, csvProperties.getYtFile());
        return ytRepository.save(ytRecord).getId();
    }
}
