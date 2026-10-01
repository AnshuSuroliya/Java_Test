package com.gangawing.samples.rest;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * CodeScout pattern: {@code buildSendEmailURI()} on the same class as the RestTemplate caller.
 * Parser: inlines {@code .append(...)} segments into {@code rest_url} at parse time.
 */
@Service
public class Pattern04_SameClassUriBuilderClient {

    private final RestTemplate restTemplate;

    public Pattern04_SameClassUriBuilderClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void send() {
        restTemplate.exchange(
                buildSendEmailURI(),
                HttpMethod.POST,
                null,
                Object.class);
    }

    public String buildSendEmailURI() {
        StringBuilder uriBuilder = new StringBuilder();
        uriBuilder.append("https://host.example.com");
        uriBuilder.append("/EmailNotification/send");
        return uriBuilder.toString();
    }
}
