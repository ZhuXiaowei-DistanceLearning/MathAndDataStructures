package com.zxw.chazhao.xianxing;

public class shunxu {
	public static void main(String[] args) {
		int[] arr = new int[] { 70, 30, 40, 10, 80, 20, 90, 100, 75, 60, 45 };
		System.out.println(findIndex(arr, 45));
	}

	public static int findIndex(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return i;
			}
		}
		return -1;
	}
}
