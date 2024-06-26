package com.ota.jobboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${api.url}")
    private String apiUrl;

    @Bean
    public WebClient webClient() {
        return WebClient.create(apiUrl);
    }
}
