package com.example.FactoryManager.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "cors")
public class CorsProperties {

    private List<String> allowedOrigins;
    private String allowedMethods = "GET, POST, PUT, DELETE";
    private String allowedHeaders = "Content-Type, Authorization";
    private Boolean allowCredentials = true;
}
