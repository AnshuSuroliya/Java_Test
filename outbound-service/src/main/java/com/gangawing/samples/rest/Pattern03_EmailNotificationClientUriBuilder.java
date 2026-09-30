package com.gangawing.samples.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * CodeScout pattern: URI built in a separate class via {@code StringBuilder.append(...)}.
 * Linker pre-pass indexes {@code build*Uri*} methods and inlines into {@code rest_url_resolved}.
 */
@Component
public class Pattern03_EmailNotificationClientUriBuilder {

    @Value("${ucs.notifications.host}")
    private String notificationsHost;

    public String buildSendEmailURI() {
        StringBuilder uriBuilder = new StringBuilder();
        uriBuilder.append(notificationsHost);
        uriBuilder.append("/ucount-notificationsapi/email/send");
        return uriBuilder.toString();
    }
}
