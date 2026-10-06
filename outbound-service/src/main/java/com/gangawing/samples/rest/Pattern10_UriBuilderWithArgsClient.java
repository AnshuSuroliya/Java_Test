package com.gangawing.samples.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * CodeScout pattern: {@code restTemplate.exchange(builder.buildSendEmailURI(id), ...)} with a non-empty
 * argument list. Callee {@code rest_url} is {@code emailUriBuilder.buildSendEmailURI(notificationId)};
 * linker resolves via sibling {@code function_class} and cross-file builder index.
 */
@Service
public class Pattern10_UriBuilderWithArgsClient {

    private final RestTemplate restTemplate;
    private final Pattern10_EmailUriBuilderWithArgs emailUriBuilder;

    public Pattern10_UriBuilderWithArgsClient(
            RestTemplate restTemplate,
            Pattern10_EmailUriBuilderWithArgs emailUriBuilder) {
        this.restTemplate = restTemplate;
        this.emailUriBuilder = emailUriBuilder;
    }

    public void sendEmail(String notificationId, Object body) {
        restTemplate.exchange(
                emailUriBuilder.buildSendEmailURI(notificationId),
                HttpMethod.POST,
                new HttpEntity<>(body),
                Object.class);
    }
}
