package com.jiangy.thinkinginspringsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 应用安全配置
 * <p>
 * 创建时间: 2025/2/22
 * </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">蒋勇</a>
 */
@Configuration
public class AppSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "swagger-ui.html")
                        .permitAll()
                        .anyRequest()
                        .permitAll());
        return http.build();
    }
}
