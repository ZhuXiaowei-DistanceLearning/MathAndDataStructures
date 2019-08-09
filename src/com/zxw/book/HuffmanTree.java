package com.zxw.book;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 哈弗曼树
 * 
 * @author zxw
 *
 */
public class HuffmanTree {
	// 结点数组，存放结点集合
	// 用一个数组存放原来的n个叶子结点和构造过程中临时生成的结点,数组大小为2n-1
	private HNode[] data;
	// 叶子结点数目
	private int leafNum;

	/**
	 * 判断是否是叶子结点
	 * 
	 * @param p
	 * @return
	 */
	public boolean isLeaf(HNode p) {
		return ((p != null) && (p.getLchild() == -1) && (p.getRchild() == -1));
	}

	/**
	 * 构造哈夫曼树
	 */
	public void create() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要传输的报文");
		String str = sc.nextLine().toLowerCase();
		str = str.replace(" ", "");
		int[] c = new int[26]; // 统计出26个小写字符
		// 统计出各字符出现的频率
		for (int i = 0; i < str.length(); i++) {
			// 返回 char指定索引处的值。 
			char d = str.charAt(i);
			// 得到字符所在的位置索引，例c[25]==z
			int j = c[str.charAt(i) - 'a'];
			// ascil码值相减在26范围内
			c[str.charAt(i) - 'a']++;
		}
		int cnt = 0;
		// 统计报文中字符数量
		for (int i = 0; i < c.length; i++) {
			if (c[i] > 0) {
				cnt++;
			}
		}
		// 叶子结点数目
		this.leafNum = cnt;
		// 数组大小为2n-1
		data = new HNode[this.leafNum * 2 - 1];
		for (int i = 0; i < 2 * leafNum - 1; i++) {
			data[i] = new HNode();
		}
		cnt = 0;
		// 用字符创建叶子结点
		for (int i = 0; i < c.length; i++) {
			if (c[i] > 0) {
				data[cnt].setName((char) (i + 'a') + "");
				data[cnt++].setWeight(c[i]);
			}
		}

		int m1, m2, x1, x2;
		// 处理n个叶子结点，建立哈弗曼树
		for (int i = 0; i < this.leafNum - 1; ++i) {
			m1 = m2 = Integer.MAX_VALUE; // m1为最小权值,m2为次小权值
			x1 = x2 = 0; // x1为权值最小位置,x2为权值次小位置
			// 在全部结点中找权值最小的两个结点
			for (int j = 0; j < this.leafNum + i; j++) {
				if ((data[j].getWeight() < m1) && (data[j].getParent() == -1)) {
					m2 = m1;
					x2 = x1;
					m1 = data[j].getWeight();
					x1 = j;
				} else if ((data[j].getWeight() < m2)
						&& (data[j].getParent() == -1)) {
					m2 = data[j].getWeight();
					x2 = j;
				}
			}
			// 用两个权值最小点构造一个新的中间结点
			data[this.leafNum + i].setWeight(data[x1].getWeight()
					+ data[x2].getWeight());
			data[this.leafNum + i].setLchild(x1);
			data[this.leafNum + i].setRchild(x2);
			// 修改权值最小的两个结点的父结点指向
			data[x1].setParent(this.leafNum + i);
			data[x2].setParent(this.leafNum + i);
		}
	}

	// 输出哈夫曼树的存储结构
	public void print() {
		System.out.println("位置\t字符\t权值\t父结点\t左孩子结点\t右孩子结点");
		for (int i = 0; i < 2 * leafNum - 1; i++) {
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t\r\n", i, data[i].getName(),
					data[i].getWeight(), data[i].getParent(),
					data[i].getLchild(), data[i].getRchild());
		}
	}

	// 前序遍历
	private int preorder(HNode root, String code) {
		int sum = 0;
		if (root != null) {
			root.setCode(code);
			if (isLeaf(root)) {
				System.out.println(root.getName() + ":" + root.getCode());
				return root.getWeight() * root.getCode().length();
			}
			if (root.getLchild() != -1) {
				// 左子树,编码为0,统计左子树叶子结点的编码长度
				sum += preorder(data[root.getLchild()], code + "0");
			}
			if (root.getRchild() != -1) {
				sum += preorder(data[root.getRchild()], code + "1");
			}
		}
		return sum;
	}

	// 层次遍历，求所有报文字符编码，计算报文传输总长度
	public void traverse() {
		// 根结点的位置
		int root = 2 * leafNum - 2;
		// 根结点为空
		if (root == -1) {
			return;
		}
		int sum = preorder(data[root], "");
		System.out.println("所有报文长度为(位):" + sum);
	}

	// 采用层序遍历，进行报文解码
	public String decodes(String codes) {
		// 根结点位置
		int root = 2 * leafNum - 2;
		// 根结点为空
		if (root == -1) {
			return "";
		}
		// 设置一个队列保存层序遍历的结点
		Queue<HNode> q = new LinkedList<HNode>();
		// 根结点入队
		q.add(data[root]);
		int i = 0;
		String str = "";
		// 队列非空，结点没有处理完
		while (!q.isEmpty()) {
			// 结点出队
			HNode tmp = q.poll();
			if (!codes.startsWith(tmp.getCode()))
				continue;
			// 如果是叶子结点，则计算编码长度
			if (isLeaf(tmp)) {
				str = str + tmp.getName();
				codes = codes.substring(tmp.getCode().length());
				// 如果存在多个报文字符，则继续重新解码
				if (codes.length() > 0) {
					while (!q.isEmpty()) {
						q.poll();
					}
					q.add(data[root]);
					continue;
				}
			}
			// 将当前节点的左孩子结点入队
			if (tmp.getLchild() != -1) {
				q.add(data[tmp.getLchild()]);
			}
			if (tmp.getRchild() != -1) {
				// 将当前结点的右孩子结点入队
				q.add(data[tmp.getRchild()]);
			}
		}
		return str;
	}
}
