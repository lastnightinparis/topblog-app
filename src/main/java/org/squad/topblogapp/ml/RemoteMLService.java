package org.squad.topblogapp.ml;

import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.squad.topblogapp.util.RecordType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RemoteMLService {
    private WebClient remoteApiClient;

    public Long getMetricFromMlModel(MultipartFile image, RecordType type) {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder.part("image", image.getResource());

//        String string = remoteApiClient.post()
//            .uri("/detect")
//            .contentType(MediaType.MULTIPART_FORM_DATA)
//            .body(BodyInserters.fromMultipartData(builder.build()))
//            .retrieve()
//            .bodyToMono(String.class)
//            .block();

        String string = remoteApiClient.get()
            .uri("/hello")
            .retrieve()
            .bodyToMono(String.class)
            .block();

        return 0L;
    }

}
