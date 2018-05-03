/**
 * FlowLayout流式布局
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
		jb1 = new JButton("按钮1");
		jb2 = new JButton("按钮2");
		jb3 = new JButton("按钮3");
		jb4 = new JButton("按钮4");
		jb5 = new JButton("按钮5");
		jb6 = new JButton("按钮6");

		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);

		// 设置布局管理器
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));

		this.setTitle("流式布局案例");
		this.setSize(400, 300);
		this.setLocation(200, 200);
		//禁止用户改变窗体大小
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}
}
