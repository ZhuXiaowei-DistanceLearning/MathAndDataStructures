package com.zxw.yuC;

public class feibo {
	public static void main(String[] args) {
		String s = "ChsiF";
		reverseString(s);
		for (int i = 1; i < 41; i++) {
			System.out.print("当前数为:" + i + ",递归数为:");
			System.out.print(feibo(i));
			System.out.println("");
		}
	}

	public static int feibo(int num) {
		if (num == 1 || num == 0) {
			return 1;
		} else {
			return feibo(num - 2) + feibo(num - 1);
		}
	}

	public static void reverseString(String str) {
		if (str.length() == 1) {
			System.out.print(str);
		} else {
			String str1 = str.substring(0, str.length() - 1);
			System.out.println(str1+"----");
			String str2 = str.substring(str.length() - 1);
			System.out.println(str2+"!!");
			reverseString(str1);
		}
	}
}
