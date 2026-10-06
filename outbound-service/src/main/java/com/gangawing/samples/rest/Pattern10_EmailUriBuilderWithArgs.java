package com.gangawing.samples.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * CodeScout pattern: builder method with parameters, e.g. {@code buildSendEmailURI(notificationId)}.
 * Indexed by name {@code build*Uri*}; {@code .path} / {@code .pathSegment} segments are inlined into {@code rest_url}.
 */
@Component
public class Pattern10_EmailUriBuilderWithArgs {

    @Value("${ucs.notifications.host}")
    private String notificationsHost;

    public String buildSendEmailURI(String notificationId) {
        return UriComponentsBuilder.fromHttpUrl(notificationsHost)
                .path("/Pattern10/EmailNotification/send")
                .pathSegment(notificationId)
                .build()
                .toUriString();
    }
}
