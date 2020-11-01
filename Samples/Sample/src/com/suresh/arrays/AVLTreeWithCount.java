/**
 * 
 */
package com.suresh.arrays;

import java.util.Deque;
import java.util.LinkedList;

import com.suresh.nodes.AVLTreeNodeWithCount;

/**
 * @author Raj
 *
 */

/*
 * Write a function to count number of smaller elements on right of each element
 * in an array. Given an unsorted array arr[] of distinct integers, construct
 * another array countSmaller[] such that countSmaller[i] contains count of
 * smaller elements on right side of each element arr[i] in array.
 */

public class AVLTreeWithCount<T> {
	public AVLTreeNodeWithCount<Integer> root;

	public void inOrder(AVLTreeNodeWithCount<Integer> node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}

	public void preOrder(AVLTreeNodeWithCount<Integer> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void levelOrderTraversal(AVLTreeNodeWithCount<Integer> root) {
		int size = root.height;
		for (int i = 1; i <= size; i++) {
			printNodesAtGivenLevel(root, i);
			System.out.print("| ");
		}
		System.out.println();
	}

	public void printNodesAtGivenLevel(AVLTreeNodeWithCount<Integer> root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data + "(" + root.count + ")");
		} else if (level > 1) {
			printNodesAtGivenLevel(root.left, level - 1);
			printNodesAtGivenLevel(root.right, level - 1);
		}

	}

	public void levelOrder(AVLTreeNodeWithCount<Integer> node) {
		if (null == node) {
			System.out.println("Empty");
			return;
		}

		Deque<AVLTreeNodeWithCount<Integer>> queue = new LinkedList<AVLTreeNodeWithCount<Integer>>();
		queue.addLast(node);

		while (!queue.isEmpty()) {
			AVLTreeNodeWithCount<Integer> cur = queue.removeFirst();
			System.out.print(cur.data + " ");

			if (cur.left != null) {
				queue.addLast(cur.left);
			}
			if (cur.right != null) {
				queue.addLast(cur.right);
			}
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AVLTreeWithCount<Integer> tree = new AVLTreeWithCount<Integer>();
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 35);
		tree.root = tree.insert(tree.root, 9);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 5);
		tree.root = tree.insert(tree.root, 6);
		tree.root = tree.insert(tree.root, 10);

		tree.inOrder(tree.root);
		System.out.println();
		tree.preOrder(tree.root);
		System.out.println();
		tree.levelOrderTraversal(tree.root);
		// tree.delete(tree.root, 10);
		// tree.levelOrderTraversal(tree.root);
	}

	public int count;

	public AVLTreeNodeWithCount<Integer> insert(AVLTreeNodeWithCount<Integer> root, int data) {
		if (root == null) {
			root = new AVLTreeNodeWithCount<Integer>(data, 1, 1);
			return root;
		}
		if (root.data > data) {
			root.left = insert(root.left, data);
			if (heightDiff(root.left, root.right) == 2) {
				// LL imbalance
				if (root.left.data > data) {
					root = rotateRight(root);
				}
				// LR imbalance
				else {
					root.left = rotateLeft(root.left);
					root = rotateRight(root);
				}
			}

		} else if (root.data < data) {
			root.right = insert(root.right, data);

			if (heightDiff(root.left, root.right) == 2) {
				// RL imbalance
				if (root.right.data > data) {
					root.right = rotateRight(root.right);
					root = rotateLeft(root);
				}
				// RR imbalance
				else {

					root = rotateLeft(root);
				}
			}
		} else {
			root.count++;
		}
		root.height = 1 + Math.max(height(root.left), height(root.right));
		return root;
	}

	public AVLTreeNodeWithCount<Integer> search(AVLTreeNodeWithCount<Integer> root, int data) {
		if (root == null) {
			return root;
		}
		if (root.data > data) {
			return search(root.left, data);
		} else if (root.data < data) {
			return search(root.right, data);
		} else {
			return root;
		}
	}

	public int heightDiff(AVLTreeNodeWithCount<Integer> left, AVLTreeNodeWithCount<Integer> right) {
		return Math.abs(height(left) - height(right));
	}

	public AVLTreeNodeWithCount<Integer> delete(AVLTreeNodeWithCount<Integer> root, int data) {
		if (root == null) {
			return root;
		}
		if (root.data > data) {
			root.left = delete(root.left, data);
			if (heightDiff(root.left, root.right) == 2) {
				// LL imbalance
				if (root.left.data > data) {
					root = rotateRight(root);
				}
				// LR imbalance
				else {
					root.left = rotateLeft(root.left);
					root = rotateRight(root);
				}
			}
		} else if (root.data < data) {
			root.right = delete(root.right, data);
			if (heightDiff(root.left, root.right) == 2) {
				// RL imbalance
				if (root.right.data > data) {
					root.right = rotateRight(root.right);
					root = rotateLeft(root);
				}
				// RR imbalance
				else {
					root = rotateLeft(root);
				}
			}

		} else {
			if (isFullNode(root)) {
				AVLTreeNodeWithCount<Integer> inOrderPred = findMax(root.left);
				root.data = inOrderPred.data;
				root.left = delete(root.left, inOrderPred.data);
			} else {
				root = (root.left != null) ? root.left : root.right;
			}
		}
		if (root != null)
			root.height = 1 + Math.max(height(root.left), height(root.right));
		return root;
	}

	public AVLTreeNodeWithCount<Integer> findMax(AVLTreeNodeWithCount<Integer> root) {
		if (null == root)
			return root;
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	public AVLTreeNodeWithCount<Integer> findMin(AVLTreeNodeWithCount<Integer> root) {
		if (null == root)
			return root;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public AVLTreeNodeWithCount<Integer> rotateRight(AVLTreeNodeWithCount<Integer> node) {
		AVLTreeNodeWithCount<Integer> temp = node.left;
		node.left = temp.right;
		temp.right = node;

		node.height = 1 + Math.max(height(node.left), height(node.right));
		temp.height = 1 + Math.max(height(temp.left), height(temp.right));

		return temp;
	}

	public AVLTreeNodeWithCount<Integer> rotateLeft(AVLTreeNodeWithCount<Integer> node) {
		AVLTreeNodeWithCount<Integer> temp = node.right;
		node.right = temp.left;
		temp.left = node;

		node.height = 1 + Math.max(height(node.left), height(node.right));
		temp.height = 1 + Math.max(height(temp.left), height(temp.right));

		return temp;
	}

	public int height(AVLTreeNodeWithCount<Integer> root) {
		if (null == root)
			return 0;
		return root.height;
	}

	public int count(AVLTreeNodeWithCount<Integer> root) {
		if (null == root)
			return 0;
		return root.count;
	}

	public boolean isFullNode(AVLTreeNodeWithCount<Integer> root) {
		return root.left != null && root.right != null;
	}

}
