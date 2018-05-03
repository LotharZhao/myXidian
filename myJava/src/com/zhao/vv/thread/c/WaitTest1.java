package com.zhao.vv.thread.c;

/**
 * wait()方法可以使调用该线程的方法释放共享资源的锁，然后从运行状态退出，进入等待队列，直到再次被唤醒
 * notify()方法可以随机唤醒等待队列中等待同一共享资源的一个线程，并使得该线程退出等待状态，进入可运行状态
 * notifyAll()方法可以使所有正在等待队列中等待同一共享资源的全部线程从等待状态退出，进入可运行状态 
 * wait()方法和notify()/notifyAll()方法必须在同步方法/同步代码块中被调用
 * @author zhaoliangtao
 *
 */
class Thread1_1 extends Thread {
	private Object lock;

	public Thread1_1(Object lock) {
		this.lock = lock;
	}

	public void run() {
		try {
			synchronized (lock) {
				System.out.println("开始---wait time = " + System.currentTimeMillis());
				lock.wait();
				System.out.println("结束---wait time = " + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Thread1_2 extends Thread {
	private Object lock;

	public Thread1_2(Object lock) {
		this.lock = lock;
	}

	public void run() {
		synchronized (lock) {
			System.out.println("开始---notify time = " + System.currentTimeMillis());
//			lock.notify();
			lock.notifyAll();
			System.out.println("结束---notify time = " + System.currentTimeMillis());
		}
	}
}

public class WaitTest1 {
	public static void main(String[] args) throws Exception {
		Object lock = new Object();
		Thread1_1 mt0_1 = new Thread1_1(lock);
		Thread1_1 mt0_2 = new Thread1_1(lock);
		Thread1_1 mt0_3 = new Thread1_1(lock);
		mt0_1.start();
		mt0_2.start();
		mt0_3.start();
		Thread.sleep(3000);
		Thread1_2 mt1 = new Thread1_2(lock);
		mt1.start();
	}
}
