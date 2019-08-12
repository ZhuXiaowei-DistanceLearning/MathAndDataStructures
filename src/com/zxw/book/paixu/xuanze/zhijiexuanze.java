package com.zxw.book.paixu.xuanze;

public class zhijiexuanze {
	public static void main(String[] args) {
		int[] arr = new int[] { 70, 30, 40, 10, 80, 20, 90, 100, 75, 60, 45 };
		crpx(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}

	public static void crpx(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
