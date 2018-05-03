/**
 * ̹����Ϸ1.0
 * ��̹��
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

// �ҵ����
class MyPanel extends JPanel {
	// ����һ���ҵ�̹��
	Hero hero = null;

	// ���캯��
	public MyPanel(int x, int y) {
		hero = new Hero(x, y);
	}

	// ����paint
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 400, 300);

		this.drawTank(hero.getX(), hero.getY(), g, 0, 0);
	}

	// �����ҵ�̹�˵ĺ���
	public void drawTank(int x, int y, Graphics g, int direct, int type) {
		switch (type) {// �ж�����
		case 0:
			g.setColor(Color.CYAN);
			break;
		case 1:
			g.setColor(Color.YELLOW);
			break;
		}
		switch (direct) {// �жϷ���
		case 0:
			g.fill3DRect(x, y, 5, 30, false);// ��ߵľ���
			g.fill3DRect(x + 15, y, 5, 30, false);// �ұߵľ���
			g.fill3DRect(x + 5, y + 5, 10, 20, false);// �м�ľ���
			g.fillOval(x + 4, y + 10, 10, 10);// �м��Բ
			g.drawLine(x + 9, y + 15, x + 9, y - 3);// ֱ��
			break;

		default:
			break;
		}
	}
}

// ̹����
class Tank {
	int x = 0;// ̹�˵ĺ�����
	int y = 0;// ������

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

// �ҵ�̹��
class Hero extends Tank {
	public Hero(int x, int y) {
		super(x, y);
	}
}