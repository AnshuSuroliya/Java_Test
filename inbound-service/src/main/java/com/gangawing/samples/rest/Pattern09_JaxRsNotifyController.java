package com.gangawing.samples.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Inbound target for {@link com.gangawing.samples.rest.Pattern09_JaxRsUriBuilderClient}
 * ({@code POST /samples/jaxrs/notify/dispatch}).
 */
@RestController
@RequestMapping("samples/jaxrs")
public class Pattern09_JaxRsNotifyController {

    @PostMapping(value = "/notify/dispatch", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String dispatch(@RequestBody String payload) {
        return "{\"received\":true}";
    }
}
