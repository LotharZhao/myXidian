package com.zhao.vi;

import java.util.Vector;

// ը����
class Bomb {
	int x;
	int y;
	int life = 9;// ը��������
	boolean isLife = true;

	public Bomb(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// ��������ֵ
	public void lifeDown() {
		if (life > 0)
			life--;
		else
			this.isLife = false;
	}
}

// �ӵ���
class Shot implements Runnable {
	int x;
	int y;
	int direct;
	int speed = 2;
	boolean isLive = true;// �ӵ�����

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
			// �ӵ�����
			if (x < 0 || x > 499 || y < 0 || y > 299) {
				this.isLive = false;
				break;
			}
		}
	}
}

// ̹����
class Tank {
	// ̹�˵ĺ�x��y����
	int x = 0;
	int y = 0;
	// ̹�˷��� ����0 ��1 ��2 ��3
	int direct = 0;
	// ����̹�˵��ٶ�
	int speed = 1;
	// ̹����ɫ
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

// ���˵�̹��
class Enemy extends Tank implements Runnable {
	int times = 0;

	// �ӵ�
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

			// �ж��Ƿ���Ҫ���з����ӵ�
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

			// ����ı䷽��
			this.direct = (int) (Math.random() * 4);

			// �жϵ���̹������
			if (this.isLive == false)
				break;// ̹���������˳��߳�
		}
	}
}

// �ҵ�̹��
class Hero extends Tank {
	// �ӵ�
	Vector<Shot> ss = new Vector<Shot>();
	Shot s = null;

	public Hero(int x, int y) {
		super(x, y);
	}

	// ����
	public void shotEnemy() {
		switch (this.direct) {
		case 0:
			s = new Shot(x + 9, y - 3, 0);// ����һ���ӵ�
			ss.add(s);// ���ӵ���������
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
		// �����ӵ��߳�
		Thread t = new Thread(s);
		t.start();
	}

	// ̹�������ƶ�
	public void moveUp() {
		y -= speed;
	}

	// ̹�������ƶ�
	public void moveDown() {
		y += speed;
	}

	// ̹�������ƶ�
	public void moveLeft() {
		x -= speed;
	}

	// ̹�������ƶ�
	public void moveRight() {
		x += speed;
	}
}