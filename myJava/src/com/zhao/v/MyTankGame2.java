/**
 * ̹����Ϸ2.0
 * �ƶ�̹��
 * ̹�˼��٣�k����
 */
package com.zhao.v;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Vector;

public class MyTankGame2 extends JFrame {

	MyPanel mp = null;

	public static void main(String[] args) {
		MyTankGame2 mtg2 = new MyTankGame2();
	}

	public MyTankGame2() {
		mp = new MyPanel();

		this.add(mp);

		this.addKeyListener(mp);

		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

// �ҵ����
class MyPanel extends JPanel implements KeyListener {
	// ����һ���ҵ�̹��
	Hero hero = null;

	// ������˵�̹����
	Vector<Enemy> ves = new Vector<Enemy>();
	int vesSize = 3;

	// ���캯��
	public MyPanel() {
		hero = new Hero(50, 200);
		hero.setColor(0);

		for (int i = 0; i < vesSize; i++) {
			Enemy e = new Enemy(i * 70 + 50, 0);
			e.setDirect(1);
			e.setColor(1);
			ves.add(e);
		}
	}

	// ����paint
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 500, 300);

		this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(),
				hero.getColor());

		for (int i = 0; i < ves.size(); i++) {
			this.drawTank(ves.get(i).getX(), ves.get(i).getY(), g, ves.get(i)
					.getDirect(), ves.get(i).getColor());
		}
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
		case 0:// ��
			g.fill3DRect(x, y, 5, 30, false);// ��ߵľ���
			g.fill3DRect(x + 15, y, 5, 30, false);// �ұߵľ���
			g.fill3DRect(x + 5, y + 5, 10, 20, false);// �м�ľ���
			g.fillOval(x + 4, y + 10, 10, 10);// �м��Բ
			g.drawLine(x + 9, y + 15, x + 9, y - 3);// ֱ��
			break;
		case 1:// ��
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x + 15, y, 5, 30, false);
			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			g.fillOval(x + 4, y + 10, 10, 10);
			g.drawLine(x + 9, y + 15, x + 9, y + 33);
			break;
		case 2:// ��
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y + 15, 30, 5, false);
			g.fill3DRect(x + 5, y + 5, 20, 10, false);
			g.fillOval(x + 10, y + 4, 10, 10);
			g.drawLine(x - 3, y + 9, x + 15, y + 9);
			break;
		case 3:// ��
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y + 15, 30, 5, false);
			g.fill3DRect(x + 5, y + 5, 20, 10, false);
			g.fillOval(x + 10, y + 4, 10, 10);
			g.drawLine(x + 15, y + 9, x + 33, y + 9);
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {// ������: ��w ��s ��a ��d
		if (e.getKeyCode() == KeyEvent.VK_W) {
			// �����ҵ�̹�˵ķ���
			this.hero.setDirect(0);
			this.hero.moveUp();
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			this.hero.setDirect(1);
			this.hero.moveDown();
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			this.hero.setDirect(2);
			this.hero.moveLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			this.hero.setDirect(3);
			this.hero.moveRight();
		}
		// k������̹��
		if (e.getKeyCode() == KeyEvent.VK_K)
			hero.setSpeed(2);
		// ����Ҫ���»���panel
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_K)
			hero.setSpeed(1);
	}
}