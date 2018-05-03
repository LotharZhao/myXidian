package com.zhao.day3.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {

	@Before(value = "execution(* com.zhao.day3.aop.Book.*(..))")
	public void before1() {
		System.out.println("前置增强...");
	}

	@AfterReturning(value = "execution(* com.zhao.day3.aop.Book.*(..))")
	public void after1() {
		System.out.println("后置增强...");
	}

	@Around(value = "execution(* com.zhao.day3.aop.Book.*(..))")
	public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("环绕通知.方法之前...");
		proceedingJoinPoint.proceed();
		System.out.println("环绕通知.方法之后...");
	}
}
