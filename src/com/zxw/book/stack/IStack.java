package com.zxw.book.stack;

public interface IStack<E> {
	E push(E item);

	E pop();

	E peek();

	int size();

	boolean empty();
}
