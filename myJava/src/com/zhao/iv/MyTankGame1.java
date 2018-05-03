/**
 * 坦克游戏1.0
 * 画坦克
 */
package com.zhao.iv;

import java.awt.*;
import javax.swing.*;

public class MyTankGame1 extends JFrame {

	MyPanel mp = null;

	public static void main(String[] args) {
		MyTankGame1 mtg1 = new MyTankGame1();
	}

	public MyTankGame1() {
		mp = new MyPanel(20, 200);
		this.add(mp);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

// 我的面板
class MyPanel extends JPanel {
	// 定义一个我的坦克
	Hero hero = null;

	// 构造函数
	public MyPanel(int x, int y) {
		hero = new Hero(x, y);
	}

	// 重载paint
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 400, 300);

		this.drawTank(hero.getX(), hero.getY(), g, 0, 0);
	}

	// 画出我的坦克的函数
	public void drawTank(int x, int y, Graphics g, int direct, int type) {
		switch (type) {// 判断类型
		case 0:
			g.setColor(Color.CYAN);
			break;
		case 1:
			g.setColor(Color.YELLOW);
			break;
		}
		switch (direct) {// 判断方向
		case 0:
			g.fill3DRect(x, y, 5, 30, false);// 左边的矩形
			g.fill3DRect(x + 15, y, 5, 30, false);// 右边的矩形
			g.fill3DRect(x + 5, y + 5, 10, 20, false);// 中间的矩形
			g.fillOval(x + 4, y + 10, 10, 10);// 中间的圆
			g.drawLine(x + 9, y + 15, x + 9, y - 3);// 直线
			break;

		default:
			break;
		}
	}
}

// 坦克类
class Tank {
	int x = 0;// 坦克的横坐标
	int y = 0;// 纵坐标

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// 我的坦克
class Hero extends Tank {
	public Hero(int x, int y) {
		super(x, y);
	}
}