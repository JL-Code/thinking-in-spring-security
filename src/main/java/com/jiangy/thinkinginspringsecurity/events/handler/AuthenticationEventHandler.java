package com.jiangy.thinkinginspringsecurity.events.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * <p>创建时间: 2025/2/23 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">蒋勇</a>
 */
@Slf4j
@Component
public class AuthenticationEventHandler {

    @Async
    @EventListener
    public void handleAuthenticationSuccessEvent(AuthenticationSuccessEvent event) {
        log.info("Authentication success event, Name:{}", event.getAuthentication().getName());
    }

    @Async
    @EventListener
    public void handleLogoutSuccessEvent(LogoutSuccessEvent event) {
        log.info("Logout success event, Name:{}", event.getAuthentication().getName());
    }
}
