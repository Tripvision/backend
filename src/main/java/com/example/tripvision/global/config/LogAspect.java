package com.example.tripvision.global.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * Logging Aop 적용 클래스 입니다.
 */
@Aspect
@ConditionalOnProperty(prefix = "app.logging",
	name = "enabled",
	havingValue = "true")
@Component
public class LogAspect {
	Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Around("execution(* com.example.tripvision.member..*.*(..))")
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("loggin-start" + pjp.getSignature().getDeclaringTypeName() + "/" + pjp.getSignature().getName());
		Object result = pjp.proceed();
		logger.info("loggin-end" + pjp.getSignature().getDeclaringTypeName() + "/" + pjp.getSignature().getName());
		return result;
	}
}
