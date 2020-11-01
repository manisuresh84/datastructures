package com.suresh.ds;

import java.util.ArrayList;
import java.util.List;

import com.suresh.ds.HeapNode;

public class MinHeap<T> {
	List<HeapNode<T>> heap = new ArrayList<>();
	int heapSize;

	public void buildHeap(List<HeapNode<T>> b) {
		heap = b;
		heapSize = b.size();
		for (int i = heapSize / 2; i >= 0; i--) {
			min_heapify(i);
		}
	}

	public void min_heapify(int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int smallest = i;

		if (l < heapSize && heap.get(l).weight < heap.get(smallest).weight) {
			smallest = l;
		}

		if (r < heapSize && heap.get(r).weight < heap.get(smallest).weight) {
			smallest = r;
		}

		if (i != smallest) {
			swap(i, smallest);
			min_heapify(smallest);
		}
	}

	private void swap(int i, int j) {
		HeapNode<T> temp = heap.get(i);
		replace(i, heap.get(j));
		replace(j, temp);
	}

	public void decreaseKey(int index, int value) {
		if (heap.get(index).weight < value) {
			return;
		}

		HeapNode<T> node = heap.get(index);
		node.weight = value;
		int parent = (index - 1) / 2;
		while (parent >= 0 && heap.get(parent).weight > value) {
			replace(index, heap.get(parent));
			index = parent;
			if (0 == index) {
				break;
			}
			parent = (parent - 1) / 2;
		}
		replace(index, node);
	}

	public void increaseKey(int index, int value) {
		if (heap.get(index).weight > value)
			return;
		HeapNode<T> node = heap.get(index);
		node.weight = value;

		replace(index, node);
		min_heapify(index);
	}

	public void add(int weight, T data) {
		heap.add(new HeapNode<T>(weight, data));
		decreaseKey(heapSize++, weight);
	}

	private void replace(int index, HeapNode<T> value) {
		if (index < heap.size()) {
			heap.remove(index);
			heap.add(index, value);
		}
	}

	public boolean remove(int index) {
		if (index >= heapSize)
			return false;
		heapSize--;
		swap(index, heapSize);
		increaseKey(index, heap.get(index).weight);
		return true;
	}

	public void sort() {
		int temp = heapSize;
		for (int i = heapSize - 1; i > 0; i--) {
			swap(heapSize - 1, 0);
			heapSize--;
			min_heapify(0);
		}
		heapSize = temp;
	}

	public void print() {
		for (int i = 0; i < heapSize; i++) {
			System.out.print(heap.get(i).data + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		MinHeap<Integer> heap = new MinHeap<>();
		heap.add(3, 3);
		heap.add(2, 2);
		heap.add(1, 1);
		heap.add(7, 7);
		heap.add(8, 8);
		heap.add(4, 4);
		heap.add(10, 10);
		heap.add(16, 16);
		heap.add(12, 12);
		heap.print();

	}
}
