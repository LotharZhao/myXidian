/**
 * ̹����Ϸ4.0(δ���)
 * ��ֹ����̹���ص��˶�
 * �ֹ�
 * ��ͣ������Ϸ
 * ��¼��Ϸ����
 * �������
 */
package com.zhao.vii;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.Vector;

public class MyTankGame4 extends JFrame {

	MyPanel mp = null;

	public static void main(String[] args) {
		MyTankGame4 mtg4 = new MyTankGame4();
	}

	public MyTankGame4() {
		mp = new MyPanel();

		// �����߳�
		Thread t = new Thread(mp);
		t.start();

		this.add(mp);

		this.addKeyListener(mp);

		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

// �ҵ����
class MyPanel extends JPanel implements KeyListener, Runnable {
	// ����һ���ҵ�̹��
	Hero hero = null;

	// ������˵�̹����
	Vector<Enemy> ves = new Vector<Enemy>();
	int vesSize = 3;

	// ��������������ըͼƬ
	Image image1, image2, image3;
	// ����ը������
	Vector<Bomb> bombs = new Vector<Bomb>();

	// ���캯��
	public MyPanel() {
		hero = new Hero(50, 200);
		hero.setColor(0);

		for (int i = 0; i < vesSize; i++) {
			Enemy e = new Enemy(i * 70 + 50, 0);
			e.setDirect(1);
			e.setColor(1);
			Thread t = new Thread(e);
			t.start();

			Shot s = new Shot(e.x + 9, e.y + 33, 1);
			e.ss.add(s);
			Thread t2 = new Thread(s);
			t2.start();

			ves.add(e);
		}

		try {
			image1 = ImageIO.read(new File(
					"E:/myCode/myJava/images/bomb_1.gif"));
			image2 = ImageIO.read(new File(
					"E:/myCode/myJava/images/bomb_2.gif"));
			image3 = ImageIO.read(new File(
					"E:/myCode/myJava/images/bomb_3.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ����paint
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 500, 300);

		// �����Լ���̹��
		if (hero.isLive == true)
			this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(),
					hero.getColor());

		// �����ӵ�
		for (int i = 0; i < hero.ss.size(); i++) {
			Shot MyShot = hero.ss.get(i);
			if (MyShot != null && MyShot.isLive == true) {
				g.draw3DRect(MyShot.x, MyShot.y, 1, 1, false);
			}

			if (MyShot.isLive == false)// ɾ����ʧ���ӵ�
				hero.ss.remove(MyShot);
		}

		// ����ը��
		for (int i = 0; i < bombs.size(); i++) {
			Bomb b = bombs.get(i);
			if (b.life > 6)
				g.drawImage(image1, b.x, b.y, 30, 30, this);
			else if (b.life > 3)
				g.drawImage(image2, b.x, b.y, 30, 30, this);
			else
				g.drawImage(image3, b.x, b.y, 30, 30, this);

			b.lifeDown();
			if (b.life == 0)
				bombs.remove(b);
		}

		// ��������̹��
		for (int i = 0; i < ves.size(); i++) {
			Enemy e = ves.get(i);
			if (e.isLive)
				this.drawTank(e.getX(), e.getY(), g, e.getDirect(),
						e.getColor());
			// ���ӵ�
			for (int j = 0; j < e.ss.size(); j++) {
				Shot enemyShot = e.ss.get(j);
				if (enemyShot.isLive) {
					g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1, false);
				} else
					e.ss.remove(j);
			}
		}
	}

	// �ж��ҵ��ӵ��Ƿ���е���̹��
	public void hitEnemy() {
		for (int i = 0; i < hero.ss.size(); i++) {
			Shot s = hero.ss.get(i);
			if (s.isLive) {
				for (int j = 0; j < ves.size(); j++) {
					Enemy e = ves.get(j);
					if (e.isLive)
						hitTank(s, e);
				}
			}
		}
	}

	// �жϵ��˵��ӵ��Ƿ�����ҵ�̹��
	public void hitHero() {
		for (int i = 0; i < ves.size(); i++) {
			Enemy e = ves.get(i);
			for (int j = 0; j < e.ss.size(); j++) {
				Shot s = e.ss.get(j);
				if (hero.isLive)
					this.hitTank(s, hero);
			}
		}
	}

	// �ж��ӵ��Ƿ����̹��
	public void hitTank(Shot s, Tank e) {
		switch (e.direct) {// ����
		case 0:
		case 1:
			if (s.x > e.x && s.x < e.x + 20 && s.y > e.y && s.y < e.y + 30) {
				s.isLive = false;
				e.isLive = false;

				// ����һ��ը��,����Vector
				Bomb b = new Bomb(e.x, e.y);
				bombs.add(b);
			}
			break;
		case 2:
		case 3:
			if (s.x > e.x && s.x < e.x + 30 && s.y > e.y && s.y < e.y + 20) {
				s.isLive = false;
				e.isLive = false;

				Bomb b = new Bomb(e.x, e.y);
				bombs.add(b);
			}
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
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// ������: ��w ��s ��a ��d
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
		// j������
		if (e.getKeyCode() == KeyEvent.VK_J) {
			if (this.hero.ss.size() < 5)// ���5���ӵ�
				this.hero.shotEnemy();
		}
		// ����Ҫ���»���panel
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_K)
			hero.setSpeed(1);
	}

	@Override
	public void run() {
		// ÿ��100���룬�ػ�
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// �ж��Ƿ���е���
			this.hitEnemy();
			// �ж��Ƿ�����ҵ�̹��
			this.hitHero();

			this.repaint();
		}
	}
}