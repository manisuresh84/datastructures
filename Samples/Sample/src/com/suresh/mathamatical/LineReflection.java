/**
 * 
 */
package com.suresh.mathamatical;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.suresh.nodes.Point;

/**
 * @author Raj
 *
 *         Given n points on a 2D plane, find if there is such a line parallel
 *         to y-axis that reflects the given points.
 * 
 *         Example 1: Given points = [[1,1],[-1,1]], return true.
 * 
 *         Example 2: Given points = [[1,1],[-1,-1]], return false.
 * 
 *         Example 3: [(-4,1), (-2, 6), (4, 1), (2, 6)], returns true ( x=0,
 *         line);
 * 
 *         Example 4 : [[-5,1], [-3, 6], [3, 1], [1, 6]], returns true (x = -1
 *         line, all the points form example 3 are left shifted by 1)
 * 
 * 
 *         Look at this article to understand problem definition
 *         https://discuss.leetcode.com/topic/53929/what-is-exactly-problem/2
 */
public class LineReflection {

	// Time : O(n), Space : O(n)
	public static boolean isReflected(Point[] points) {
		if (points == null || points.length < 2)
			return true;

		Map<Integer, Set<Integer>> map = new HashMap<>();
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (Point p : points) {
			min = Math.min(min, p.x);
			max = Math.max(max, p.x);

			map.compute(p.x, (key, value) -> {
				if (null == value) {
					Set<Integer> set = new HashSet<>();
					set.add(p.y);
					return set;
				}
				value.add(p.y);
				return value;
			});

		}
		int y = min + max;
		for (Point p : points) {
			int left = p.x;
			int right = y - left;
			if (map.get(right) == null || !map.get(right).contains(p.y))
				return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Point a[] = { new Point(1, 1), new Point(-1, 1) };

		boolean res = false;
		res = isReflected(a);
		System.out.println(res);

		Point b[] = { new Point(1, 1), new Point(-1, -1) };
		res = isReflected(b);
		System.out.println(res);

		Point c[] = { new Point(-5, 1), new Point(-3, 6), new Point(3, 1), new Point(1, 6) };
		res = isReflected(c);
		System.out.println(res);

	}

}
