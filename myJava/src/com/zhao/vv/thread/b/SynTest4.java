package com.zhao.vv.thread.b;

/**
 * 当一个线程执行的代码出现异常时，其所持有的锁会自动释放
 * @author zhaoliangtao
 *
 */
class Domain4 {
	public synchronized void testMethod() {
		try {
			System.out.println("Enter ThreadDomain17.testMethod, currentThread = " + Thread.currentThread().getName());
			long l = Integer.MAX_VALUE;
			while (true) {
				long lo = 2 / l;
				l--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class MyThread4 extends Thread {
	private Domain4 td;

	public MyThread4(Domain4 td) {
		this.td = td;
	}

	public void run() {
		td.testMethod();
	}
}

public class SynTest4 {
	public static void main(String[] args) {
		Domain4 td = new Domain4();
		MyThread4 mt0 = new MyThread4(td);
		MyThread4 mt1 = new MyThread4(td);
		mt0.start();
		mt1.start();
	}
}
