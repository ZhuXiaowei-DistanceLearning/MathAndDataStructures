package com.zxw.chazhao.xianxing;

public class erfen {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		System.out.println(findIndex(arr, 100));
	}

	public static int findIndex(int[] data, int num) {
		int low = 0;
		int high = data.length - 1;
		int mid = (low + high) / 2;
		int a = data[mid];
		while (low <= high) {
			if (data[mid] == num) {
				return mid;
			} else if (data[mid] < num) {
				low = mid + 1;
				mid = (low + high) / 2;
			} else if (data[mid] > num) {
				high = mid - 1;
				mid = (low + high) / 2;
			}
		}
		return -1;
	}
}
