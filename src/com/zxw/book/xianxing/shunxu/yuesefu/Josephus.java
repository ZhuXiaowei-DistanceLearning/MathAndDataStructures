package com.zxw.book.xianxing.shunxu.yuesefu;

import com.zxw.book.xianxing.shunxu.ILinarList;
import com.zxw.book.xianxing.shunxu.SeqList;

public class Josephus {
	ILinarList<JosephusNode> circle; // 约瑟夫环
	int size; // 约瑟夫环初始大小

	public Josephus(int[][] data) {
		size = data.length;
		circle = new SeqList<>(JosephusNode.class, size);
		for (int i = 0; i < size; i++) {
			circle.add(new JosephusNode(data[i][0], data[i][1]));
		}
	}

	// 初始化约瑟夫环
	public Josephus(int size) {
		circle = new SeqList<>(JosephusNode.class, size);
		this.size = size;
		int pwd;
		for (int i = 1; i <= size; i++) {
			pwd = (int) ((Math.random() * 5) + 1);
			circle.add(new JosephusNode(i, pwd));
		}
	}

	// 输出约瑟夫环
	public void printcircle() {
		for (int i = 0; i < size; i++) {
			System.out.println("(" + circle.get(i).no + "," + circle.get(i).pwd
					+ ")");
		}
	}

	// 出环游戏
	public void startgame() {
		int index = 0;
		JosephusNode node = circle.get(0);
		for (int i = 1; i <= size; i++) {
			index = (--index + node.pwd) % circle.size();
			System.out.println("index:" + index + "size:" + circle.size());
			node = circle.remove(index);
			System.out.println("(" + node.no + "," + node.pwd + ")出列");
		}
	}
}
