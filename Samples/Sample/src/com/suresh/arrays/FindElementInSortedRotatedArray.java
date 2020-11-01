package com.suresh.arrays;

public class FindElementInSortedRotatedArray {

	public static void main(String[] args) {
		// int a[] = { 2, 3, 4, 5, 1 };
		// int a[] = { 5, 1, 2, 3, 4 };
		int a[] = { 73, 85, 94, 21, 27, 34, 47, 54, 66 };
		// int a[] = { 156, 235, 457, 21, 32, 43, 74, 75, 86, 97, 108, 149 };
		int result = -1, n = a.length, k = 3;
		FindElementInSortedRotatedArray obj = new FindElementInSortedRotatedArray();
		result = obj.findPivot(a, 0, n - 1);
		System.out.println(result);

		result = obj.findElementInSortedRotatedArray(a, n, k);
		System.out.println(result);

	}

	public int binarySearch(int a[], int l, int r, int key) {
		int mid;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] > key) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public int findElementInSortedRotatedArray(int[] a, int n, int k) {
		int pivot = findPivot(a, 0, n - 1);
		if (pivot != -1) {
			if (k >= a[0] && k <= a[pivot - 1]) {
				return binarySearch(a, 0, pivot - 1, k);
			} else {
				return binarySearch(a, pivot, n - 1, k);
			}

		}
		return -1;
	}

	int findPivot(int a[], int l, int r) {
		if (l > r)
			return -1;
		if (l == r) {
			return l;
		}
		if (a[l] <= a[r])
			return 0;

		int mid;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (a[mid] > a[mid + 1])
				return mid + 1;

			if (a[mid] > a[l]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}
}
