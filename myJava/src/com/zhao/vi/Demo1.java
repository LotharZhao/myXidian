/**
 * �̳�Thread�࣬�����߳�
 */
package com.zhao.vi;

public class Demo1 {
	public static void main(String[] args) {
		Cat cat = new Cat();
		// �����߳�,�ᵼ��run����������
		cat.start();
	}
}

class Cat extends Thread {
	int times = 0;

	// ��дrun����
	public void run() {
		while (true) {
			// ����һ��=1000����
			try {
				Thread.sleep(1000);// ���߳̽���Blocked״̬�����ͷ���Դ
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