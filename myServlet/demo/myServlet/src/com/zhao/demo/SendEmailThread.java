package com.zhao.demo;

public class SendEmailThread extends Thread {
	// ��ʱ�����ʼ�
	public void run() {
		int i = 0;
		try {
			while (true) {
				Thread.sleep(10 * 1000);
				// �����ʼ�
				System.out.println("������" + (++i) + "���ʼ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
