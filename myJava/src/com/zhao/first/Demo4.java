/*
作者：
日期：
功能：完成小猫问题
*/
package com.zhao.first;
public class Demo4
{
	public static void main(String[] args) 
	{
		/*
		//第一只猫
		int cat1Age = 3;
		String cat1Name = "小白";
		//第二只猫
		int　cat2Age = 100;
		String cat2Name = "小花";
		String cat2Color = "花色";
		//...
		*/

		//创建一只猫对象
		Cat cat1;
		cat1 = new Cat(3);
		//访问属性 对象名.属性名
		cat1.name = "小白";
		cat1.color = "白色";

		//创建二只猫对象
		Cat cat2 = new Cat(100,"小花","花色");
		
		Cat cat3;
		cat3 = cat1;
		System.out.println(cat3.age);
		
		Cat cat4;
		cat4 = cat3;
		System.out.println(cat4.name);

		cat4.color = "灰色";
		System.out.println(cat1.color+" "+cat3.color+" "+cat4.color);

		//调用speak方法
		cat2.jiao();
		cat2.jiSuan();
		cat2.jiSuan(1000);
		cat2.add(100,1);
		System.out.println(cat2.addR(10,10));
	}
}

//定义一个类（类名首字母大写）
class Cat
{
	//Cat类的成员变量/属性
	int age;
	String name;
	String color;

	//构造方法
	public Cat(int age,String name,String color){
		age = age;
		name = name;
		color = color;
		System.out.println("构造方法4");
	}
	public Cat(int age,String name){
		age = age;
		name = name;
		System.out.println("构造方法3");
	}
	public Cat(int age){
		age = age;
		System.out.println("构造方法2");
	}
	public Cat(){
		System.out.println("构造方法");
	}

	//成员方法 首字母小写
	//定名字：1.驼峰法（匈牙利法）myCat 2.下划线法 my_cat
	public void jiao(){
		System.out.println("喵~");
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