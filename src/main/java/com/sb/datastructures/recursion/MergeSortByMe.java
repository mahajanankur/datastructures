/**
 * 
 */
package com.sb.datastructures.recursion;

import java.util.Arrays;

/**
 * @author ankur.mahajan
 * @written 19-Feb-2019
 * 
 *          Worst/Average/Best O(n*logn)
 */
public class MergeSortByMe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 24, 1, 78, 65, 3, 9, 67, 43 };

		int[] sorted = firstApproachSort(a, a.length);

		Arrays.stream(sorted).forEach(n -> System.out.println(n));
	}

	private static int[] firstApproachSort(int[] a, int length) {
		// Base condition to stop recursion. Array is considered sorted if
		// length is 1.
		if (length == 1) {
			return null;
		}
		else {
			// Get mid element, we split the array into two half's with it.
			int mid = length / 2;
			// Make two sub-arrays.
			int[] leftArray = new int[mid];
			int[] rightArray = new int[length - mid];
			for (int i = 0; i < leftArray.length; i++) {
				leftArray[i] = a[i];
			}

			for (int i = 0; i < rightArray.length; i++) {
				rightArray[i] = a[mid + i];
			}

			// Split the left half again.
			firstApproachSort(leftArray, leftArray.length);

			// Split the right half again.
			firstApproachSort(rightArray, rightArray.length);

			return mergeSort(a, leftArray, rightArray);
		}

	}

	private static int[] mergeSort(int[] actual, int[] leftArray, int[] rightArray) {
		int leftInd = 0, rightInd = 0, actualInd = 0;
		// Compare the elements of the left and right array with each other and
		// correspondingly put them to actual array.
		while (leftArray.length > leftInd && rightArray.length > rightInd) {
			if (leftArray[leftInd] > rightArray[rightInd]) {
				actual[actualInd++] = rightArray[rightInd++];
			}
			else {
				actual[actualInd++] = leftArray[leftInd++];
			}
		}
		// This means array right is empty but left is not. Move its all
		// elements to actual.
		while (leftArray.length > leftInd) {
			actual[actualInd++] = leftArray[leftInd++];
		}
		// This means array left is empty but right is not. Move its all
		// elements to actual.
		while (rightArray.length > rightInd) {
			actual[actualInd++] = rightArray[rightInd++];
		}
		return actual;
	}

}
