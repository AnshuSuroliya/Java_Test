package com.gangawing.ucount.org.service.impl;

import com.gangawing.ucount.org.oauth.OAuthTokenCache;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountServiceImpl {

    private RestTemplate restTemplate;
    private String internalURL;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder, OAuthTokenCache oAuthTokenCache) {
        return builder.interceptors((request, body, execution) -> {
            return builder.interceptors((request, body, execution) -> {
                request.getHeaders().add("Authorization", oAuthTokenCache.getOAuthAccessToken());
                return execution.execute(request, body);
            }).build();
        }
    }

    public void updateOrgRole(AccountReq accountReq) {
        ResponseEntity<String> response = restTemplate.postForEntity(
            internalURL + "Creditworthiness/save/" + accountReq.getIdcatOctxVAcc(),
            internalURL + "Creditworthiness/save/" + accountReq.getIdcatOctxVAcc())
    }
}
