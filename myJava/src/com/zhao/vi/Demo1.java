/**
 * 继承Thread类，创建线程
 */
package com.zhao.vi;

public class Demo1 {
	public static void main(String[] args) {
		Cat cat = new Cat();
		// 启动线程,会导致run函数的运行
		cat.start();
	}
}

class Cat extends Thread {
	int times = 0;

	// 重写run函数
	public void run() {
		while (true) {
			// 休眠一秒=1000毫秒
			try {
				Thread.sleep(1000);// 让线程进入Blocked状态，并释放资源
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			times++;
			System.out.println("hello world " + times);
			if (times == 10)
				break;
		}
	}
}