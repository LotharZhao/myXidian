/**
 * gui���濪��
 */
package com.zhao.iv;

import javax.swing.*;

public class Demo1 extends JFrame {

	// ����Ҫ��Swing������嵽����
	JButton jb1 = null;

	public static void main(String[] args) {
		// JFrame��һ�����������������������swing������ࣩ
		// JFrame jf = new JFrame();
		Demo1 d1 = new Demo1();
	}

	public Demo1() {// ���캯��
		// ����һ��button��ť
		jb1 = new JButton("���ǰ�ť");
		// ���JButton���
		this.add(jb1);

		// ���������ñ���
		this.setTitle("hello world!");
		// ���ô�С�������أ�������
		this.setSize(500, 200);
		// ���ó�ʼλ��
		this.setLocation(100, 200);

		// ���õ��رմ��ڵ�ʱ�򣬱�֤jvmҲ�˳�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ��ʾ
		this.setVisible(true);
	}
}
