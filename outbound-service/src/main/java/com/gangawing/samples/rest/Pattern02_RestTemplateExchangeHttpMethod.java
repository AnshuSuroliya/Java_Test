package com.gangawing.samples.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * CodeScout pattern: {@code RestTemplate.exchange(..., HttpMethod.POST, ...)}.
 * Parser: {@code rest_http_method} must be POST, not DYNAMIC.
 */
@Service
public class Pattern02_RestTemplateExchangeHttpMethod {

    private final RestTemplate restTemplate;

    public Pattern02_RestTemplateExchangeHttpMethod(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void submitWorkflow(Object payload) {
        HttpEntity<Object> requestEntity = new HttpEntity<>(payload);
        restTemplate.exchange(
                "/WorkFlow/submit",
                HttpMethod.POST,
                requestEntity,
                Object.class);
    }
}
