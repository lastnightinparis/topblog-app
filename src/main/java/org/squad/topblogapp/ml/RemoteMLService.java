package org.squad.topblogapp.ml;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.squad.topblogapp.util.RecordType;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class RemoteMLService {
    private WebClient remoteApiClient;

    public Long getMetricFromMlModel(MultipartFile image, RecordType type) {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder.part("image", image.getResource());

        String response = remoteApiClient.post()
            .uri(uriBuilder -> uriBuilder
                .path("/predict/")
                .queryParam("platform", type.name())
                .build())
            .contentType(MediaType.MULTIPART_FORM_DATA)
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromMultipartData(builder.build()))
            .retrieve()
            .onStatus(httpStatusCode -> httpStatusCode != HttpStatus.OK,
                clientResponse -> {
                    System.out.println(clientResponse.statusCode());
                    return Mono.empty();
                })
            .bodyToMono(String.class)
            .block();

        System.out.println("Answer from ML model = " + response);

        if (response != null) {
            response = response.replace("\"", "");
            return Long.parseLong(response);
        } else return 0L;
    }

}
