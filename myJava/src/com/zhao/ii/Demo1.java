/**
 * 一维数组
 */
package com.zhao.ii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		/*float arr[] = new float[6];

		arr[0] = 3;
		arr[1] = 5;
		arr[2] = 1;
		arr[3] = 3.4f;
		arr[4] = 2;
		arr[5] = 50;

		float all = 0;
		for (int i = 0; i < arr.length; i++) {
			all += arr[i];
		}
		System.out.println(all / arr.length);

		int[] arr2;
		arr2 = new int[6];*/
		
		Dog dogs[] = new Dog[4];
		
		/*dogs[0] = new Dog();
		dogs[0].setName("花花");
		dogs[0].setWeight(4.5f);*/
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		for(int i=0;i<dogs.length;i++) {
			dogs[i] = new Dog();
			System.out.print("输入第"+ (i+1) +"个的名字：");
			String name = br.readLine();
			dogs[i].setName(name);
			System.out.print("输入第"+ (i+1) +"个的重量：");
			String s_weight = br.readLine();
			float weight = Float.parseFloat(s_weight);
			dogs[i].setWeight(weight);
		}
		float allWeight = 0;
		for(int i=0;i<dogs.length;i++) {
			allWeight+=dogs[i].getWeight();
		}
		System.out.println(allWeight/dogs.length);
		
		float maxWeight = dogs[0].getWeight();
		int maxIndex = 0;
		for(int i=1;i<dogs.length;i++) {
			if(maxWeight<dogs[i].getWeight()) {
				maxWeight = dogs[i].getWeight();
				maxIndex = i;
			}
		}
		System.out.println("重量最大的是："+dogs[maxIndex].getName()+" "+maxWeight);
		
		System.out.print("输入想要查找的名字：");
		String searchName = br.readLine();
		for(int i=0;i<dogs.length;i++){
			if(searchName.equals(dogs[i].getName())){
				System.out.println(dogs[i].getName()+" "+dogs[i].getWeight());
			}
		}
		
	}
}

class Dog{
	private String name;
	private float weight;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
}