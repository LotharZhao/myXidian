/**
 * FlowLayout��ʽ����
 */
package com.zhao.iv;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo3 extends JFrame {

	JButton jb1, jb2, jb3, jb4, jb5, jb6;

	public static void main(String[] args) {
		Demo3 d3 = new Demo3();
	}

	public Demo3() {
		jb1 = new JButton("��ť1");
		jb2 = new JButton("��ť2");
		jb3 = new JButton("��ť3");
		jb4 = new JButton("��ť4");
		jb5 = new JButton("��ť5");
		jb6 = new JButton("��ť6");

		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);

		// ���ò��ֹ�����
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));

		this.setTitle("��ʽ���ְ���");
		this.setSize(400, 300);
		this.setLocation(200, 200);
		//��ֹ�û��ı䴰���С
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}
}
