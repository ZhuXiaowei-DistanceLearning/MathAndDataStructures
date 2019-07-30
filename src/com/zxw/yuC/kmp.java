package com.zxw.yuC;

public class kmp {
	public static void main(String[] args) {
		System.out.println(kmpMatch("abcabaabaabcacb", "cb"));
	}

	// 求出next数组
	/**
	 * 求解next[j]是关键 令k=next[j-1]
	 * 
	 * @param t
	 * @return
	 * @next[j] : 当前字符之前的字符串中，有多大长度的相同前缀后缀。例如如果next [j] = k，代表j 之前的字符串中有最大长度为k 的相同前缀后缀。
	 */
	public static int[] getNextArray(char[] tmp) {
		int[] next = new int[tmp.length];
		next[0] = -1;
		next[1] = 0;
		int k;
		// j:模板字符串的索引
		// 否则跳至3。
		for (int j = 2; j < tmp.length; j++) {
			// k的值为前一个数的next值
			k = next[j - 1];
			while (k != -1) {
				// 比较T[j-1]与T[K]的值
				if (tmp[j - 1] == tmp[k]) {
					// 若T[j-1]等于T[k]，则next[j]=k+1。
					next[j] = k + 1;
					break;
				} else {
					// 若T[j-1]不等于T[k]，令k=next[k]
					k = next[k];
				}
				// 若k等于-1，则next[j]=0
				next[j] = 0;
			}
		}
		return next;
	}

	// KMP匹配过程
	/**
	 * 对主串s和模板串t进行KMP模式匹配
	 * 
	 * @param s
	 * @param t
	 * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
	 */
	public static int kmpMatch(String s, String t) {
		char[] s_arr = s.toCharArray();
		char[] t_arr = t.toCharArray();
		int i = 0, j = 0;
		int[] next = getNextArray(t_arr);
		while (i < s_arr.length && j < t_arr.length) {
			// 当模式串T匹配至第j个字符时匹配失败，i指针不变，将j指针置为next[j]的值，若j的值为-1，则将i和j同时加1。随后继续进行逐个的比较。
			// 如果j=-1，表示当前字符匹配成功
			if (j == -1 || s_arr[i] == t_arr[j]) {
				i++;
				j++;
			} else {
				// 字符匹配失败，模式串T相对于文本串S向右移动了j-next[j]位
				// 模式串向右移动的位数为：失配字符所在位置（j） - 失配字符对应的next值，即移动的实际位数为：j - next[j]（表示当前指针的位置向右移动的位数，例如当前指针在a[6]位置上，向右移动4位，则到达a[2]上），且此值大于等于1。
				j = next[j];
			}
		}
		if (j == t_arr.length) {
			return i - j;
		} else {
			return -1;
		}
	}
}
