package com.gangawing.samples.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * CodeScout Pattern A (same file): {@code static final} path constants, {@code buildSendEmailURI()},
 * and {@code restTemplate.exchange(buildSendEmailURI(), ...)} in one class. Parser inlines builder
 * at parse time via {@code _currentClassUriBuilderMethods}.
 */
@Service
public class Pattern11_SameFileEmailUriClient {

    private static final String NOTIFICATIONS_API_CONTEXT_PATH = "/Pattern11/same-file";
    private static final String EMAIL_RESOURCE_ROOT_PATH = "/email";
    private static final String EMAIL_RESOURCE_SEND_ENDPOINT = "/send";

    private final RestTemplate restTemplate;

    @Value("${ucs.notifications.host}")
    private String notificationsHost;

    public Pattern11_SameFileEmailUriClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendEmail(Object body) {
        restTemplate.exchange(
                buildSendEmailURI(),
                HttpMethod.POST,
                new HttpEntity<>(body),
                Object.class);
    }

    public String buildSendEmailURI() {
        StringBuilder uriBuilder = new StringBuilder();
        if (notificationsHost != null) {
            uriBuilder.append(notificationsHost);
        }
        uriBuilder.append(NOTIFICATIONS_API_CONTEXT_PATH);
        uriBuilder.append(EMAIL_RESOURCE_ROOT_PATH);
        uriBuilder.append(EMAIL_RESOURCE_SEND_ENDPOINT);
        return uriBuilder.toString();
    }
}
