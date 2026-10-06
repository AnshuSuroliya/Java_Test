package com.gangawing.samples.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Inbound target for {@link com.gangawing.samples.rest.Pattern11_SameFileEmailUriClient}
 * ({@code POST /Pattern11/same-file/email/send}).
 */
@RestController
@RequestMapping("Pattern11/same-file/email")
public class Pattern11_SameFileEmailController {

    @PostMapping(value = "/send", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String send(@RequestBody String payload) {
        return "{\"status\":\"sent\",\"variant\":\"same-file\"}";
    }
}
