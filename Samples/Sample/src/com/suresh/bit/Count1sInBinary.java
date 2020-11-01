/**
 * 
 */
package com.suresh.bit;

/**
 * @author Raj
 *
 */
public class Count1sInBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Count1sInBinary obj = new Count1sInBinary();
		int result = -1, n = 30;
		result = obj.count1sInBinary(n);
		System.out.println(result);
		
		System.out.println(Integer.toBinaryString(-2));
	}

	public int count1sInBinary(int n) {
		System.out.println(Integer.toBinaryString(n));
		int count = 0;
		while (n > 0) {
			count += (n & 1);
			n = n >> 1;
		}
		return count;
	}

}
