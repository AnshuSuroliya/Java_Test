package com.gangawing.samples.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * CodeScout pattern: Spring {@link UriComponentsBuilder}
 * {@code fromHttpUrl(host).path(...).pathSegment(id).build().toUriString()}.
 * Parser/linker extract {@code .fromHttpUrl}, {@code .path}, and {@code .pathSegment} segments.
 */
@Service
public class Pattern08_UriComponentsBuilderClient {

    private final RestTemplate restTemplate;

    @Value("${internal.api.base-url}")
    private String internalApiBaseUrl;

    public Pattern08_UriComponentsBuilderClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void updateAccountStatus(String accountId) {
        String url = UriComponentsBuilder.fromHttpUrl(internalApiBaseUrl)
                .path("/api/v2/accounts")
                .pathSegment(accountId)
                .path("status")
                .build()
                .toUriString();

        restTemplate.postForEntity(url, null, String.class);
    }
}
