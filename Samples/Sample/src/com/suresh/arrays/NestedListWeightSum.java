/**
 * 
 */
package com.suresh.arrays;

import java.util.ArrayList;
import java.util.List;

import com.suresh.nodes.NestedInteger;
import com.suresh.nodes.NestedIntegerImpl;

/**
 * @author Raj
 *
 *         Given a nested list of integers, return the sum of all integers in
 *         the list weighted by their depth.
 * 
 *         Each element is either an integer, or a list -- whose elements may
 *         also be integers or other lists.
 * 
 *         Example 1: Given the list [[1,1],2,[1,1]], return 10. (four 1's at
 *         depth 2, one 2 at depth 1)
 * 
 *         Example 2: Given the list [1,[4,[6]]], return 27. (one 1 at depth 1,
 *         one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 */
public class NestedListWeightSum {

	public int depthSum(List<NestedInteger> nestedList) {
		if (null == nestedList || nestedList.size() == 0)
			return 0;
		return depthSumUtil(nestedList, 1);
	}

	public int depthSumUtil(List<NestedInteger> nestedList, int level) {
		int sum = 0;
		for (NestedInteger item : nestedList) {
			if (item.isInteger()) {
				sum += (level * item.getInteger());
			} else {
				sum += depthSumUtil(item.getList(), level + 1);
			}
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NestedListWeightSum obj = new NestedListWeightSum();
		List<NestedInteger> l1 = new ArrayList<>();
		List<NestedInteger> l2 = new ArrayList<>();
		List<NestedInteger> l3 = new ArrayList<>();
		l1.add(new NestedIntegerImpl(1));
		l2.add(new NestedIntegerImpl(4));
		l3.add(new NestedIntegerImpl(6));
		NestedInteger n2 = new NestedIntegerImpl(l2);
		NestedInteger n3 = new NestedIntegerImpl(l3);
		l2.add(n3);
		l1.add(n2);

		int result = obj.depthSum(l1);
		System.out.println(result);
	}

}