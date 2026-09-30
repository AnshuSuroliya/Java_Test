package com.gangawing.nsir.service;

import java.time.Duration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

@Service
public class OAuthClient {

    private WebClient webClient;
    private String tokenUrl;
    private int apiRetriesMax;
    private Duration apiRetriesDelay;

    public void refreshTokenAsync(Class<?> tokenResponseType) {
        webClient.get()
            .uri(tokenUrl)
            .exchangeToMono(clientResponse -> clientResponse.bodyToMono(tokenResponseType))
            .retryWhen(Retry.backoff(apiRetriesMax, apiRetriesDelay))
            .subscribe();
    }
}
