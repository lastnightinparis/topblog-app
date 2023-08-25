package org.squad.topblogapp.config.properties;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
@Configuration
@ConfigurationProperties(prefix = "csv.config")
@Getter
@Setter
public class CsvProperties {
    private Map<String, String> headers;
}
