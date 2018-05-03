package com.zhao.i;

import javax.swing.*;

public class Demo2 extends JFrame {
	
	public static void main(String[] args) {
//		Demo2 d = new Demo2();
		Abc abc = new Abc();
		System.out.println(abc.getMax(10.2, 2.01));
	}

	/*public Demo2() {
		this.setVisible(true);
		this.setSize(200, 200);
	}*/
}

class Abc{
	public int getMax(int i,int j){
		if(i>j)
			return i;
		else
			return j;
	}
	
	public float getMax(float i,float j){
		if(i>j)
			return i;
		else
			return j;
	}
	
	public float getMax(double i,double j){
		if(i>j)
			return (float)i;
		else
			return (float)j;
	}
}
