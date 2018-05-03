/**
 * 事件处理机制1
 * 按钮变色
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
		jb1 = new JButton("黑色");
		jb2 = new JButton("红色");// 事件源对象

		this.add(jb1, BorderLayout.NORTH);
		this.add(mp2);
		this.add(jb2, BorderLayout.SOUTH);

		// 注册监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);// this事件监听者
		// 指定action命令
		jb1.setActionCommand("黑色");
		jb2.setActionCommand("红色");

		Cat myCat1 = new Cat();
		jb1.addActionListener(myCat1);// myCat1事件监听者
		Cat myCat2 = new Cat();
		jb1.addActionListener(myCat2);
		jb2.addActionListener(myCat2);// myCat2事件监听者

		this.setSize(200, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {// 事件处理方法
		// 判断按钮
		if (e.getActionCommand().equals("黑色")) {
			System.out.println("黑色");
			mp2.setBackground(Color.BLACK);
		} else if (e.getActionCommand().equals("红色")) {
			System.out.println("红色");
			mp2.setBackground(Color.RED);
		} else {
			System.out.println("no");
		}
	}
}

class Cat implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {// 事件处理方法
		if (e.getActionCommand().equals("黑色")) {
			System.out.println("黑色猫猫");
		} else if (e.getActionCommand().equals("红色")) {
			System.out.println("红色猫猫");
		} else {
			System.out.println("no");
		}
	}
}