package com.zhao.vv.thread.a;

/**
 * Thread类中的实例方法
 * @author zhaoliangtao
 *
 */
class ThreadStaticMethod extends Thread {
	static {
		// currentThread()对当前正在执行线程对象的引用
		// 线程类的构造方法、静态块是被main线程调用的，而线程类的run()方法才是应用线程自己调用的
		System.out.println("静态块的打印：" + Thread.currentThread().getName());
	}

	public ThreadStaticMethod() {
		// 当前执行的Thread未必就是本线程
		System.out.println("构造方法的打印：" + Thread.currentThread().getName());
		System.out.println("构造方法this的打印：" + this.getName());
	}

	public void run() {
		System.out.println("run()方法的打印：" + Thread.currentThread().getName());
		try {
			// sleep(1000)当前正在执行的线程休眠ms
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("run()方法this的打印：" + this.getName());
	}
}

class ThreadStaticMethod2 extends Thread {
	public void run() {
		long beginTime = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < 50000000; i++) {
			// yield()暂停当前执行的线程对象，会放弃CPU资源但放弃CPU的时间不确定
			Thread.yield();
			count = count + i + 1;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("用时：" + (endTime - beginTime) + "ms！");
	}
}

public class ThreadMethodTest2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadStaticMethod tsm = new ThreadStaticMethod();
		System.out.println("begin = " + System.currentTimeMillis());
		tsm.start();
		// 因为tsm与main是异步的，所以没有sleep()执行的时间差
		System.out.println("endxx = " + System.currentTimeMillis());

		ThreadStaticMethod2 tsm2 = new ThreadStaticMethod2();
		tsm2.start();
	}
}
