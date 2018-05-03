/**
 * ≈≈–Ú£∫√∞≈›°¢—°‘Ò°¢≤Â»Î
 */
package com.zhao.ii;

import java.util.Calendar;

public class Demo2 {
	public static void main(String[] args) {
		int len = 100;
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			int t = (int) (Math.random() * 10000);// ÀÊª˙ ˝
			arr[i] = t;
		}

		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());// ¥Ú”° ±º‰

		Insertion ins = new Insertion();
		ins.sort(arr);

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		cal = Calendar.getInstance();
		System.out.println(cal.getTime());
	}
}

class Insertion {
	// ≤Â»Î≈≈–Ú
	public void sort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int value = arr[i];
			int index = i - 1;
			while (index >= 0 && value < arr[index]) {
				arr[index + 1] = arr[index];
				index--;
			}
			arr[index + 1] = value;
		}
	}
}

class Select {
	// —°‘Ò≈≈–Ú
	public void sort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = arr[i];
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
}

class Bubble {
	// √∞≈›≈≈–Ú
	public void sort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}