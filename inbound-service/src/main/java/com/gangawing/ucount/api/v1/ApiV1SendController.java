package com.gangawing.ucount.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Inbound target for Pattern05_FullUrlPropertyResolve ({@code POST /api/v1/send}).
 */
@RestController
@RequestMapping("/api/v1")
public class ApiV1SendController {

    @PostMapping(value = "/send", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String send(@RequestBody String body) {
        return "{\"status\":\"ok\"}";
    }
}
