/**
 * 
 */
package com.sb.datastructures.sorting.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankur.mahajan
 * @written 03-May-2019
 */
public class SortPrimeAndCompositeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {12, 8, 11, 3, 2, 14, 7, 4, 13, 5, 10, 6, 9};
		firstApproach(a);

	}

	private static void firstApproach(int[] a) {
		List<Integer> comp = new ArrayList<>();
		List<Integer> prim = new ArrayList<>();
		sort(a); //nlog(n)
		System.out.println(a);
		for (int i = 0; i < a.length; i++) {
			if (isPrimeByWilson(a[i])) {
				prim.add(a[i]);
			} else {
				comp.add(a[i]);
			}
		}
		System.out.println("Sorted");
	}

	private static boolean isPrimeByWilson(int n) {
		long fect = fectorial(n - 1);
		if ((fect % n) == (n - 1)) {
			return true;
		}
		return false;
	}
	
	//N
	private static long fectorial(int n) {
		if (n == 0)
			return 1;
		return n * fectorial(n - 1);
	}

	private static void sort(int[] a) {
		int length = a.length;
		if (length == 1)
			return;
		int mid = length / 2;
		int[] leftArray = createSubArray(a, 0, mid);
		int[] rightArray = createSubArray(a, mid, length);

		// sort left half
		sort(leftArray);
		// sort right half
		sort(rightArray);
		// merge above two sub arrays.
		merge(a, leftArray, rightArray);
	}

	private static void merge(int[] actual, int[] left, int[] right) {
		int leftPt = 0, rightPt = 0, actualPt = 0;
		while (left.length > leftPt && right.length > rightPt) {
			if (left[leftPt] > right[rightPt]) {
				actual[actualPt++] = right[rightPt++];
			} else {
				actual[actualPt++] = left[leftPt++];
			}
		}

		while (left.length > leftPt) {
			actual[actualPt++] = left[leftPt++];
		}

		while (right.length > rightPt) {
			actual[actualPt++] = right[rightPt++];
		}
	}

	/**
	 * @param a
	 * @param start
	 * @param end
	 * @return
	 */
	private static int[] createSubArray(int[] a, int start, int end) {
		int len = end - start;
		int[] sub = new int[len];
		for (int i = 0; i < len; i++) {
			sub[i] = a[start + i];
		}
		return sub;
	}

}
