package com.zhao.vv.thread.c;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock中的方法
 * @author zhaoliangtao
 *
 */
class Domain5 {
	public ReentrantLock lock = new ReentrantLock();

	public void testMethod1() {
		try {
			lock.lock();
			// getHoldCount()返回的是当前线程调用lock()的次数
			System.out.println(Thread.currentThread().getName() + " testMethod1 - " + lock.getHoldCount());
			// isFair()获取此锁是否公平锁，ReentrantLock默认是false
			System.out.println(Thread.currentThread().getName() + " 是否公平锁？" + lock.isFair());
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
		// getQueueLength()方法用于获取正等待获取此锁定的线程估计数，在遍历查询线程数的同时线程可能动态变化，因此此数据不一定准确
		System.out.println("有" + td.lock.getQueueLength() + "个线程正在等待！");
		// hasQueuedThread(Thread thread)用来查询指定的线程是否正在等待获取指定的对象监视器
	    for (int i = 0; i < 5; i++)
	    	System.out.println("t"+i+" is waiting？" + td.lock.hasQueuedThread(threads[i]));
	    // hasQueuedThreads()用于查询是否有线程正在等待获取指定的对象监视器
	    System.out.println("is any thread waiting？" + td.lock.hasQueuedThreads());
	}
}
