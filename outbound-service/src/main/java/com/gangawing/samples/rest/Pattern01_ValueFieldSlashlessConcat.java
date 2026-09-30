package com.gangawing.samples.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * CodeScout pattern: {@code @Value} on a field (no initializer) + path literal without a leading slash.
 * Parser: {@code rest_url} should include {@code ${internal.api.base-url}} and {@code internal-account/...}.
 * Linker: resolves property from CONFIGURATION / application.properties, then matches inbound paths.
 */
@Service
public class Pattern01_ValueFieldSlashlessConcat {

    @Value("${internal.api.base-url}")
    private String internalURL;

    private final RestTemplate restTemplate;

    public Pattern01_ValueFieldSlashlessConcat(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void updateOrgRole(String accountId) {
        restTemplate.postForEntity(
                internalURL + "internal-account/update-org-role/" + accountId,
                null,
                String.class);
    }
}
