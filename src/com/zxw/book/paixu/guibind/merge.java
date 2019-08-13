package com.zxw.book.paixu.guibind;

public class merge {
	public static void main(String[] args) {
		int[] arr = new int[] { 70, 30, 40, 10, 80, 20, 90, 100, 75, 60, 45 };
		mergeSort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static int[] mergeSort(int[] data) {
		int k = 1; // 归并增量
		while (k < data.length) {
			mergeSort(data, k);
			k *= 2;
		}
		return data;
	}

	public static void mergeSort(int[] data, int len) {
		int m = 0; // 临时顺序表的起始位置
		int l1 = 0; // 第1个有序表的起始位置
		int h1; // 第1个有序表的结束位置
		int l2; // 第2个有序表的起始位置
		int h2; // 第2个有序表的结束位置
		int i = 0;
		int j = 0;
		// 临时表
		int[] tmp = new int[data.length];
		// 归并处理
		while (l1 + len < data.length) {
			l2 = l1 + len; // 第2个有序表的起始位置
			h1 = l2 - 1; // 第1个有序表的结束位置
			// 第2个有序表的结束位置
			h2 = (l2 + len - 1 < data.length) ? 12 + len - 1 : data.length - 1;
			j = l2;
			i = l1;
			// 两个有序表中的记录没有排序
			while ((i <= h1) && (j <= h2)) {
				// 第1个有序表记录的关键码小于第2个有序表记录的关键码
				if (data[i] <= data[j]) {
					tmp[m++] = data[i++];
				}
				// 第2个有序表记录的关键码小于第1个有序记录的关键码
				else {
					tmp[m++] = data[j++];
				}
			}
			// 第1个有序表中海油记录没有排序
			while (i <= h1) {
				tmp[m++] = data[i++];
			}
			// 第2个有序表中海油记录没有排序
			while (j <= h2) {
				tmp[m++] = data[j++];
			}
			l1 = h2 + 1;
		}
		i = l1;
		// 原顺序表中海油记录没有排序
		while (i < data.length) {
			tmp[m++] = data[i++];
		}
		// 临时顺序表中的记录复制到原顺序，使原顺序表中的记录有序
		for (i = 0; i < data.length; i++) {
			data[i] = tmp[i];
		}
	}
}
