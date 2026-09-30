package com.gangawing.samples.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * CodeScout pattern: after property resolution, full URL {@code https://service1.com/api/v1/send}
 * should match controller {@code endpoint_path} {@code /api/v1/send} (allow_absolute when resolved).
 */
@Service
public class Pattern05_FullUrlPropertyResolve {

    @Value("${service1.base-url}")
    private String service1BaseUrl;

    private final RestTemplate restTemplate;

    public Pattern05_FullUrlPropertyResolve(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void triggerSend() {
        restTemplate.postForObject(
                service1BaseUrl + "/api/v1/send",
                "{}",
                String.class);
    }
}
