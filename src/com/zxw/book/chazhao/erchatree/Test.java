package com.zxw.book.chazhao.erchatree;

public class Test {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(70);
		bst.insert(30);
		bst.insert(40);
		bst.insert(10);
		bst.insert(80);
		bst.insert(20);
		bst.insert(90);
		bst.insert(100);
		bst.insert(75);
		bst.insert(60);
		bst.insert(45);
		System.out.println("遍历二叉排序树：");
		bst.printTree();
		System.out.println("have80 -->" + bst.search(80));
		System.out.println("have65 -->" + bst.search(65));
	}
}
