package com.gangawing.samples.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Inbound target for {@link com.gangawing.samples.rest.Pattern12_SameFileWebClientLambdaClient}
 * ({@code POST /Pattern12/same-file/counterparty}).
 */
@RestController
@RequestMapping("Pattern12/same-file")
public class Pattern12_SameFileCounterpartyController {

    @PostMapping(value = "/counterparty", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String counterparty(@RequestBody String payload) {
        return "{\"accepted\":true,\"variant\":\"same-file\"}";
    }
}
