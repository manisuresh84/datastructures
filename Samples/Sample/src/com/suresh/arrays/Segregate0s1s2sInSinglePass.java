/**
 * 
 */
package com.suresh.arrays;

import com.suresh.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class Segregate0s1s2sInSinglePass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		;

		Segregate0s1s2sInSinglePass obj = new Segregate0s1s2sInSinglePass();
		// Of course O(n)
		obj.segregate0s1s2sInSinglePass(a, a.length);
		CommonUtil.printArray(a);
	}

	public void segregate0s1s2sInSinglePass(int[] a, int n) {
		int low = 0, mid = 0, high = n - 1;

		while (mid <= high) {
			switch (a[mid]) {
			case 0:
				CommonUtil.swap(a, low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				CommonUtil.swap(a, mid, high);
				high--;
			}
		}	
	}

}
