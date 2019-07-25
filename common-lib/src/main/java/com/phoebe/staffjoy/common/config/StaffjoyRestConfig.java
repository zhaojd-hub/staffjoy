package com.phoebe.staffjoy.common.config;

import com.phoebe.staffjoy.common.aop.SentryClientAspect;
import com.phoebe.staffjoy.common.error.GlobalExceptionTranslator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Use this common config for Rest API
 */
@Configuration
@Import(value = {StaffjoyConfig.class, SentryClientAspect.class, GlobalExceptionTranslator.class})
public class StaffjoyRestConfig  {
}
