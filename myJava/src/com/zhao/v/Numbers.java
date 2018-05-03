package com.zhao.v;

//坦克类
class Tank {
	// 坦克的横x纵y坐标
	int x = 0;
	int y = 0;
	// 坦克方向 ：上0 下1 左2 右3
	int direct = 0;
	// 设置坦克的速度
	int speed = 2;
	// 坦克颜色
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

// 敌人的坦克
class Enemy extends Tank {
	public Enemy(int x, int y) {
		super(x, y);
	}
}

// 我的坦克
class Hero extends Tank {
	public Hero(int x, int y) {
		super(x, y);
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