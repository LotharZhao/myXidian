package com.zhao.demo;

public class SendEmailThread extends Thread {
	// 定时发送邮件
	public void run() {
		int i = 0;
		try {
			while (true) {
				Thread.sleep(10 * 1000);
				// 发送邮件
				System.out.println("发出第" + (++i) + "封邮件");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
