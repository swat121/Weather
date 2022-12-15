package com.example.weather.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@ConfigurationProperties(prefix = "service")
public class UrlConfig {
    private String countryName;
    private String id;
    private String units;
}
