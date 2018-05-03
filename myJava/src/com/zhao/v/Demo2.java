/**
 * �¼��������2
 * ����С��
 */
package com.zhao.v;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Demo2 extends JFrame {

	Mypanel2 mp3 = null;

	public static void main(String[] args) {
		Demo2 d3 = new Demo2();
	}

	public Demo2() {
		mp3 = new Mypanel2();

		this.add(mp3);

		this.addKeyListener(mp3);

		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class Mypanel2 extends JPanel implements KeyListener {
	int x = 10;
	int y = 10;

	public void paint(Graphics g) {
		super.paint(g);

		g.fillOval(x, y, 10, 10);
	}

	@Override
	public void keyTyped(KeyEvent e) {// ����һ��ֵ�����
	}

	@Override
	public void keyPressed(KeyEvent e) {// ��������
	// System.out.println(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			y += 5;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			y -= 5;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 5;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 5;
		}
		// �ػ����
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {// �����ͷ�
	}
}