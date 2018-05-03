/**
 * gui界面开发
 */
package com.zhao.iv;

import javax.swing.*;

public class Demo1 extends JFrame {

	// 把想要的Swing组件定义到这里
	JButton jb1 = null;

	public static void main(String[] args) {
		// JFrame是一个顶层容器（可以添加其他swing组件的类）
		// JFrame jf = new JFrame();
		Demo1 d1 = new Demo1();
	}

	public Demo1() {// 构造函数
		// 创建一个button按钮
		jb1 = new JButton("我是按钮");
		// 添加JButton组件
		this.add(jb1);

		// 给窗体设置标题
		this.setTitle("hello world!");
		// 设置大小，按像素，长，宽
		this.setSize(500, 200);
		// 设置初始位置
		this.setLocation(100, 200);

		// 设置当关闭窗口的时候，保证jvm也退出
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 显示
		this.setVisible(true);
	}
}
