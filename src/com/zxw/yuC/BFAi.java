package com.zxw.yuC;

public class BFAi {
	public static void main(String[] args) {
		String a="abcadaaavbcdd";
		String b = "dd";
		System.out.println(BfFind(a, b, 3));
	}

	/**
	 * 字符串匹配，寻找t是否在s中出现
	 * 当有一个不匹配的时候，回溯到目标串的下个字符
	 * @param S
	 * @param T
	 * @param pos
	 * @return
	 */
	public static int BfFind(String S, String T, int pos) {
		char[] arr1 = S.toCharArray();
		char[] arr2 = T.toCharArray();
		int i = pos;
		int j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2[j]) {
				i++;
				j++;
			} else {
				// 当匹配中断时,从中断的当前位置重新开始匹配
				i = i - j + 1;
				j = 0;
			}
		}
		// 返回模式串在目标串中出现的位置,第一个字符的位置
		return j == arr2.length ? i-j:-1;
	}
}
