package com.zxw.aha;

public class TextLinkList {
	public static void main(String[] args) {
		LinkList  ll = new LinkList();
		// 先进后出
		ll.insertFirst(34);
		ll.insertFirst(23);
		ll.insertFirst(12);
		ll.insertFirst(5);
		ll.insertFirst(3);
		ll.display();
		System.out.println("");
		ll.deleteFirst();
		ll.display();
		Node find = ll.find(23);
		System.out.println("");
		ll.delete(12);
		ll.display();
	}
}
