package com.learn.springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect

@Component

public class ExceptionAspect {

	@AfterThrowing(

			pointcut = "execution(* com.learn.springaop..*(..))",

			throwing = "exception"

	)

	public void logException(JoinPoint joinPoint, Exception exception) {

		System.out.println("❌ EXCEPTION OCCURRED");

		System.out.println("➡ Method : " + joinPoint.getSignature());

		System.out.println("➡ Message : " + exception.getMessage());

	}

}
