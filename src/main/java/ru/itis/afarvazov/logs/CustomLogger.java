package ru.itis.afarvazov.logs;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.logging.Logger;

@Aspect
@Configurable
public class CustomLogger {

    static Logger logger = Logger.getLogger(CustomLogger.class.getName());

    @Pointcut("within(ru.itis.afarvazov.controllers.*)")
    public void execute() {
    }

    @Pointcut("@annotation(ru.itis.afarvazov.logs.Logging)")
    public void logAnnotation() {
    }

    @Before("execute()")
    public void before(JoinPoint joinPoint) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("mtd:" + joinPoint.getSignature().getName() + " user:" + name);
    }

}
