package org.squad.topblogapp.serivce;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.entity.VkRecord;
import org.squad.topblogapp.repository.VkRepository;
import org.squad.topblogapp.util.RecordType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VkService {
    private VkRepository vkRepository;
    private CsvService csvService;

    //todo send image to ML model, get answer and convert to domain model
    public Long uploadVkImage(MultipartFile image){
        VkRecord vkRecord = new VkRecord();
        vkRecord.setImage(image.getName());
        vkRecord.setMetric(1L);
        csvService.writeCsv(vkRecord, RecordType.VK, "src/main/resources/vk.xlsx");
        return vkRepository.save(vkRecord).getId();
    }
}
