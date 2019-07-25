package com.phoebe.staffjoy.common.config;

import com.phoebe.staffjoy.common.aop.SentryClientAspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
/**
 * Use this common config for Web App
 */
@Configuration
@Import(value = {StaffjoyConfig.class, SentryClientAspect.class,})
public class StaffjoyWebConfig {
}
