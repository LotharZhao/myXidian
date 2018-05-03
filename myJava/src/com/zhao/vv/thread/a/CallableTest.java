package com.zhao.vv.thread.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/**
 * ͨ��Callable��Future�����߳�
 * @author zhaoliangtao
 *
 */
public class CallableTest implements Callable<Integer> {
	public static void main(String[] args) {
		CallableTest ctt = new CallableTest();
		FutureTask<Integer> ft = new FutureTask<>(ctt);
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " ��ѭ������i��ֵ" + i);
			if (i == 5) {
				new Thread(ft, "�з���ֵ���߳�").start();
			}
		}
		try {
			System.out.println("���̵߳ķ���ֵ��" + ft.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Integer call() throws Exception {
		int i = 0;
		for (; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		return i;
	}
}