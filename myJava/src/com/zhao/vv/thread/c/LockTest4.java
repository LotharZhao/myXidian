package com.zhao.vv.thread.c;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可以指定锁是公平锁还是非公平锁 公平锁表示线程获取锁的顺序是按照线程排队的顺序来分配的
 * 非公平锁就是一种获取锁的抢占机制，是随机获得锁的 synchronized其实就是一种非公平锁
 * @author zhaoliangtao
 *
 */
class Domain4 {
	// true值指定ReentrantLock为公平锁，false为非公平锁
	private Lock lock = new ReentrantLock(true);

	public void testMethodA() {
		try {
			lock.lock();
			System.out.println("A " + Thread.currentThread().getName() + " locked");
		} finally {
			lock.unlock();
		}
	}

	public synchronized void testMethodB() {
		try {
			lock.lock();
			System.out.println("B " + Thread.currentThread().getName() + " locked");
		} finally {
			lock.unlock();
		}
	}
}

public class LockTest4 {
	public static void main(String[] args) throws Exception {
		final Domain4 td = new Domain4();
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("A " + Thread.currentThread().getName() + " run");
				td.testMethodA();
			}
		};
		Runnable runnable2 = new Runnable() {
			public void run() {
				System.out.println("B " + Thread.currentThread().getName() + " run");
				td.testMethodB();
			}
		};
		Thread[] threads = new Thread[5];
		for (int i = 0; i < 5; i++)
			threads[i] = new Thread(runnable);
		for (int i = 0; i < 5; i++)
			threads[i].start();
		
		Thread.sleep(1000);
		System.out.println("#########");
		
		Thread[] threads2 = new Thread[5];
		for (int i = 0; i < 5; i++)
			threads2[i] = new Thread(runnable2);
		for (int i = 0; i < 5; i++)
			threads2[i].start();
	}
}
