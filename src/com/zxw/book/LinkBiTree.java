package com.zxw.book;

/**
 * 不带头结点二叉树
 * 
 * @author zxw
 *
 */
public class LinkBiTree<E> {
	private Node<E> head; // 链表头引用指针

	public Node<E> getHead() {
		return head;
	}

	// 以val为根结点数据域信息，以二叉树lp和rp为左子树和右子树的二叉树
	public LinkBiTree(E val, Node<E> lp, Node<E> rp) {
		Node<E> p = new Node<>(val, lp, rp);
		head = p;
	}

	// 生成一颗以val为根结点数据域信息的二叉树
	public LinkBiTree(E val) {
		this(val, null, null);
	}

	// 生成一颗空二叉树
	public LinkBiTree() {
		head = null;
	}

	// 判断二叉树是否为空
	public boolean isEmpty() {
		return head == null;
	}

	// 获取根结点
	public Node<E> Root() {
		return head;
	}

	// 获取结点的左孩子结点
	public Node<E> getLChild(Node<E> node) {
		return node.getLchild();
	}

	// 获取结点的右孩子结点
	public Node<E> getRChild(Node<E> node) {
		return node.getRchild();
	}

	// 将结点p的左子树插入值为val的新节点，原来的左子树成为新结点的左子树
	public void insertL(E val, Node<E> node) {
		// 生成一个只有数据的结点
		Node<E> tmp = new Node<E>(val);
		// 将当前节点的左结点设置为新节点的左子树
		tmp.setLchild(node.getLchild());
		// 将新结点设置为当前结点的左子树
		node.setLchild(tmp);
	}

	// 将结点p的右子树插入值为val的新节点，原来的右子树成为新结点的左子树
	public void insertR(E val, Node<E> node) {
		// 生成一个只有数据的结点
		Node<E> tmp = new Node<E>(val);
		// 将当前节点的左结点设置为新节点的右子树
		tmp.setRchild(node.getRchild());
		// 将新结点设置为当前结点的右子树
		node.setRchild(tmp);
	}

	// 若p非空，删除p的左子树,并返回左子树
	public Node<E> deleteL(Node<E> p) {
		if (p == null || p.getLchild() == null) {
			return null;
		}
		Node<E> tmp = p.getLchild();
		p.setLchild(null);
		return tmp;
	}

	// 若p非空，删除p的右子树,并返回右子树
	public Node<E> deleteR(Node<E> p) {
		if (p == null || p.getRchild() == null) {
			return null;
		}
		Node<E> tmp = p.getRchild();
		p.setRchild(null);
		return tmp;
	}

	// 编写算法，在二叉树中查找值为value的结点
	public Node<E> search(E val, Node<E> root) {
		Node<E> p = root;
		if (p == null) {
			return null;
		}
		// 如果不相等，则返回
		if (!p.getData().equals(val)) {
			return p;
		}
		if (p.getLchild() != null) {
			return search(val, p.getLchild());
		}
		if (p.getRchild() != null) {
			return search(val, p.getRchild());
		}
		return null;
	}

	// 判断是否为是叶子结点
	public boolean isLeaf(Node<E> node) {
		return ((node != null) && (node.getLchild() == null) && (node
				.getRchild() == null));
	}
}
