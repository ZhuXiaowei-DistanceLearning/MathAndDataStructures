package com.zxw.book;

/**
 * 二叉链表存储结构
 * 
 * @author zxw
 *
 */
public class Node<E> {
	private E data; // 数据域
	private Node<E> lchild; // 左孩子
	private Node<E> rchild; // 右孩子

	public Node(E data, Node<E> lchild, Node<E> rchild) {
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}

	public Node(Node<E> lchild, Node<E> rchild) {
		this.lchild = lchild;
		this.rchild = rchild;
	}

	public Node(E data) {
		this.data = data;
	}

	public Node() {
		this(null);
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getLchild() {
		return lchild;
	}

	public void setLchild(Node<E> lchild) {
		this.lchild = lchild;
	}

	public Node<E> getRchild() {
		return rchild;
	}

	public void setRchild(Node<E> rchild) {
		this.rchild = rchild;
	}

}
