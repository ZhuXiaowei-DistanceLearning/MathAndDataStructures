package com.zxw.aha;

/**
 * 链表
 * 
 * @author zxw
 *
 */
public class LinkList {
	// 头结点
	private Node first;

	public LinkList() {
		first = null;
	}

	/**
	 * 插入节点，在头结点后插入
	 */
	public void insertFirst(int value) {
		Node node = new Node(value);
		// 将头结点赋值指向当前节点指针域
		node.next = first.next;
		// 将头指针移项到当前节点指针域
		first = node;
	}
	
	/**
	 * 删除节点,在头结后进行删除
	 */
	public Node deleteFirst() {
		return null;
	}
}
