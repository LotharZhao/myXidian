package com.zhao.vv.thread.b;

/**
 * 如何避免死锁
 * 让程序每次至多只能获得一个锁，但并不现实
 * 设计时考虑清楚锁的顺序，尽量减少嵌在的加锁交互数量
 * 既然死锁的产生是两个线程无限等待对方持有的锁，那么只要等待时间有个上限不就好了
 * @author zhaoliangtao
 *
 */
class DeadLock {
	private final Object left = new Object();
	private final Object right = new Object();

	public void leftRight() throws Exception {
		synchronized (left) {
			Thread.sleep(2000);
			synchronized (right) {
				System.out.println("leftRight end!");
			}
		}
	}

	public void rightLeft() throws Exception {
		synchronized (right) {
			Thread.sleep(2000);
			synchronized (left) {
				System.out.println("rightLeft end!");
			}
		}
	}
}

class Thread0 extends Thread {
	private DeadLock dl;

	public Thread0(DeadLock dl) {
		this.dl = dl;
	}

	public void run() {
		try {
			dl.leftRight();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Thread1 extends Thread {
	private DeadLock dl;

	public Thread1(DeadLock dl) {
		this.dl = dl;
	}

	public void run() {
		try {
			dl.rightLeft();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class DeadLockTest {
	public static void main(String[] args) {
		DeadLock dl = new DeadLock();
		Thread0 t0 = new Thread0(dl);
		Thread1 t1 = new Thread1(dl);
		t0.start();
		t1.start();

		while (true) {
		}
	}
}
