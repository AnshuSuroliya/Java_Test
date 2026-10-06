package com.gangawing.samples.rest;

import jakarta.ws.rs.core.UriBuilder;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * CodeScout pattern: JAX-RS {@link UriBuilder#fromUri} with chained {@code .path(...)} calls.
 * Parser/linker treat {@code .path} like {@code StringBuilder.append} for URL segment extraction.
 */
@Service
public class Pattern09_JaxRsUriBuilderClient {

    private final RestTemplate restTemplate;

    @Value("${ucs.notifications.host}")
    private String notificationsHost;

    public Pattern09_JaxRsUriBuilderClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void dispatchNotification(String body) {
        String url = UriBuilder.fromUri(notificationsHost)
                .path("samples")
                .path("jaxrs")
                .path("notify")
                .path("dispatch")
                .build()
                .toString();

        restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(body), String.class);
    }

    /**
     * Same path built via {@code uriBuilder -> uriBuilder.path(...)} (common in JAX-RS client code).
     */
    public void dispatchViaLambda(String body) {
        Function<UriBuilder, UriBuilder> appendDispatchPath = uriBuilder -> uriBuilder
                .path("samples")
                .path("jaxrs")
                .path("notify")
                .path("dispatch");

        String url = appendDispatchPath.apply(UriBuilder.fromUri(notificationsHost))
                .build()
                .toString();

        restTemplate.postForObject(url, body, String.class);
    }
}
