package com.forzeo.brandanalytics.common.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log =
            LoggerFactory.getLogger(LoggingAspect.class);

    /* ========= Pointcuts ========= */

    @Pointcut("within(com.forzeo.brandanalytics.controller..*)")
    public void controllerLayer() {}
	
    @Pointcut("within(com.forzeo.brandanalytics.services..*)")
    public void serviceLayer() {}

    @Pointcut("within(com.forzeo.brandanalytics.repository..*)")
    public void repositoryLayer() {}

    /* ========= Advices ========= */

    @Around("controllerLayer()")
    public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
        return logExecution(joinPoint, "CONTROLLER", true);
    }

    @Around("serviceLayer()")
    public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
        return logExecution(joinPoint, "SERVICE", true);
    }

    @Around("repositoryLayer()")
    public Object logRepository(ProceedingJoinPoint joinPoint) throws Throwable {
        return logExecution(joinPoint, "REPOSITORY", false);
    }

    /* ========= Core Logger ========= */

    private Object logExecution(
            ProceedingJoinPoint joinPoint,
            String layer,
            boolean logArgs) throws Throwable {

        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        if (log.isInfoEnabled()) {
            log.info("[{}] Entering {}.{}(){}",
                    layer,
                    className,
                    methodName,
                    logArgs ? " args=" + Arrays.toString(joinPoint.getArgs()) : "");
        }

        long start = System.currentTimeMillis();

        try {
            Object result = joinPoint.proceed();
            long timeTaken = System.currentTimeMillis() - start;

            log.info("[{}] Exiting {}.{}() | {} ms",
                    layer,
                    className,
                    methodName,
                    timeTaken);

            return result;
        } catch (Exception ex) {
            log.error("[{}] Exception in {}.{}() : {}",
                    layer,
                    className,
                    methodName,
                    ex.getMessage(),
                    ex);
            throw ex;
        }
    }
}
