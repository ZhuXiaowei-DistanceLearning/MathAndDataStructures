package com.zxw.book.stack;

public class StackNode<E> {
	private E data; // 数据域
	private StackNode<E> next; // 引用域

	public StackNode() {
	}

	public StackNode(E data, StackNode<E> next) {
		super();
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public StackNode<E> getNext() {
		return next;
	}

	public void setNext(StackNode<E> next) {
		this.next = next;
	}

}
