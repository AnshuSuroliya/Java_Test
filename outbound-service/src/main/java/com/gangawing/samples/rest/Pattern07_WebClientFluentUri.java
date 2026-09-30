package com.gangawing.samples.rest;

import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

/**
 * CodeScout pattern: multi-line WebClient chain; {@code rest_url} from {@code .uri(...)} not lambda body.
 */
@Service
public class Pattern07_WebClientFluentUri {

    private final WebClient webClient;
    private String underwritingServiceURL = "http://localhost";

    public Pattern07_WebClientFluentUri(WebClient webClient) {
        this.webClient = webClient;
    }

    public void triggerUnderwriting(Map<String, Object> requestPayload) {
        String targetUrl = underwritingServiceURL + "/underwriting/assess";

        webClient.post()
                .uri(targetUrl)
                .bodyValue(requestPayload)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(Map.class))
                .retryWhen(Retry.backoff(3, java.time.Duration.ofSeconds(1)))
                .subscribe(
                        responseMap -> {
                            Object decision = responseMap.get("decision");
                        },
                        error -> System.err.println(error.getMessage()));
    }
}
