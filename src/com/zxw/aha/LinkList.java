package com.zxw.aha;

/**
 * 链表,是一种存储结构
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
		// 第一次插入时，子节点为空，队尾
		node.next = first;
		// 将头指针移项到当前节点指针域
		// 保存当前节点信息，供下一个插入节点使用
		first = node;
	}

	/**
	 * 删除节点,在头结后进行删除
	 */
	public Node deleteFirst() {
		// 获取当前节点的子节点
		Node tmp = first.next;
		// 将当前节点的子节点赋值到该节点上
		first = tmp;
		return tmp;
	}

	/**
	 * 查找方法
	 */
	public Node find(int value) {
		Node current = first;
		while (current.data != value) {
			// 查找失败
			if (current.next == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}

	/**
	 * 删除
	 */
	public Node delete(int value) {
		Node current = first;
		Node previous = first;
		while (current.data != value) {
			if (current.next == null) {
				return null;
			}
			previous = current;
			current = current.next;
		}
		// 如果删除的是第一个节点
		if (current == first) {
			// 将节点的下一个值赋值给该节点
			first = first.next;
		}else{
			// 如果不是第一个节点
			// 将当前节点的下一个值，赋值给上一个节点的下一个值
			previous.next = current.next;
		}
		return current;
	}

	/**
	 * 显示方法
	 */
	public void display() {
		Node current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
	}
}
