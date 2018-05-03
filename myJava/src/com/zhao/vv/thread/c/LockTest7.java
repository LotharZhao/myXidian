package com.zhao.vv.thread.c;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁ReentrantReadWriteLock
 * 读写锁表示两个锁，一个是读操作相关的锁，称为共享锁；另一个是写操作相关的锁，称为排他锁
 * 多个Thread可以同时进行读取操作，但是同一时刻只允许一个Thread进行写入操作
 * 读和读之间不互斥，因为读操作不会有线程安全问题
 * 写和写之间互斥，避免一个写操作影响另外一个写操作，引发线程安全问题
 * 读和写之间互斥，避免读操作的时候写操作修改了内容，引发线程安全问题
 * @author zhaoliangtao
 *
 */
class Domain7 extends ReentrantReadWriteLock {
	public void read() {
		try {
			readLock().lock();
			System.out.println(Thread.currentThread().getName() + "获得了读锁, 时间为" + System.currentTimeMillis());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readLock().unlock();
		}
	}

	public void write() {
		try {
			writeLock().lock();
			System.out.println(Thread.currentThread().getName() + "获得了写锁, 时间为" + System.currentTimeMillis());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			writeLock().unlock();
		}
	}
}

public class LockTest7 {
	public static void main(String[] args) throws InterruptedException {
		final Domain7 td = new Domain7();
		Runnable readRunnable = new Runnable() {
			public void run() {
				td.read();
			}
		};
		Runnable writeRunnable = new Runnable() {
			public void run() {
				td.write();
			}
		};

		Thread t0 = new Thread(readRunnable);
		Thread t1 = new Thread(readRunnable);
		t0.start();
		t1.start();

		Thread t2 = new Thread(writeRunnable);
		Thread t3 = new Thread(writeRunnable);
		t2.start();
		t3.start();
	}
	/**
1、synchronized是关键字，就和if...else...一样，是语法层面的实现，因此synchronized获取锁以及释放锁都是Java虚拟机帮助用户完成的；ReentrantLock是类层面的实现，因此锁的获取以及锁的释放都需要用户自己去操作。特别再次提醒，ReentrantLock在lock()完了，一定要手动unlock()

2、synchronized简单，简单意味着不灵活，而ReentrantLock的锁机制给用户的使用提供了极大的灵活性。这点在Hashtable和ConcurrentHashMap中体现得淋漓尽致。synchronized一锁就锁整个Hash表，而ConcurrentHashMap则利用ReentrantLock实现了锁分离，锁的只是segment而不是整个Hash表

3、synchronized是不公平锁，而ReentrantLock可以指定锁是公平的还是非公平的

4、synchronized实现等待/通知机制通知的线程是随机的，ReentrantLock实现等待/通知机制可以有选择性地通知

5、和synchronized相比，ReentrantLock提供给用户多种方法用于锁信息的获取，比如可以知道lock是否被当前线程获取、lock被同一个线程调用了几次、lock是否被任意线程获取等等

总结起来，我认为如果只需要锁定简单的方法、简单的代码块，那么考虑使用synchronized，复杂的多线程处理场景下可以考虑使用ReentrantLock
	 */
}
