package com.zhao.v;

//̹����
class Tank {
	// ̹�˵ĺ�x��y����
	int x = 0;
	int y = 0;
	// ̹�˷��� ����0 ��1 ��2 ��3
	int direct = 0;
	// ����̹�˵��ٶ�
	int speed = 2;
	// ̹����ɫ
	int color = 0;

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
class Enemy extends Tank {
	public Enemy(int x, int y) {
		super(x, y);
	}
}

// �ҵ�̹��
class Hero extends Tank {
	public Hero(int x, int y) {
		super(x, y);
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