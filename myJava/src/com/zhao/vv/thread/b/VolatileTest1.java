package com.zhao.vv.thread.b;

/**
 * volatile������Ǳ����ڶ���߳�֮��Ŀɼ��ԣ������޷���֤ԭ����
 * synchronized���˱�����ԭ�����⣬��ʵҲ�����˿ɼ���
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
		System.out.println("����run��");
		while (isRunning == true) {
		}
		System.out.println("�̱߳�ֹͣ��");
	}
}

public class VolatileTest1 {
	public static void main(String[] args) throws InterruptedException {
		VolatileDemo vm = new VolatileDemo();
		vm.start();
		Thread.sleep(1000);
		vm.setRunning(false);
		System.out.println("�Ѹ�ֵΪfalse");
	}
}
