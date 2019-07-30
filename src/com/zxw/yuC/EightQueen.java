package com.zxw.yuC;

public class EightQueen {
	public static void main(String[] args) {
		int[][] chess = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				chess[i][j] = 0;
			}
		}
	}

	public static void eight(int row, int n, int[][] chess) {
		// 临时棋盘
		int[][] chess2 = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				chess2[i][j] = chess[i][j];
			}
		}
	}
}
