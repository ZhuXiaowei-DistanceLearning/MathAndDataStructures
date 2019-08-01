package com.zxw.mathCourse;

public class guankui {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(subArrMax(arr, 8));
	}

	/**
	 * 求数组中长度最大的子数组 暴力法
	 * 遍历每一个位置与其他所有位置的组合，最后得出结果
	 * arr[0]+arr[1],arr[0]+arr[1]+arr[2]
	 * arr[1]+arr[2],arr[1]+arr[2]+arr[3]
	 * 时间复杂度O(n^3)
	 * @param arr
	 * @param n   数组长度
	 * @return
	 */
	public static int subArrMax(int[] arr, int n) {
		int currSum;
		int maxSum = arr[0];
		// i 控制数组当前指针的位置
		for (int i = 0; i < n; i++) {
			// j 为从i开始到结束的指针
			for (int j = i; j < n; j++) {
				currSum = 0;
				for (int k = 1; k <= j; k++) {
					// 获取当前数组的最大长度
					// j代表当前位置，当前指针移动到arr[2]
					// 则最大长度为arr[0]+arr[1]+arr[2]
					currSum += arr[k];
				}
				// 比较每一次相加后的值
				if (currSum > maxSum) {
					maxSum = currSum;
				}
			}
		}
		return maxSum;
	}
	/**
	 * 分治法
	 * 要么在左半边，要么在右半边，要么在跨立的分界点上
	 * 左右用递归解决
	 * 分界点:做数组的最大后缀和右数组的最大前缀的和
	 * @return 
	 * 
	 */
	public static double MaxAddSub(double[]arr,int from,int to) {
		if(to == from) {
			return arr[from];
		}
		int middle = (from - to)/2;
//		MaxAddSub(from, middle);
		return (Double) null;
	}

	/**
	 * 分析法
	 */

	/**
	 * 动态规划法
	 */
}
