/**
 * 二分查找
 */
package com.zhao.ii;

public class Demo3 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Binary bf = new Binary();
		bf.find(0, arr.length - 1, 9, arr);
	}
}

class Binary {
	public void find(int leftIndex, int rightIndex, int value, int arr[]) {
		int midIndex = (rightIndex + leftIndex) / 2;
		int midIndexValue = arr[midIndex];

		if (leftIndex <= rightIndex) {
			if (midIndexValue > value)
				find(leftIndex, midIndex - 1, value, arr);
			else if (midIndexValue < value)
				find(midIndex + 1, rightIndex, value, arr);
			else if (midIndexValue == value)
				System.out.println("找到下标：" + midIndex);
		}
	}
}