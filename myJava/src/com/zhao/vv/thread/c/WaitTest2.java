package com.zhao.vv.thread.c;

/**
 * interrupt()方法的作用不是中断线程，而是在线程阻塞的时候给线程一个中断标识，表示该线程中断
 * wait()就是"阻塞的一种场景"
 * @author zhaoliangtao
 *
 */
class Domain {
	public void testMethod(Object lock) {
		try {
			synchronized (lock) {
				System.out.println("Begin wait()");
				lock.wait();
				System.out.println("End wait()");
			}
		} catch (InterruptedException e) {
			System.out.println("wait()被interrupt()打断了！");
			e.printStackTrace();
		}
		System.out.println("继续执行...");
	}
}

class Thread2 extends Thread {
	private Object lock;

	public Thread2(Object lock) {
		this.lock = lock;
	}

	public void run() {
		Domain td = new Domain();
		td.testMethod(lock);
	}
}

public class WaitTest2 {
	public static void main(String[] args) throws Exception {
		Object lock = new Object();
		Thread2 mt = new Thread2(lock);
		mt.start();
		Thread.sleep(1000);
		mt.interrupt();
	}
}
