package com.zxw.book.paixu.charu;

public class zhijiecharu {
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 9, 8, 2, 1, 7 };
		crpx(arr);
		for (int i : arr) {
			System.out.print(i);
		}
	}

	public static void crpx(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			// 判断无序区的第一个元素是否小于有序区的最后一个元素
			if (arr[i] < arr[i - 1]) {
				int temp = arr[i];
				int j = 0;
				for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
					arr[j + 1] = arr[j];
				}
				// 当temp比当前数大的时候，将temp插入进当前位置的后一个位置中
				arr[j + 1] = temp;
			}
		}
	}
}
