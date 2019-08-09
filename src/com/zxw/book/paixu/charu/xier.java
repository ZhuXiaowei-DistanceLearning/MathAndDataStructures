package com.zxw.book.paixu.charu;

public class xier {
	public static void main(String[] args) {
		int[] arr = new int[] { 70,30,40,10,80,20,90,100,75,60,45 };
		crpx(arr);
		for (int i : arr) {
			System.out.print(i);
		}
	}

	public static void crpx(int[] arr) {
		int i, j, temp, d; // d为当前增量
		// 增量起始总长度
		int increment = arr.length / 3;
		for (int m = increment; m >= 1; m--) {
			d = m;
			for (i = d; i < arr.length; i++) { // 每一次循环都是比较分割出来的每一组的两个数据
				// 将data[d+1..n]分别插入各组当前的有序区
				int k = arr[i];
				int l = arr[i-d];
				// 判断第一个是否大于二个
				if (arr[i] < arr[i - d]) {
					temp = arr[i];
					j = i;
					do { // 查找data[i]的插入位置
						arr[j] = arr[j - d]; // 后移记录
						j = j - d; // 查找前一记录
						if (j - d < 0) {
							break;
						}
					} while (j > 0 && temp < arr[j - d]); 
					arr[j] = temp; // 插入data[i]到正确的位置上
				}
			}
		}
	}
}
