package com.zxw.book.xianxing.shunxu.yuesefu;

public class Test {
	public static void main(String[] args) {
		Josephus jsf;
		System.out.println("--给定初始密码的约瑟夫环--");
		int[][] data = { { 1, 1 }, { 2, 4 }, { 3, 4 }, { 4, 3 }, { 5, 1 },
				{ 6, 1 }, { 7, 5 }, { 8, 5 }, { 9, 1 }, { 10, 5 }, { 11, 1 },
				{ 12, 3 } };
		jsf = new Josephus(data);
		System.out.println("显示约瑟夫环");
		jsf.printcircle();
		System.out.println("\n");
		System.out.println("显示出列顺序");
		jsf.startgame();
		System.out.println("--随机生成密码的约瑟夫环--");
		jsf = new Josephus(12);
		System.out.println("显示约瑟夫环：");
		jsf.printcircle();
		System.out.println("\n");
		System.out.println("显示出列顺序");
		jsf.startgame();
	}
}
