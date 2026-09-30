package com.gangawing.ucount.chgrequestsapi.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrgChangesController {

    private RestTemplate restTemplate;

    public ResponseEntity<Object> forwardOrgChange(Object orgChangePayload, String finalUri) {
        HttpEntity<Object> requestEntity = new HttpEntity<>(orgChangePayload);

        ResponseEntity<Object> exchange = restTemplate.exchange(
            "/EmailNotification/send",
            HttpMethod.POST,
            requestEntity,
            Object.class
        );

        return exchange;
    }
}
