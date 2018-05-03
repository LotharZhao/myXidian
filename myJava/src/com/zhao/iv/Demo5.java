/**
 * 多种布局管理器
 */
package com.zhao.iv;

import java.awt.*;
import javax.swing.*;

public class Demo5 extends JFrame {

	JPanel jp1, jp2;// Jpanel布局默认FlowLayout
	JButton jb1, jb2, jb3, jb4, jb5, jb6;

	public static void main(String[] args) {
		Demo5 d5 = new Demo5();
	}

	public Demo5() {
		jp1 = new JPanel();
		jp2 = new JPanel();

		jb1 = new JButton("按钮1");
		jb2 = new JButton("按钮2");
		jb3 = new JButton("按钮3");
		jb4 = new JButton("按钮4");
		jb5 = new JButton("按钮5");
		jb6 = new JButton("按钮6");

		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);

		this.add(jp1, BorderLayout.NORTH);
		this.add(jb6, BorderLayout.CENTER);
		this.add(jp2, BorderLayout.SOUTH);

		this.setTitle("复杂布局案例");
		this.setSize(400, 300);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}
}
