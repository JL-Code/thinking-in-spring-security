package com.jiangy.thinkinginspringsecurity.controller;

import com.jiangy.thinkinginspringsecurity.Constants;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

/**
 * <p>创建时间: 2025/2/23 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">蒋勇</a>
 */
@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationApiController {

    private final StringRedisTemplate store;

    @PostMapping
    public String send(String recipient) {
        var code = RandomStringUtils.randomNumeric(6);
        store.opsForValue().set(Constants.RK_CODE.formatted(recipient), code, Duration.ofMinutes(5));
        return code;
    }
}
