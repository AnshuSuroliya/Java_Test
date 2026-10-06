package com.gangawing.samples.rest;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * CodeScout Pattern C (same file): {@code UCOUNT_SF_ENDPOINT} and
 * {@code uriBuilder -> uriBuilder.path(UCOUNT_SF_ENDPOINT).build()} in one class (no separate
 * {@code Constants} type).
 */
@Service
public class Pattern12_SameFileWebClientLambdaClient {

    private static final String UCOUNT_SF_ENDPOINT = "/Pattern12/same-file/counterparty";

    private final WebClient webClient;

    public Pattern12_SameFileWebClientLambdaClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public void publishCounterparty(Object eventDTO, String apiKey, String env, String correlationId) {
        webClient.post()
                .uri(uriBuilder -> uriBuilder.path(UCOUNT_SF_ENDPOINT).build())
                .header("x-api-key", apiKey)
                .header("env", env)
                .header("x-correlation-id", correlationId)
                .bodyValue(eventDTO)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe();
    }
}
