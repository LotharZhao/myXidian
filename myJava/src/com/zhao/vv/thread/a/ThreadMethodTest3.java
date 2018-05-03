package com.zhao.vv.thread.a;

/**
 * �жϻ�����һ��Э�����ƣ�Ҳ����˵ͨ���жϲ�����ֱ����ֹ��һ���̣߳�����Ҫ���жϵ��߳��Լ�����
 * ÿ���̶߳����ﶼ��һ����ʶλ��ʾ�Ƿ����ж�����������߳�ʵ�ֲ���ģ����������Ƿ����ж�����
 * 
 * interrupt()���������ý����������жϱ�ʶλ���������ж��̵߳�����
 * isInterrupted()Ψһ������ֻ�ǲ����߳��Ƿ��Ѿ��жϣ��жϱ�ʶλ��״̬�����ܵ��÷�����Ӱ��
 * interrupted()�����ǲ��Ե�ǰ�߳��Ƿ��Ѿ��жϣ��̵߳��жϱ�ʶλ�ɸ÷������
 * @author zhaoliangtao
 *
 */
public class ThreadMethodTest3 {
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new Runnable() {
			public void run() {
				while (true) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("�̱߳��ж���");
						return;// ����жϱ�ʶΪtrue�������߳�
					} else {
						System.out.println("�߳�û�б��ж�");
					}
				}
			}
		};
		Thread t = new Thread(runnable);
		t.start();
		Thread.sleep(3000);
		t.interrupt();
		System.out.println("�߳��ж��ˣ�����������");
	}
}
