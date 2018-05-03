/**
 * ��ͼԭ��
 */
package com.zhao.iv;

import java.awt.*;
import javax.swing.*;

public class Demo10 extends JFrame {

	MyPanel1 mp1 = null;

	public static void main(String[] args) {
		Demo10 d1 = new Demo10();
	}

	public Demo10() {
		mp1 = new MyPanel1();
		this.add(mp1);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

// ����һ��MyPanel1,�Լ�����壬���ڻ�ͼ����ʵ��ͼ������
class MyPanel1 extends JPanel {
	// ��дJpanel��paint����,Graphics�ǻ�ͼ����Ҫ�࣬--����
	public void paint(Graphics g) {
		// ���ø��ຯ������ɳ�ʼ��,�����٣�
		super.paint(g);
		System.out.println("paint������");

		g.drawOval(10, 10, 30, 30);// ��Բ
		g.drawLine(10, 10, 40, 40);// ֱ��
		g.drawRect(50, 50, 40, 40);// ����
		g.setColor(Color.BLUE);
		g.fillRect(50, 100, 40, 40);// ������
		g.setColor(Color.RED);
		g.fillOval(50, 150, 40, 40);// ���Բ��

		// ��ͼƬ
		Image im = Toolkit.getDefaultToolkit().getImage(
				Panel.class.getResource("images/iv_Demo9.jpg"));// ·����̫��
		g.drawImage(im, 150, 20, 50, 50, this);

		g.setColor(Color.GREEN);
		g.setFont(new Font("����", Font.BOLD, 20));
		g.drawString("�������", 150, 100);

		g.drawArc(150, 150, 100, 200, 10, 100);
	}
}