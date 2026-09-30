package com.gangawing.samples.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * CodeScout regression: path segment with a leading slash on the literal (existing behavior).
 */
@Service
public class Pattern06_LeadingSlashConcatRegression {

    @Value("${internal.api.base-url}")
    private String internalURL;

    private final RestTemplate restTemplate;

    public Pattern06_LeadingSlashConcatRegression(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void lookupCreditworthiness() {
        restTemplate.getForEntity(
                internalURL + "/Creditworthiness/lookup",
                String.class);
    }
}
