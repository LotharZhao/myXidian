/**
 * �¼��������1
 * ��ť��ɫ
 */
package com.zhao.v;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Demo1 extends JFrame implements ActionListener {

	JPanel mp2 = null;
	JButton jb1, jb2;

	public static void main(String[] args) {
		Demo1 d2 = new Demo1();
	}

	public Demo1() {
		mp2 = new JPanel();
		jb1 = new JButton("��ɫ");
		jb2 = new JButton("��ɫ");// �¼�Դ����

		this.add(jb1, BorderLayout.NORTH);
		this.add(mp2);
		this.add(jb2, BorderLayout.SOUTH);

		// ע�����
		jb1.addActionListener(this);
		jb2.addActionListener(this);// this�¼�������
		// ָ��action����
		jb1.setActionCommand("��ɫ");
		jb2.setActionCommand("��ɫ");

		Cat myCat1 = new Cat();
		jb1.addActionListener(myCat1);// myCat1�¼�������
		Cat myCat2 = new Cat();
		jb1.addActionListener(myCat2);
		jb2.addActionListener(myCat2);// myCat2�¼�������

		this.setSize(200, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {// �¼�������
		// �жϰ�ť
		if (e.getActionCommand().equals("��ɫ")) {
			System.out.println("��ɫ");
			mp2.setBackground(Color.BLACK);
		} else if (e.getActionCommand().equals("��ɫ")) {
			System.out.println("��ɫ");
			mp2.setBackground(Color.RED);
		} else {
			System.out.println("no");
		}
	}
}

class Cat implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {// �¼�������
		if (e.getActionCommand().equals("��ɫ")) {
			System.out.println("��ɫèè");
		} else if (e.getActionCommand().equals("��ɫ")) {
			System.out.println("��ɫèè");
		} else {
			System.out.println("no");
		}
	}
}