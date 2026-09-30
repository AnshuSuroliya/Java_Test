package com.gangawing.nsir.service.impl;

import com.gangawing.nsir.exception.UcsApiException;
import com.gangawing.nsir.oauth.OAuthTokenCache;
import java.time.Duration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

@Service
public class OimWebClientServiceImpl {

    private WebClient webClient;
    private OAuthTokenCache oAuthTokenCache;
    private int apiRetriesMax;
    private Duration apiRetriesDelay;

    public void pushOimEvent(String url, Class<?> responseType) {
        webClient.get()
            .uri("workflow/status/{orgId}")
            .headers(h -> h.add("Authorization", oAuthTokenCache.getOAuthAccessToken()))
            .exchangeToMono(clientResponse -> {
                if (clientResponse.statusCode().is4xxClientError()) {
                    throw new UcsApiException(HttpStatus.valueOf(clientResponse.statusCode().value()), "URL is wrong");
                }
                return clientResponse.bodyToMono(responseType);
            })
            .retryWhen(Retry.backoff(apiRetriesMax, apiRetriesDelay))
            .subscribe();
    }
}
