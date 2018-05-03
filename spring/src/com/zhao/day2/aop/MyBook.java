package com.zhao.day2.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyBook {

	public void before1() {
		System.out.println("ǰ����ǿ...");
	}

	public void after1() {
		System.out.println("������ǿ...");
	}

	public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// ����֮ǰ
		System.out.println("����֪ͨ.����֮ǰ...");
		// ִ�б���ǿ�ķ���
		proceedingJoinPoint.proceed();
		// ����֮��
		System.out.println("����֪ͨ.����֮��...");
	}
}
