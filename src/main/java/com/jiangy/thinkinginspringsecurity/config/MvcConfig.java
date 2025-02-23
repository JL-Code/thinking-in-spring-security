package com.jiangy.thinkinginspringsecurity.config;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>创建时间: 2025/2/23 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">蒋勇</a>
 * @see <a href="https://ultraq.github.io/thymeleaf-layout-dialect/">Thymeleaf Layout Dialect</a>
 */
@Configuration
public class MvcConfig {
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
