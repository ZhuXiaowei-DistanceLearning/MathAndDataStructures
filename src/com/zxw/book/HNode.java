package com.zxw.book;

/**
 * 构造哈夫曼树，构造具有最小带权路径长度的二叉树
 * 
 * @author zxw
 *
 */
public class HNode {
	private int weight; // 结点权值
	private int lchild; // 右孩子结点
	private int rchild; // 左孩子结点
	private int parent; // 父节点
	private String name; // 结点数据,存放字符名称
	private String code; // 存放结点的字符编码

	public HNode(String name, int w) {
		this.weight = w;
		this.lchild = -1;
		this.rchild = -1;
		this.parent = -1;
		this.name = name;
		this.code = "";
	}

	public HNode() {
		this(null, 0);
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getLchild() {
		return lchild;
	}

	public void setLchild(int lchild) {
		this.lchild = lchild;
	}

	public int getRchild() {
		return rchild;
	}

	public void setRchild(int rchild) {
		this.rchild = rchild;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
