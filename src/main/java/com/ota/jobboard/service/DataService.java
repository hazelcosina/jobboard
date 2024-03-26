package com.ota.jobboard.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DataService {
    private final WebClient webClient;

    public DataService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> fetchDataFromApi1() {
        return webClient.get()
                .retrieve()
                .bodyToMono(String.class);
    }

}
