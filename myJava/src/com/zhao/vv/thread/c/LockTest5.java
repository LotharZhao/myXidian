package com.zhao.vv.thread.c;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock�еķ���
 * @author zhaoliangtao
 *
 */
class Domain5 {
	public ReentrantLock lock = new ReentrantLock();

	public void testMethod1() {
		try {
			lock.lock();
			// getHoldCount()���ص��ǵ�ǰ�̵߳���lock()�Ĵ���
			System.out.println(Thread.currentThread().getName() + " testMethod1 - " + lock.getHoldCount());
			// isFair()��ȡ�����Ƿ�ƽ����ReentrantLockĬ����false
			System.out.println(Thread.currentThread().getName() + " �Ƿ�ƽ����" + lock.isFair());
			testMethod2();
		} finally {
			lock.unlock();
		}
	}

	public void testMethod2() {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + " testMethod2 - " + lock.getHoldCount());
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

public class LockTest5 {
	public static void main(String[] args) throws InterruptedException {
		Domain5 td = new Domain5();
		Runnable runnable = new Runnable() {
			public void run() {
				td.testMethod1();
			}
		};
		Thread[] threads = new Thread[5];
		for (int i = 0; i < 5; i++)
			threads[i] = new Thread(runnable);
		for (int i = 0; i < 5; i++)
			threads[i].start();

		Thread.sleep(100);
		// getQueueLength()�������ڻ�ȡ���ȴ���ȡ���������̹߳��������ڱ�����ѯ�߳�����ͬʱ�߳̿��ܶ�̬�仯����˴����ݲ�һ��׼ȷ
		System.out.println("��" + td.lock.getQueueLength() + "���߳����ڵȴ���");
		// hasQueuedThread(Thread thread)������ѯָ�����߳��Ƿ����ڵȴ���ȡָ���Ķ��������
	    for (int i = 0; i < 5; i++)
	    	System.out.println("t"+i+" is waiting��" + td.lock.hasQueuedThread(threads[i]));
	    // hasQueuedThreads()���ڲ�ѯ�Ƿ����߳����ڵȴ���ȡָ���Ķ��������
	    System.out.println("is any thread waiting��" + td.lock.hasQueuedThreads());
	}
}
