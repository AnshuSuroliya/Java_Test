package com.gangawing.samples.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Inbound target for {@link com.gangawing.samples.rest.Pattern10_UriBuilderWithArgsClient}
 * ({@code POST /Pattern10/EmailNotification/send/{notificationId}}).
 */
@RestController
@RequestMapping("Pattern10/EmailNotification")
public class Pattern10_EmailWithIdController {

    @PostMapping(value = "/send/{notificationId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String sendWithId(
            @PathVariable String notificationId,
            @RequestBody String body) {
        return "{\"notificationId\":\"" + notificationId + "\"}";
    }
}
