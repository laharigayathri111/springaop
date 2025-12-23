package com.learn.springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect

@Component

public class LoggingAspect {

	// 1️⃣ Log BEFORE controller methods

	@Before("execution(* com.learn.springaop.controller.*.*(..))")

	public void logBeforeController(JoinPoint joinPoint) {

		System.out.println("➡ Controller Method Called : "

				+ joinPoint.getSignature());

	}

	// 2️⃣ Log AFTER service methods return successfully

	@AfterReturning(

			pointcut = "execution(* com.learn.springaop.service.*.*(..))",

			returning = "result"

	)

	public void logAfterService(JoinPoint joinPoint, Object result) {

		System.out.println("✔ Service Method Completed : "

				+ joinPoint.getSignature());

	}

	// 3️⃣ Measure execution time of service methods

	@Around("execution(* com.learn.springaop.service.*.*(..))")

	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

		long startTime = System.currentTimeMillis();

		Object proceed = joinPoint.proceed(); // call actual method

		long endTime = System.currentTimeMillis();

		System.out.println("⏱ Execution Time of "

				+ joinPoint.getSignature()

				+ " : " + (endTime - startTime) + " ms");

		return proceed;

	}

}
