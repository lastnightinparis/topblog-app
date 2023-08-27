package org.squad.topblogapp.serivce;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.config.properties.CsvProperties;
import org.squad.topblogapp.entity.VkRecord;
import org.squad.topblogapp.ml.RemoteMLService;
import org.squad.topblogapp.repository.VkRepository;
import org.squad.topblogapp.util.RecordType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VkService {
    private RemoteMLService remoteMLService;
    private CsvService csvService;
    private VkRepository vkRepository;
    private CsvProperties csvProperties;

    public Long uploadVkImage(MultipartFile image, String vkLink) {
        VkRecord vkRecord = new VkRecord();

        vkRecord.setVk_link(vkLink);
        vkRecord.setImage(image.getOriginalFilename());
        vkRecord.setMetric(remoteMLService.getMetricFromMlModel(image, RecordType.VK));

        csvService.writeCsv(vkRecord, RecordType.VK, csvProperties.getVkFile());
        return vkRepository.save(vkRecord).getId();
    }
}
