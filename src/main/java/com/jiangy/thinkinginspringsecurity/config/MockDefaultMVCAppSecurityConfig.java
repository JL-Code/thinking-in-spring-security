package com.jiangy.thinkinginspringsecurity.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.RememberMeConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 模拟传统MVC应用安全配置 ，学习测试专用。
 * <p>
 * 创建时间: 2025/2/22
 * </p>
 * SecurityFilterChain 默认配置：{@link org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration}
 * formLogin 默认配置：{@link FormLoginConfigurer}
 * rememberMe 默认配置：{@link RememberMeConfigurer}
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">蒋勇</a>
 */
@Configuration
public class MockDefaultMVCAppSecurityConfig {

    @Bean
    public SecurityFilterChain appSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize ->
                        authorize.anyRequest().authenticated())
//                .formLogin(form ->
//                        form.loginPage("/login")
//                                .permitAll()
//                )
                .rememberMe(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    @ConditionalOnMissingBean(UserDetailsService.class)
    InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        String generatedPassword = passwordEncoder.encode("123456");
        return new InMemoryUserDetailsManager(User.withUsername("user")
                .password(generatedPassword).roles("USER").build());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
