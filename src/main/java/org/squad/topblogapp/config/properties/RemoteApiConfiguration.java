package org.squad.topblogapp.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "remote.api")
@Setter
public class RemoteApiConfiguration {
    private String client;
    @Bean
    public WebClient remoteApiClient() {
        return WebClient.create(client);
    }
}
