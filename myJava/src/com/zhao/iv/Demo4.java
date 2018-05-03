/**
 * GridLayout网格布局
 */
package com.zhao.iv;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo4 extends JFrame {

	int size = 9;
	JButton jbs[] = new JButton[size];

	public static void main(String[] args) {
		Demo4 d4 = new Demo4();
	}

	public Demo4() {
		for (int i = 0; i < size; i++) {
			jbs[i] = new JButton(String.valueOf(i));
		}
		this.setLayout(new GridLayout(3, 3, 10, 50));

		for (int i = 0; i < size; i++) {
			this.add(jbs[i]);
		}
		this.setTitle("网格布局案例");
		this.setSize(400, 300);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}
}
