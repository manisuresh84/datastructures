package com.suresh.lrucache;

import java.util.HashMap;

class Node {
	int key;
	int value;
	Node pre;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

class LRUCache {
	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}

	public void remove(Node n) {
		if (n.pre != null) {
			n.pre.next = n.next;
		} else {
			head = n.next;
		}
		if (n.next != null) {
			n.next.pre = n.pre;
		} else {
			end = n.pre;
		}
	}

	public void setHead(Node n) {
		n.next = head;
		n.pre = null;
		if (head != null)
			head.pre = n;
		head = n;
		if (end == null)
			end = head;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(created);
			} else {
				setHead(created);
			}
			map.put(key, created);
		}
	}
}

public class LRUCacheDemo {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.set(4, 4);
		cache.set(5, 1);
		cache.set(6, 2);
		cache.set(7, 5);
		cache.set(8, 1);
		cache.set(9, 2);
		cache.set(10, 3);
		cache.set(11, 4);
		cache.set(12, 5);
		
		System.out.println(cache.get(9));
		System.out.println(cache.get(10));
		System.out.println(cache.get(11));
		System.out.println(cache.get(12));
	}

}
