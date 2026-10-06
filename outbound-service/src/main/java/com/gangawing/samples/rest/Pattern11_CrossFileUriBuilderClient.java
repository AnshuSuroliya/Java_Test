package com.gangawing.samples.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * CodeScout Pattern A consumer: cross-file {@code restTemplate.exchange(builder.buildSendEmailURI(), ...)}.
 */
@Service
public class Pattern11_CrossFileUriBuilderClient {

    private final RestTemplate restTemplate;
    private final Pattern11_EmailNotificationClientUriBuilder emailNotificationUriBuilder;

    public Pattern11_CrossFileUriBuilderClient(
            RestTemplate restTemplate,
            Pattern11_EmailNotificationClientUriBuilder emailNotificationUriBuilder) {
        this.restTemplate = restTemplate;
        this.emailNotificationUriBuilder = emailNotificationUriBuilder;
    }

    public void sendEmail(Object body) {
        restTemplate.exchange(
                emailNotificationUriBuilder.buildSendEmailURI(),
                HttpMethod.POST,
                new HttpEntity<>(body),
                Object.class);
    }
}
