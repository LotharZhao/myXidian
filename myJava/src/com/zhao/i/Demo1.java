/**
 * ���ܣ��̳�
 */
package com.zhao.i;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pupil p1 = new Pupil();
		p1.printName();
	}

}

// ��ѧ���Ĺ��������������һ������
class Stu {
	// �����Ա����
	public int age;
	public String name;
	public float fee;// ѧ��
	
	public void printName(){
		System.out.println("ѧ������"+name);
	}
}

// Сѧ����
class Pupil extends Stu {
	// ��ѧ��
	public void pay(float fee) {
		this.fee = fee;
	}
}

// ��ѧ����
class MiddleStu extends Stu {
	public void pay(float fee) {
		this.fee = fee * 0.8f;
	}
}

// ��ѧ����
class ColStu extends Stu {
	public void pay(float fee) {
		this.fee = fee * 0.1f;
	}
}