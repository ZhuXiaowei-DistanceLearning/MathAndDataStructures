package com.zxw.book;

import java.util.Scanner;

public class TestTree {
	public static void main(String[] args) {
		// bTree();
		HuffmanTree ht = new HuffmanTree();
		ht.create();
		ht.print();
		ht.traverse();
		String op = "";
		do {
			System.out.println("请输入一个报文编码进行编码：");
			Scanner sc = new Scanner(System.in);
			String codes = sc.nextLine();
			String decodes = ht.decodes(codes); // 报文解码
			if (decodes.length() == 0) {
				System.out.println("解码出错!");
			} else {
				System.out.println("对应的报文为：" + decodes);
			}
			System.out.println("按X键退出，其他键继续");
			op = sc.nextLine();
		} while (!op.toLowerCase().equals("x"));
		System.out.println("程序退出");
	}

	private static void bTree() {
		LinkBiTree<Character> bt = new LinkBiTree<Character>('A');
		// 获取头指针结点，即A
		Node<Character> root = bt.getHead();
		// 插入A的左结点B
		bt.insertL('B', root);
		Node<Character> b = root.getLchild();
		// 插入B的左结点D
		bt.insertL('D', b);
		Node<Character> d = b.getLchild();
		// 插入B的右结点D
		bt.insertR('G', d);
		// 构造A的右子树
		bt.insertR('C', root);
		Node<Character> c = root.getRchild();
		bt.insertL('E', c);
		bt.insertR('F', c);
		System.out.println("\n先序遍历:");
		bt.preorder(root);
		System.out.println("\n中序遍历:");
		bt.inorder(root);
		System.out.println("\n后序遍历:");
		bt.postorder(root);
		System.out.println("\n层序遍历:");
		bt.levelOrder(root);
	}
}
