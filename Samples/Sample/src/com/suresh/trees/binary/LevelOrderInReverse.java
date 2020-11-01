/**
 * 
 */
package com.suresh.trees.binary;

import java.util.Deque;
import java.util.LinkedList;

import com.suresh.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class LevelOrderInReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LevelOrderInReverse obj = new LevelOrderInReverse();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		BinaryTreeNode<Integer> root = ob.root;

		// Time :O(n2)
		obj.levelOrderTraversal(root);
		// Time : O(n2)
		obj.levelOrderInReverse(root);

		// Time : O(n)
		obj.levelOrderInReverseUsingStack(root);

	}

	public void levelOrderInReverse(BinaryTreeNode<Integer> root) {
		int size = new Height().height(root);
		for (int i = size; i >= 1; i--) {
			printNodesAtGivenLevel(root, i);
			System.out.print("| ");
		}
		System.out.println();
	}

	public void levelOrderTraversal(BinaryTreeNode<Integer> root) {
		int size = new Height().height(root);
		for (int i = 1; i <= size; i++) {
			printNodesAtGivenLevel(root, i);
			System.out.print("| ");
		}
		System.out.println();
	}

	public void printNodesAtGivenLevel(BinaryTreeNode<Integer> root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data + " ");
		} else if (level > 1) {
			printNodesAtGivenLevel(root.left, level - 1);
			printNodesAtGivenLevel(root.right, level - 1);
		}

	}

	public void levelOrderInReverseUsingStack(BinaryTreeNode<Integer> node) {
		if (null == node) {
			return;
		}

		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		Deque<BinaryTreeNode<Integer>> stack = new LinkedList<BinaryTreeNode<Integer>>();

		queue.addLast(node);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			stack.addFirst(cur);
			if (cur.right != null) {
				queue.addLast(cur.right);
			}
			if (cur.left != null) {
				queue.addLast(cur.left);
			}
		}
		while (!stack.isEmpty())
			System.out.print(stack.removeFirst().data + " ");
		System.out.println();
	}

}
