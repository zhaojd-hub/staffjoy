package com.phoebe.staffjoy.common.aop;

import com.phoebe.staffjoy.common.env.EnvConfig;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
@Slf4j
public class SentryClientAspect {

    @Autowired
    EnvConfig envConfig;

    @Around("execution(* io.sentry.SentryClient.send*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        // no sentry logging in debug mode
        if (envConfig.isDebug()) {
            log.debug("no sentry logging in debug mode");
            return;
        }
        joinPoint.proceed();
    }
}
