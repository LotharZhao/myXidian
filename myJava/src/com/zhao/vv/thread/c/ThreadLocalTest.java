package com.zhao.vv.thread.c;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadLocal不是用来解决共享对象的多线程访问问题的
 * 同步与ThreadLocal是解决多线程中数据访问问题的两种思路，前者是数据共享的思路，后者是数据隔离的思路
 * @author zhaoliangtao
 *
 */
class Tools {
	public static ThreadLocal<String> t1 = new ThreadLocal<String>();
}

class ThreadLocalThread extends Thread {
	private static AtomicInteger ai = new AtomicInteger();

	public ThreadLocalThread(String name) {
		super(name);
	}

	public void run() {
		try {
			for (int i = 0; i < 3; i++) {
				Tools.t1.set(ai.addAndGet(1) + "");
				System.out.println(this.getName() + " get value--->" + Tools.t1.get());
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ThreadLocalTest {
	public static void main(String[] args) throws Exception {
		ThreadLocalThread a = new ThreadLocalThread("ThreadA");
		ThreadLocalThread b = new ThreadLocalThread("ThreadB");
		ThreadLocalThread c = new ThreadLocalThread("ThreadC");
		a.start();
		b.start();
		c.start();
	}
}
