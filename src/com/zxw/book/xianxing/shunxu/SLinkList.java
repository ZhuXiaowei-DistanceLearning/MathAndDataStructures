package com.zxw.book.xianxing.shunxu;

public class SLinkList<E> implements ILinarList<E> {
	private Node<E> start;
	int size;

	public SLinkList() {
		start = null;
	}

	@Override
	public boolean add(E item) {
		if (start == null) {
			start = new Node<E>(item, null);
		} else {
			Node<E> current = start;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node<E>(item, null);
			size++;
		}
		return false;
	}

	@Override
	public boolean add(int index, E item) {
		Node<E> current; // 当前结点
		Node<E> previous; // 前一个结点
		Node<E> newnode = new Node<E>(item, null); // 待插入的结点
		// 在空链表或第一个元素前插入第一个元素
		if (index == 0) {
			newnode.next = start;
			start = newnode;
			size++;
		} else {
			current = start;
			previous = null;
			int j = 0;
			while (current != null && j < index) {
				previous = current;
				current = current.next;
				j++;
			}
			if (j == index) {
				previous.next = newnode;
				newnode.next = current;
				size++;
			}
		}
		return true;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	private static class Node<E> {
		E item;
		Node<E> next;

		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
	}

}
