package com.zxw.aha;

/**
 * 希尔排序
 * 
 * @author zxw
 *
 */
public class xier {
	/**
	 * 排序方法
	 */
	public static void sort(int[] arr) {
		// 初始化循环间隔
		int h = 1;
		// 计算最大间隔
		while (h < arr.length / 3) {
			h = h * 3 + 1;
		}

		while (h > 0) {
			// 进行插入排序
			// 减小间隔
			h = (h - 1) / 3;
		}
	}
}
