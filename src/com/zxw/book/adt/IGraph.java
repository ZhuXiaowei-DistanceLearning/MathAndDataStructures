package com.zxw.book.adt;

public interface IGraph<E> {
	// 获取顶点个数
	public int getNumOfVertex();

	// 插入顶点
	boolean insertVex(E v);

	// 删除顶点
	boolean deleteVex(E v);

	// 定位顶点的位置
	int indexOfVex(E v);

	// 定位指定位置的顶点
	E valueOfVex(int v);

	// 插入边
	boolean insertEdge(int v1, int v2, int weight);

	// 删除边
	boolean deteleEdge(int v1, int v2);

	// 查找变
	public int getEdge(int v1, int v2);

	// 深度优先搜索遍历
	String depthFirstSearch(int v);

	// 广度优先搜索遍历
	String breadFirstSearch(int v);

	// 查找源点到其他顶点的路径
	public int[] dijkstra(int v);
}
