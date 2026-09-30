package com.gangawing.ucount.org.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Legacy-style outbound client (slash-less segment). See also {@link com.gangawing.samples.rest.Pattern01_ValueFieldSlashlessConcat}.
 */
@Service
public class AccountServiceImpl {

    private final RestTemplate restTemplate;

    @Value("${internal.api.base-url}")
    private String internalURL;

    public AccountServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void updateOrgRole(String accountId) {
        ResponseEntity<String> response = restTemplate.postForEntity(
                internalURL + "Creditworthiness/save/" + accountId,
                null,
                String.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new IllegalStateException("update failed: " + response.getStatusCode());
        }
    }
}
