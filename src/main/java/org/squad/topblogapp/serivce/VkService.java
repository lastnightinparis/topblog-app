package org.squad.topblogapp.serivce;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.squad.topblogapp.entity.VkRecord;
import org.squad.topblogapp.repository.VkRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VkService {
    private VkRepository vkRepository;

    //todo send image to ML model, get answer and convert to domain model
    public Long uploadVkImage(MultipartFile image){
        VkRecord vkRecord = new VkRecord();
        vkRecord.setImage(image.getName());
        vkRecord.setMetric(1L);
        return vkRepository.save(vkRecord).getId();
    }
}
