package com.zxw.aha;

public class zhijie {
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 9, 8, 2, 1, 7 };
		sort(arr);
		for (int i : arr) {
			System.out.print(i);
		}
	}

	/**
	 * 从小到大排列
	 * @param arr
	 */
	public static void sort(int[] arr) {
		int k = 0;
		int tmp = 0;
		// 每一趟循环固定一个最小值在前面,此循环控制每个位置
		for (int i = 0; i < arr.length - 1; i++) {
			k = i;
			// 此循环控制
			for (int j = i; j < arr.length; j++) {
				// 判断后一位是否比前一位数小，如果小，就将索引定位在此
				if (arr[j] < arr[k]) {
					k = j;
				}
			}
			// 循环结束得到最小值的坐标，进行交换
			tmp = arr[i];
			arr[i] = arr[k];
			arr[k] = tmp;
		}
	}
}
