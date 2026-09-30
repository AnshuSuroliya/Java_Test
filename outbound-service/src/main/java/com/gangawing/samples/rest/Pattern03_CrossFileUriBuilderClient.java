package com.gangawing.samples.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * CodeScout pattern: {@code restTemplate.exchange(builder.buildSendEmailURI(), HttpMethod.POST, ...)}.
 * Parser: may keep opaque call; linker resolves via cross-file URI-builder index.
 */
@Service
public class Pattern03_CrossFileUriBuilderClient {

    private final RestTemplate restTemplate;
    private final Pattern03_EmailNotificationClientUriBuilder emailNotificationClientUriBuilder;

    public Pattern03_CrossFileUriBuilderClient(
            RestTemplate restTemplate,
            Pattern03_EmailNotificationClientUriBuilder emailNotificationClientUriBuilder) {
        this.restTemplate = restTemplate;
        this.emailNotificationClientUriBuilder = emailNotificationClientUriBuilder;
    }

    public void sendEmail(Object body) {
        restTemplate.exchange(
                emailNotificationClientUriBuilder.buildSendEmailURI(),
                HttpMethod.POST,
                new HttpEntity<>(body),
                Object.class);
    }
}
