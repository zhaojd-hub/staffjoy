package com.phoebe.staffjoy.account;

import com.phoebe.staffjoy.common.auth.AuthConstant;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * Pass CURRENT_USER_HEADER via Feign for testing
 */
@Configuration
public class TestConfig {

    public static String TEST_USER_ID = UUID.randomUUID().toString();

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            if (!StringUtils.isEmpty(TEST_USER_ID)) {
                template.header(AuthConstant.CURRENT_USER_HEADER, TEST_USER_ID);
            }
        };
    }
}