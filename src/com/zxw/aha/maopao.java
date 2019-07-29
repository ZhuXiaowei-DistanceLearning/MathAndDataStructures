package com.zxw.aha;

/**
 * 冒泡排序算法
 * 
 * @author zxw
 *
 */
public class maopao {

	/**
	 * 如同气泡，一步一步往后翻滚 从大到小排序
	 * 每一趟将一个数归为
	 * @param args
	 */
	public static void main(String[] args) {
		int[] mp = new int[] { 3, 9, 8, 2, 1 ,7};
		for (int i = 0; i < mp.length; i++) {
			for (int j = 0; j < mp.length-i-1; j++) {
				// 如果第一个数小于第二个数,则调换位置
				if (mp[j] < mp[j+1]) {
					int temp = mp[j];
					// 将大的数换到前面
					mp[j] = mp[j+1];
					mp[j+1] = temp;
				}
			}
		}
		for (int i = 0; i < mp.length; i++) {
			System.out.println(mp[i]);
		}
	}
}
