package com.zxw.book.xianxing.shunxu;

import java.lang.reflect.Array;

import com.zxw.book.xianxing.shunxu.yuesefu.JosephusNode;

public class SeqList<E> implements ILinarList<E> {
	private int maxsize; // 最大容量
	private E[] data; // 数组，用于存储顺序表中的数据元素
	private int size; // 顺序表的实际长度

	@SuppressWarnings("unchecked")
	public SeqList(Class<E> type, int maxsize) {
		this.maxsize = maxsize;
		data = (E[]) Array.newInstance(type, maxsize);
		size = 0;
	}

	@Override
	// 添加元素，将元素添加在顺序表的末尾
	public boolean add(E item) {
		if (!isFull()) {
			data[size++] = item;
			return true;
		}
		return false;
	}

	@Override
	// 在指定位置插入元素,插入排序思想
	public boolean add(int index, E item) {
		if (index < 0 || index > size) {
			System.out.println("长度超过范围");
			return false;
		}
		if (!isFull()) {
			for (int i = size - 1; i >= size; i--) {
				data[i + 1] = data[i];
			}
			data[index] = item;
			size++;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public E remove(int index) {
		if (!isEmpty()) {
			E oldValue = data[index];
			for (int i = index; i < size - 1; i++) {
				data[i] = data[i + 1];
			}
			// 清除最后一个元素
			data[--size] = null;
			return oldValue;
		}
		return null;
	}

	@Override
	public int indexOf(E item) {
		if (item == null) {
			for (int i = 0; i < size; i++) {
				if (data[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (item.equals(data[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public E get(int index) {
		rangeCheck(index);
		return data[index];
	}

	private void rangeCheck(int index) {
		if(index<0||index>=size){
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public E set(int index, E item) {
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == maxsize;
	}

}
