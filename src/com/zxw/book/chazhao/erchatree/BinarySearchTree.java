package com.zxw.book.chazhao.erchatree;

import java.util.LinkedList;
import java.util.Queue;

import com.zxw.book.Node;

public class BinarySearchTree {
	// 树结点
	private static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;

		public TreeNode(int key, TreeNode left, TreeNode right) {
			this.key = key;
			this.left = left;
			this.right = right;
		}
	}

	private TreeNode root; // 根

	public BinarySearchTree() {
		root = null;
	}

	// 判断二叉树是否为空
	public boolean isEmpty() {
		return root == null;
	}

	// 是否包含某个元素
	public boolean search(int key) {
		return search(key, root);
	}

	public boolean search(int key, TreeNode t) {
		if (t == null) {
			return false;
		}
		if (key < t.key) {
			return search(key, t.left);
		}
		if (key > t.key) {
			return search(key, t.right);
		}
		return true;
	}

	public void insert(int key) {
		root = insert(key, root);
	}

	// 插入
	public TreeNode insert(int key, TreeNode t) {
		if (t == null) {
			return new TreeNode(key, null, null);
		}
		if (key < t.key) {
			t.left = insert(key, t.left);
		}
		if (key > t.key) {
			t.right = insert(key, t.right);
		}
		return t;
	}

	// 移除一个节点
	public void remove(int key) {
		root = delete(key, root);
	}

	public TreeNode delete(int key, TreeNode t) {
		if (t == null) {
			return null;
		}
		if (key < t.key) {
			t.left = insert(key, t.left);
		}
		if (key > t.key) {
			t.right = insert(key, t.right);
		} else if (t.left != null && t.right != null) {
			t.key = findMin(t.right).key;
			t.right = delete(t.key, t.right);
		} else {
			t = (t.left != null) ? t.left : t.right;
		}
		return t;
	}

	public int findMin() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return findMin(root).key;
	}

	private TreeNode findMin(TreeNode t) {
		if (t == null) {
			return null;
		}
		if (t.left == null) {
			return t;
		}
		return findMin(t.left);
	}

	// 输出
	public void printTree() {
		if (isEmpty()) {
			System.out.println("Empty tree");
		} else {
			printTree(root);
		}
		System.out.println();
	}

	public void printTree(TreeNode t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.key + " ");
			printTree(t.right);
		}
	}
}
