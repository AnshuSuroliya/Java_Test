package com.gangawing.ucount.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApplicationController {

    private RestTemplate restTemplate;

    public ResponseEntity<Object> syncApplication(Object applicationSyncRequest, String finalUri) {
        HttpEntity<Object> requestEntity = new HttpEntity<>(applicationSyncRequest);

        ResponseEntity<Object> exchange = restTemplate.exchange(
            "WorkFlow/submit",
            HttpMethod.POST,
            requestEntity,
            Object.class
        );

        return exchange;
    }
}
