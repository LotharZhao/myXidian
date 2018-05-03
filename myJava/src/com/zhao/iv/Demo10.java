/**
 * 绘图原理
 */
package com.zhao.iv;

import java.awt.*;
import javax.swing.*;

public class Demo10 extends JFrame {

	MyPanel1 mp1 = null;

	public static void main(String[] args) {
		Demo10 d1 = new Demo10();
	}

	public Demo10() {
		mp1 = new MyPanel1();
		this.add(mp1);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

// 定义一个MyPanel1,自己的面板，用于绘图和现实绘图的区域
class MyPanel1 extends JPanel {
	// 重写Jpanel的paint方法,Graphics是绘图的重要类，--画笔
	public void paint(Graphics g) {
		// 调用父类函数，完成初始化,不可少！
		super.paint(g);
		System.out.println("paint被调用");

		g.drawOval(10, 10, 30, 30);// 画圆
		g.drawLine(10, 10, 40, 40);// 直线
		g.drawRect(50, 50, 40, 40);// 矩形
		g.setColor(Color.BLUE);
		g.fillRect(50, 100, 40, 40);// 填充矩形
		g.setColor(Color.RED);
		g.fillOval(50, 150, 40, 40);// 填充圆形

		// 画图片
		Image im = Toolkit.getDefaultToolkit().getImage(
				Panel.class.getResource("images/iv_Demo9.jpg"));// 路径不太对
		g.drawImage(im, 150, 20, 50, 50, this);

		g.setColor(Color.GREEN);
		g.setFont(new Font("楷体", Font.BOLD, 20));
		g.drawString("祖国万岁", 150, 100);

		g.drawArc(150, 150, 100, 200, 10, 100);
	}
}