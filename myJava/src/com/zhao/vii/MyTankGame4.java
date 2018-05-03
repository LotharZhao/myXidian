/**
 * 坦克游戏4.0(未完成)
 * 防止敌人坦克重叠运动
 * 分关
 * 暂停继续游戏
 * 记录游戏进度
 * 添加声音
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

		// 启动线程
		Thread t = new Thread(mp);
		t.start();

		this.add(mp);

		this.addKeyListener(mp);

		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

// 我的面板
class MyPanel extends JPanel implements KeyListener, Runnable {
	// 定义一个我的坦克
	Hero hero = null;

	// 定义敌人的坦克组
	Vector<Enemy> ves = new Vector<Enemy>();
	int vesSize = 3;

	// 定义三张连续爆炸图片
	Image image1, image2, image3;
	// 定义炸弹集合
	Vector<Bomb> bombs = new Vector<Bomb>();

	// 构造函数
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

	// 重载paint
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 500, 300);

		// 画出自己的坦克
		if (hero.isLive == true)
			this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(),
					hero.getColor());

		// 画出子弹
		for (int i = 0; i < hero.ss.size(); i++) {
			Shot MyShot = hero.ss.get(i);
			if (MyShot != null && MyShot.isLive == true) {
				g.draw3DRect(MyShot.x, MyShot.y, 1, 1, false);
			}

			if (MyShot.isLive == false)// 删除消失的子弹
				hero.ss.remove(MyShot);
		}

		// 画出炸弹
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

		// 画出敌人坦克
		for (int i = 0; i < ves.size(); i++) {
			Enemy e = ves.get(i);
			if (e.isLive)
				this.drawTank(e.getX(), e.getY(), g, e.getDirect(),
						e.getColor());
			// 画子弹
			for (int j = 0; j < e.ss.size(); j++) {
				Shot enemyShot = e.ss.get(j);
				if (enemyShot.isLive) {
					g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1, false);
				} else
					e.ss.remove(j);
			}
		}
	}

	// 判断我的子弹是否击中敌人坦克
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

	// 判断敌人的子弹是否击中我的坦克
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

	// 判断子弹是否击中坦克
	public void hitTank(Shot s, Tank e) {
		switch (e.direct) {// 击中
		case 0:
		case 1:
			if (s.x > e.x && s.x < e.x + 20 && s.y > e.y && s.y < e.y + 30) {
				s.isLive = false;
				e.isLive = false;

				// 创建一个炸弹,放入Vector
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
		case 0:// 上
			g.fill3DRect(x, y, 5, 30, false);// 左边的矩形
			g.fill3DRect(x + 15, y, 5, 30, false);// 右边的矩形
			g.fill3DRect(x + 5, y + 5, 10, 20, false);// 中间的矩形
			g.fillOval(x + 4, y + 10, 10, 10);// 中间的圆
			g.drawLine(x + 9, y + 15, x + 9, y - 3);// 直线
			break;
		case 1:// 下
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x + 15, y, 5, 30, false);
			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			g.fillOval(x + 4, y + 10, 10, 10);
			g.drawLine(x + 9, y + 15, x + 9, y + 33);
			break;
		case 2:// 左
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y + 15, 30, 5, false);
			g.fill3DRect(x + 5, y + 5, 20, 10, false);
			g.fillOval(x + 10, y + 4, 10, 10);
			g.drawLine(x - 3, y + 9, x + 15, y + 9);
			break;
		case 3:// 右
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
		// 键按下: 上w 下s 左a 右d
		if (e.getKeyCode() == KeyEvent.VK_W) {
			// 设置我的坦克的方向
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
		// k键加速坦克
		if (e.getKeyCode() == KeyEvent.VK_K)
			hero.setSpeed(2);
		// j键开火
		if (e.getKeyCode() == KeyEvent.VK_J) {
			if (this.hero.ss.size() < 5)// 最多5颗子弹
				this.hero.shotEnemy();
		}
		// 必须要重新绘制panel
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_K)
			hero.setSpeed(1);
	}

	@Override
	public void run() {
		// 每隔100毫秒，重绘
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 判断是否击中敌人
			this.hitEnemy();
			// 判断是否击中我的坦克
			this.hitHero();

			this.repaint();
		}
	}
}