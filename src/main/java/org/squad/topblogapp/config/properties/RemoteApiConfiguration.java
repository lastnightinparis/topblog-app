package org.squad.topblogapp.config.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RemoteApiConfiguration {
    @Bean
    public WebClient remoteApiClient() {
        return WebClient.create("http://51.250.22.177:8080");
    }
}
