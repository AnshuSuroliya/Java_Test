package com.gangawing.samples.rest;

import static com.gangawing.samples.rest.constants.Pattern12_WebClientEndpointConstants.UCOUNT_SF_ENDPOINT;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * CodeScout Pattern C: {@code webClient.post().uri(uriBuilder -> uriBuilder.path(UCOUNT_SF_ENDPOINT).build())}
 * with {@code UCOUNT_SF_ENDPOINT} imported from {@link com.gangawing.samples.rest.constants.Pattern12_WebClientEndpointConstants}.
 */
@Service
public class Pattern12_WebClientLambdaPathClient {

    private final WebClient webClient;

    public Pattern12_WebClientLambdaPathClient(WebClient webClient) {
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
