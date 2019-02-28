/**
 * 
 */
package com.sb.datastructures.sorting;

import java.util.Arrays;

/**
 * @author ankur.mahajan
 * @written 19-Feb-2019
 */
public class MergeTwoSortedArrayInSortedOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 7, 19, 43, 56, 118, 987, 1000 };
		int[] b = { 17, 19, 143, 516, 1118, 1987, 2000, 2222, 3333, 3334, 3335 };
		int[] c = new int[a.length + b.length];
		int[] result = firstApproach(a, b, c);
		Arrays.stream(result).forEach(System.out::println);

	}

	private static int[] firstApproach(int[] a, int[] b, int[] c) {
		int aInd = 0, bInd = 0, cInd = 0;
		int aLength = a.length;
		int bLength = b.length;

		// Compare all elements of two arrays to each other.
		while (aLength > aInd && bLength > bInd) {
			if (a[aInd] >= b[bInd]) {
				c[cInd++] = b[bInd++];
			}
			else {
				c[cInd++] = a[aInd++];
			}
		}
		// This means array b is empty but a is not. Move its all elements to
		// array c.
		while (aLength > aInd) {
			c[cInd++] = a[aInd++];
		}

		// This means array a is empty but b is not. Move its all elements to
		// array c.
		while (bLength > bInd) {
			c[cInd++] = b[bInd++];
		}
		return c;
	}

}
