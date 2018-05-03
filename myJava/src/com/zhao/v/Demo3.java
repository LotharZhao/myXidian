/**
 * �¼��������3
 */
package com.zhao.v;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Demo3 extends JFrame {

	MyPanel3 mp4 = null;

	public static void main(String[] args) {
		Demo3 d4 = new Demo3();
	}

	public Demo3() {
		mp4 = new MyPanel3();

		this.add(mp4);

		// ע�����
		this.addMouseListener(mp4);
		this.addKeyListener(mp4);
		this.addMouseMotionListener(mp4);
		this.addWindowListener(mp4);

		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class MyPanel3 extends JPanel implements MouseListener, KeyListener,
		MouseMotionListener, WindowListener {
	public void paint(Graphics g) {
		super.paint(g);
	}

	// ���
	@Override
	public void mouseClicked(MouseEvent e) {// ���
		System.out.println("λ�ã�(" + e.getX() + "," + e.getY() + ")");
	}

	@Override
	public void mousePressed(MouseEvent e) {// ����
	}

	@Override
	public void mouseReleased(MouseEvent e) {// �ɿ�
	}

	@Override
	public void mouseEntered(MouseEvent e) {// �ƶ���MyPanel
		System.out.println("�������");
	}

	@Override
	public void mouseExited(MouseEvent e) {// �뿪MyPanel
		System.out.println("�������");
	}

	// ����
	@Override
	public void keyTyped(KeyEvent e) {// ���ֵ
		System.out.println(e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {// ����
	}

	@Override
	public void keyReleased(KeyEvent e) {// �ɿ�
	}

	// MouseMotionListener
	@Override
	public void mouseDragged(MouseEvent e) {// �����ק
	}

	@Override
	public void mouseMoved(MouseEvent e) {// ����ƶ�
		System.out.println("λ�ã�(" + e.getX() + "," + e.getY() + ")");
	}

	// WindowListener
	@Override
	public void windowOpened(WindowEvent e) {// ���ڴ�
		System.out.println("���ڴ�");
	}

	@Override
	public void windowClosing(WindowEvent e) {// �������ڹر�
		System.out.println("�������ڹر�");
	}

	@Override
	public void windowClosed(WindowEvent e) {// ���ڹر���
		System.out.println("���ڹر���");
	}

	@Override
	public void windowIconified(WindowEvent e) {// ������С��
		System.out.println("������С��");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {// �������
		System.out.println("�������");
	}

	@Override
	public void windowActivated(WindowEvent e) {// ���ڼ���
		System.out.println("���ڼ���");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}