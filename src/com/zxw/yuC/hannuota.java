package com.zxw.yuC;

public class hannuota {
	public static void main(String[] args) {
		System.out.println("汉诺塔开始运行");
		move(5, 'x', 'y', 'z');
	}

	/**
	 * 要将最大的圆盘移动到柱子3上
	 * 柱子1只剩最大的圆盘
	 * 柱子3为空
	 * 
	 * @param n      圆盘个数
	 * @param start  柱子1
	 * @param temp   柱子2
	 * @param target 柱子3
	 */
	public static void move(int n, char start, char temp, char target) {
		if (n == 0) {
			return;
		}
		if (n == 1) {
			System.out.println(start + "------->" + target);
		} else {
			move(n - 1, start, target, temp);
			System.out.println(start + "------->" + target);
			move(n - 1, temp, start, target);
		}
	}
}
