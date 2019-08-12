package com.zxw.book.paixu.jiaohuan;

public class kuaisu {
	public static void main(String[] args) {
		int[] arr = new int[] { 70, 30, 40, 10, 80, 20, 90, 100, 75, 60, 45 };
		quickSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public int[] quickSort(int[] data) {
		return quickSort(data, 0, data.length - 1);
	}

	public static int[] quickSort(int[] data, int low, int high) {
		if (low > high) {
			return null;
		}
		int pivot = data[low]; // 将第一个记录作为标准放到临时变量中,使第一个位置腾空
		int i = low + 1; // 指示器low执向顺序表头
		int j = high; // 指示器high执向顺序表的尾
		int temp;
		while (i < j) {
			// 序列左端扫描
			while ((i < j) && pivot >= data[i]) {
				++i;
			}
			// 序列右端扫描
			while ((j >= i) && pivot <= data[j]) {
				--j;
			}
			if (i < j) {
				temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		}
		if (low < j) {
			temp = data[low];
			data[low] = data[j];
			data[j] = temp;
		}
		quickSort(data, low, j - 1);
		quickSort(data, j + 1, high);
		return data;
	}
}
