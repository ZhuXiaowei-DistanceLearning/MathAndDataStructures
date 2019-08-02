package com.zxw.aha;

public class MyStack {

	public static void main(String[] args) {
		MyStack ms = new MyStack(4);
		ms.push(2);
		ms.push(4);
		ms.push(1);
		ms.push(3);
		System.out.println(ms.isEmpty());
		System.out.println(ms.isFull());
		int[] arr2 = ms.getArr();
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
	}

	int[] arr;
	int top;

	public MyStack() {
		arr = new int[10];
		top = -1;
	}

	public MyStack(int maxsize) {
		arr = new int[maxsize];
		top = -1;
	}

	/**
	 * 入栈
	 * 
	 * @param value
	 */
	public void push(int value) {
		arr[++top] = value;
	}

	/**
	 * 出栈
	 * 
	 * @return
	 */
	public int pop() {
		return arr[top--];
	}

	/**
	 * 查找数据
	 * 
	 * @return
	 */
	public int peek() {
		return arr[top];
	}

	/**
	 * 判断是否为空
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == arr.length - 1;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

}
