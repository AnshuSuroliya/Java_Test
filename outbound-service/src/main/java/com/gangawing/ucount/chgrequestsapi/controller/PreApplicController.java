package com.gangawing.ucount.chgrequestsapi.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PreApplicController {

    private RestTemplate restTemplate;

    public ResponseEntity<Object> validatePreApplic(Object validationRequest, String finalUri) {
        HttpEntity<Object> requestEntity = new HttpEntity<>(validationRequest);

        ResponseEntity<Object> exchange = restTemplate.exchange(
            "/WorkFlow/submit",
            HttpMethod.POST,
            requestEntity,
            Object.class
        );

        return exchange;
    }
}
