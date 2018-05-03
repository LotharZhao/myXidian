package com.zhao.vv.thread.b;

/**
 * volatile解决的是变量在多个线程之间的可见性，但是无法保证原子性
 * synchronized除了保障了原子性外，其实也保障了可见性
 * @author zhaoliangtao
 *
 */
class VolatileDemo extends Thread {
	private volatile boolean isRunning = true;

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public void run() {
		System.out.println("进入run了");
		while (isRunning == true) {
		}
		System.out.println("线程被停止了");
	}
}

public class VolatileTest1 {
	public static void main(String[] args) throws InterruptedException {
		VolatileDemo vm = new VolatileDemo();
		vm.start();
		Thread.sleep(1000);
		vm.setRunning(false);
		System.out.println("已赋值为false");
	}
}
