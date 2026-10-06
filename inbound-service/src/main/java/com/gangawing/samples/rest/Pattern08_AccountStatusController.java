package com.gangawing.samples.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Inbound target for {@link com.gangawing.samples.rest.Pattern08_UriComponentsBuilderClient}
 * ({@code POST /api/v2/accounts/{accountId}/status}).
 */
@RestController
@RequestMapping("/api/v2/accounts")
public class Pattern08_AccountStatusController {

    @PostMapping(value = "/{accountId}/status", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String postAccountStatus(@PathVariable String accountId) {
        return "{\"accountId\":\"" + accountId + "\",\"status\":\"updated\"}";
    }
}
