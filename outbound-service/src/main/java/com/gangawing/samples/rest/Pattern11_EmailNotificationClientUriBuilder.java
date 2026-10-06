package com.gangawing.samples.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * CodeScout Pattern A (enterprise): {@code StringBuilder.append(...)} with {@code static final}
 * path segment constants. Indexed by {@code buildSendEmailURI}; linker resolves constants via
 * {@code global_vars} on the builder method snippet.
 */
@Component
public class Pattern11_EmailNotificationClientUriBuilder {

    private static final String NOTIFICATIONS_API_CONTEXT_PATH = "/ucount-notificationsapi";
    private static final String EMAIL_RESOURCE_ROOT_PATH = "/email";
    private static final String EMAIL_RESOURCE_SEND_ENDPOINT = "/send";

    @Value("${ucs.notifications.host}")
    private String notificationsHost;

    public String buildSendEmailURI() {
        StringBuilder uriBuilder = new StringBuilder();
        if (notificationsHost != null) {
            uriBuilder.append(notificationsHost);
        }
        uriBuilder.append(NOTIFICATIONS_API_CONTEXT_PATH);
        uriBuilder.append(EMAIL_RESOURCE_ROOT_PATH);
        uriBuilder.append(EMAIL_RESOURCE_SEND_ENDPOINT);
        return uriBuilder.toString();
    }
}
