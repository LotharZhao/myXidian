/**
 * 常用组件2
 */
package com.zhao.iv;

import java.awt.*;
import javax.swing.*;

public class Demo7 extends JFrame {

	JPanel jp1, jp2, jp3;
	JButton jb1, jb2;
	JLabel jlb1, jlb2;
	JCheckBox jcb1, jcb2, jcb3;
	JRadioButton jrb1, jrb2;
	ButtonGroup bg;

	public static void main(String[] args) {
		Demo7 d7 = new Demo7();
	}

	public Demo7() {
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jb1 = new JButton("注册");
		jb2 = new JButton("重置");

		jlb1 = new JLabel("喜欢的运动");
		jlb2 = new JLabel("性别");

		jcb1 = new JCheckBox("足球");
		jcb2 = new JCheckBox("篮球");
		jcb3 = new JCheckBox("网球");

		jrb1 = new JRadioButton("男");
		jrb2 = new JRadioButton("女");

		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);

		this.setLayout(new GridLayout(3, 1));

		jp1.add(jlb1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		jp2.add(jlb2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		jp3.add(jb1);
		jp3.add(jb2);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);

		this.setTitle("注册界面");
		this.setSize(300, 150);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
