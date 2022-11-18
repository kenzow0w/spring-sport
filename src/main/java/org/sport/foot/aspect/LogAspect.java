package org.sport.foot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class LogAspect {

    private static Logger LOG = LoggerFactory.getLogger(LogAspect.class);

    @Before(value = "execution(* org.sport.foot.controller.*.*(..))")
    public void logStatementBefore(JoinPoint joinPoint) {
        LOG.info("Executing... {}", joinPoint);
    }

    @After(value = "execution(* org.sport.foot.controller.*.*(..))")
    public void logStatementAfter(JoinPoint joinPoint) {
        LOG.info("Complete execution {}", joinPoint);
    }
}
