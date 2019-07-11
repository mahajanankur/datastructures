/**
 * 
 */
package com.sb.datastructures.revision.searching;

import java.util.Arrays;

/**
 * @author ankur.mahajan
 * @written 10-Jun-2019
 */
public class BinarySearch {

	private static int comparisions = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] arr = {10, 28, 5, 45, 78, 87, 4, 0, 67, 8, 10, 19, 56};
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int n = 8;
		int high = arr.length - 1;
		int low = 0;
		Arrays.sort(arr);
		int index = firstApproach(arr, low, high, n);
		System.out.println(index);
		System.out.println("Number of comarisons : " + comparisions);

		// secondApproach(arr, low, high, n);
	}

	// with not return statement -- NOT RIGHT
	private static void secondApproach(int[] arr, int low, int high, int number) {
		// base condition.
		if (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == number) {
				System.out.println("Index is : " + mid);
				return;
			} else if (arr[mid] > number) {
				high = mid - 1;
				secondApproach(arr, low, high, number);
			} else if (arr[mid] < number) {
				low = mid + 1;
				secondApproach(arr, low, high, number);
			}
		}
		if (low > high) {
			System.out.println("Index is : " + -1);
			return;
		}

	}

	// with return statement
	private static int firstApproach(int[] arr, int low, int high, int number) {
		// base condition.
		if (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == number) {
				// System.out.println("Index is : " + mid);
				return mid;
			} else if (arr[mid] > number) {
				high = mid - 1;
				comparisions++;
				return firstApproach(arr, low, high, number);
			} else if (arr[mid] < number) {
				low = mid + 1;
				comparisions++;
				return firstApproach(arr, low, high, number);
			}
		}
		return -1;
	}

}
