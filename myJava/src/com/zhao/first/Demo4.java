/*
���ߣ�
���ڣ�
���ܣ����Сè����
*/
package com.zhao.first;
public class Demo4
{
	public static void main(String[] args) 
	{
		/*
		//��һֻè
		int cat1Age = 3;
		String cat1Name = "С��";
		//�ڶ�ֻè
		int��cat2Age = 100;
		String cat2Name = "С��";
		String cat2Color = "��ɫ";
		//...
		*/

		//����һֻè����
		Cat cat1;
		cat1 = new Cat(3);
		//�������� ������.������
		cat1.name = "С��";
		cat1.color = "��ɫ";

		//������ֻè����
		Cat cat2 = new Cat(100,"С��","��ɫ");
		
		Cat cat3;
		cat3 = cat1;
		System.out.println(cat3.age);
		
		Cat cat4;
		cat4 = cat3;
		System.out.println(cat4.name);

		cat4.color = "��ɫ";
		System.out.println(cat1.color+" "+cat3.color+" "+cat4.color);

		//����speak����
		cat2.jiao();
		cat2.jiSuan();
		cat2.jiSuan(1000);
		cat2.add(100,1);
		System.out.println(cat2.addR(10,10));
	}
}

//����һ���ࣨ��������ĸ��д��
class Cat
{
	//Cat��ĳ�Ա����/����
	int age;
	String name;
	String color;

	//���췽��
	public Cat(int age,String name,String color){
		age = age;
		name = name;
		color = color;
		System.out.println("���췽��4");
	}
	public Cat(int age,String name){
		age = age;
		name = name;
		System.out.println("���췽��3");
	}
	public Cat(int age){
		age = age;
		System.out.println("���췽��2");
	}
	public Cat(){
		System.out.println("���췽��");
	}

	//��Ա���� ����ĸСд
	//�����֣�1.�շ巨������������myCat 2.�»��߷� my_cat
	public void jiao(){
		System.out.println("��~");
	}

	public void jiSuan(){
		int result = 0;
		for(int i=1;i<=1000;i++)
			result = result+i;
		System.out.println(result);
	}

	public void jiSuan(int n){
		int result = 0;
		for(int i=1;i<=n;i++)
			result+=i;
		System.out.println(result);
	}

	public void add(int num1,int num2){
		int result = 0;
		result = num1+num2;
		System.out.println(result);
	}

	public int addR(int num1,int num2){
		return num1+num2;
	}
}