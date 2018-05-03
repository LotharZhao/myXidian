package com.zhao.vi;

import java.util.Vector;

// 炸弹类
class Bomb {
	int x;
	int y;
	int life = 9;// 炸弹的生命
	boolean isLife = true;

	public Bomb(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 减少生命值
	public void lifeDown() {
		if (life > 0)
			life--;
		else
			this.isLife = false;
	}
}

// 子弹类
class Shot implements Runnable {
	int x;
	int y;
	int direct;
	int speed = 2;
	boolean isLive = true;// 子弹存在

	public Shot(int x, int y, int direct) {
		this.x = x;
		this.y = y;
		this.direct = direct;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			switch (direct) {
			case 0:
				y -= speed;
				break;
			case 1:
				y += speed;
				break;
			case 2:
				x -= speed;
				break;
			case 3:
				x += speed;
				break;
			}
			// 子弹死亡
			if (x < 0 || x > 499 || y < 0 || y > 299) {
				this.isLive = false;
				break;
			}
		}
	}
}

// 坦克类
class Tank {
	// 坦克的横x纵y坐标
	int x = 0;
	int y = 0;
	// 坦克方向 ：上0 下1 左2 右3
	int direct = 0;
	// 设置坦克的速度
	int speed = 1;
	// 坦克颜色
	int color = 0;

	//
	boolean isLive = true;

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

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

// 敌人的坦克
class Enemy extends Tank implements Runnable {
	int times = 0;

	// 子弹
	Vector<Shot> ss = new Vector<Shot>();

	public Enemy(int x, int y) {
		super(x, y);
	}

	@Override
	public void run() {
		while (true) {
			switch (this.direct) {
			case 0:
				for (int i = 0; i < 30; i++) {
					if (y > 0)
						y -= speed;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				break;
			case 1:
				for (int i = 0; i < 30; i++) {
					if (y < 268)
						y += speed;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			case 2:
				for (int i = 0; i < 30; i++) {
					if (x > 0)
						x -= speed;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			case 3:
				for (int i = 0; i < 30; i++) {
					if (x < 468)
						x += speed;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			}

			this.times++;

			// 判断是否需要给敌方加子弹
			if (times % 2 == 0) {
				if (isLive) {
					if (ss.size() < 5) {
						Shot s = null;
						switch (direct) {
						case 0:
							s = new Shot(x + 9, y - 3, 0);
							ss.add(s);
							break;
						case 1:
							s = new Shot(x + 9, y + 33, 1);
							ss.add(s);
							break;
						case 2:
							s = new Shot(x - 3, y + 9, 2);
							ss.add(s);
							break;
						case 3:
							s = new Shot(x + 33, y + 9, 3);
							ss.add(s);
							break;
						}
						Thread t = new Thread(s);
						t.start();
					}
				}
			}

			// 随机改变方向
			this.direct = (int) (Math.random() * 4);

			// 判断敌人坦克死亡
			if (this.isLive == false)
				break;// 坦克死亡后退出线程
		}
	}
}

// 我的坦克
class Hero extends Tank {
	// 子弹
	Vector<Shot> ss = new Vector<Shot>();
	Shot s = null;

	public Hero(int x, int y) {
		super(x, y);
	}

	// 开火
	public void shotEnemy() {
		switch (this.direct) {
		case 0:
			s = new Shot(x + 9, y - 3, 0);// 创建一颗子弹
			ss.add(s);// 把子弹加入向量
			break;
		case 1:
			s = new Shot(x + 9, y + 33, 1);
			ss.add(s);
			break;
		case 2:
			s = new Shot(x - 3, y + 9, 2);
			ss.add(s);
			break;
		case 3:
			s = new Shot(x + 33, y + 9, 3);
			ss.add(s);
			break;
		}
		// 启动子弹线程
		Thread t = new Thread(s);
		t.start();
	}

	// 坦克向上移动
	public void moveUp() {
		y -= speed;
	}

	// 坦克向下移动
	public void moveDown() {
		y += speed;
	}

	// 坦克向左移动
	public void moveLeft() {
		x -= speed;
	}

	// 坦克向右移动
	public void moveRight() {
		x += speed;
	}
}