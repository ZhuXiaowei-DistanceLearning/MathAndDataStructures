package com.zxw.book.stack;

import java.lang.reflect.Array;

public class SeqStack<E> implements IStack<E> {
	private int maxsize;
	private E[] data;
	private int top;

	@SuppressWarnings("unchecked")
	public SeqStack(Class<E> type, int size) {
		data = (E[]) Array.newInstance(type, size);
		maxsize = size;
		top = -1;
	}

	@Override
	public E push(E item) {
		data[++top] = item;
		return item;
	}

	@Override
	public E pop() {
		E item = null;
		item = data[top--];
		return item;
	}

	@Override
	// 获取栈顶数据元素
	public E peek() {
		E item = null;
		item = data[top];
		return item;
	}

	@Override
	// 求栈的长度
	public int size() {
		return top + 1;
	}

	@Override
	public boolean empty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

}
