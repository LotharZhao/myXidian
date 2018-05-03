package com.zhao.vv.thread.c;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock中的方法
 * 使用继承ReentrantLock的写法
 * @author zhaoliangtao
 *
 */
class Domain6 extends ReentrantLock {
	public void testMethod() {
		try {
			lock();
			
			// tryLock()方法的作用是，在调用try()方法的时候，如果锁没有被另外一个线程持有，那么就返回true，否则返回false
			// tryLock(long timeout, TimeUnit unit)是tryLock()另一个重要的重载方法，表示如果在指定等待时间内获得了锁，则返回true，否则返回false
			// tryLock()只探测锁是否，并没有lock()的功能
			if (tryLock())
	            System.out.println(Thread.currentThread().getName() + "获得了锁");
	        else
	            System.out.println(Thread.currentThread().getName() + "没有获得锁");
			
			
			System.out.println(Thread.currentThread().getName() + "持有了锁！");
			// isHeldByCurrentThread()表示此对象监视器是否由当前线程保持
			System.out.println(Thread.currentThread().getName() + "是否持有锁？" + isHeldByCurrentThread());
			// isLocked()表示此对象监视器是否由任意线程保持
			System.out.println("是否任意线程持有了锁1？" + isLocked());
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			unlock();
		}
	}

	public void testHoldLock() {
		if (tryLock())
            System.out.println(Thread.currentThread().getName() + "获得了锁");
        else
            System.out.println(Thread.currentThread().getName() + "没有获得锁");
		
		System.out.println(Thread.currentThread().getName() + "是否持有锁？" + isHeldByCurrentThread());
		System.out.println("是否任意线程持有了锁2？" + isLocked());
	}
}

public class LockTest6 {
	public static void main(String[] args) {
		final Domain6 td = new Domain6();
		Runnable runnable0 = new Runnable() {
			public void run() {
				td.testMethod();
			}
		};
		Runnable runnable1 = new Runnable() {
			public void run() {
				td.testHoldLock();
			}
		};
		Thread t0 = new Thread(runnable0);
		Thread t1 = new Thread(runnable1);
		t0.start();
		t1.start();
	}
	/**
	 * 其他方法
	 * getWaitQueueLength(Condition condition)
	 类似getQueueLength()，不过此方法的前提是condition。比如5个线程，每个线程都执行了同一个await()的await()方法，那么方法调用的返回值是5，因为5个线程都在等待获得锁
	 * hasWaiters(Condition condition)
	 查询是否有线程正在等待与此锁有关的condition条件。比如5个线程，每个线程都执行了同一个condition的await()方法，那么方法调用的返回值是true，因为它们都在等待condition
	 * lockInterruptibly()
	 如果当前线程未被中断，则获取锁
	 * getWaitingThreads(Condition condition)
	 返回一个collection，它包含可能正在等待与此锁相关给定条件的那些线程，因为构造结果的时候实际线程可能动态变化，因此返回的collection只是尽力的估计值
	 */
}
