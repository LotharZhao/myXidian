/**
 * 功能：继承
 */
package com.zhao.i;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pupil p1 = new Pupil();
		p1.printName();
	}

}

// 将学生的共有属性提出，做一个父类
class Stu {
	// 定义成员属性
	public int age;
	public String name;
	public float fee;// 学费
	
	public void printName(){
		System.out.println("学生名："+name);
	}
}

// 小学生类
class Pupil extends Stu {
	// 交学费
	public void pay(float fee) {
		this.fee = fee;
	}
}

// 中学生类
class MiddleStu extends Stu {
	public void pay(float fee) {
		this.fee = fee * 0.8f;
	}
}

// 大学生类
class ColStu extends Stu {
	public void pay(float fee) {
		this.fee = fee * 0.1f;
	}
}