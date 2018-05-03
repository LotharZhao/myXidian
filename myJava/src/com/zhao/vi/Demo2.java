/**
 * ʵ��Runnable�ӿڣ������߳�
 */
package com.zhao.vi;

public class Demo2 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		// �����̶߳���,Ȼ��������
		Thread t = new Thread(dog);
		t.start();
	}
}

class Dog implements Runnable {
	int times = 0;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
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