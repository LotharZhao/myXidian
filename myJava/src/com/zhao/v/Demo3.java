/**
 * 事件处理机制3
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

		// 注册监听
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

	// 鼠标
	@Override
	public void mouseClicked(MouseEvent e) {// 点击
		System.out.println("位置：(" + e.getX() + "," + e.getY() + ")");
	}

	@Override
	public void mousePressed(MouseEvent e) {// 按下
	}

	@Override
	public void mouseReleased(MouseEvent e) {// 松开
	}

	@Override
	public void mouseEntered(MouseEvent e) {// 移动到MyPanel
		System.out.println("鼠标来了");
	}

	@Override
	public void mouseExited(MouseEvent e) {// 离开MyPanel
		System.out.println("鼠标走了");
	}

	// 键盘
	@Override
	public void keyTyped(KeyEvent e) {// 输出值
		System.out.println(e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {// 按下
	}

	@Override
	public void keyReleased(KeyEvent e) {// 松开
	}

	// MouseMotionListener
	@Override
	public void mouseDragged(MouseEvent e) {// 鼠标拖拽
	}

	@Override
	public void mouseMoved(MouseEvent e) {// 鼠标移动
		System.out.println("位置：(" + e.getX() + "," + e.getY() + ")");
	}

	// WindowListener
	@Override
	public void windowOpened(WindowEvent e) {// 窗口打开
		System.out.println("窗口打开");
	}

	@Override
	public void windowClosing(WindowEvent e) {// 窗口正在关闭
		System.out.println("窗口正在关闭");
	}

	@Override
	public void windowClosed(WindowEvent e) {// 窗口关闭了
		System.out.println("窗口关闭了");
	}

	@Override
	public void windowIconified(WindowEvent e) {// 窗口最小化
		System.out.println("窗口最小化");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {// 窗口最大化
		System.out.println("窗口最大化");
	}

	@Override
	public void windowActivated(WindowEvent e) {// 窗口激活
		System.out.println("窗口激活");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}