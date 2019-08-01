package com.zxw.aha;

public class charu {
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 9, 8, 2, 1, 7 };
		crpx(arr);
		for (int i : arr) {
			System.out.print(i);
		}
	}

	/**
	 * 直接插入排序
	 * 
	 * @param arr
	 */
	public static void crpx(int[] arr) {
		int i, j, k;

		for (i = 1; i < arr.length; i++) {
			// 为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
			for (j = i - 1; j >= 0; j--)
				// 当前数及之前的数是否小于这个数
				// 判断当前索引上的数是否比之前的数小，如果小则往前移
				if (arr[j] < arr[i])
					break;
			// 如果当前数的位置与当前索引不相等，则空出位置移动
			if (j != i - 1) {
				// 将比a[i]大的数据向后移
				int temp = arr[i];
				for (k = i - 1; k > j; k--)
					// 将前面的值往后移
					arr[k + 1] = arr[k];
				// 将a[i]放到正确位置上
				arr[k + 1] = temp;
			}
		}
	}
}
