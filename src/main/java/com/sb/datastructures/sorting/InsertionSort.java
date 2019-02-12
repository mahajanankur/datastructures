/**
 * 
 */
package com.sb.datastructures.sorting;

import java.util.Arrays;

/**
 * @author ankur.mahajan
 * @written 08-Feb-2019
 */
public class InsertionSort {

	private static int comparisons;

	private static int swaps;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] arr = { 10, 4, 13, 6, 2, 15, 90, 4, 71 };
		int[] arr = { 24, 1, 78, 65, 3, 9, 67, 43 };
		int[] sorted = secondApproach(arr);
		Arrays.stream(sorted).forEach(n -> System.out.println(n));
		System.out.println("Comparisons [" + comparisons + "] and swaps [" + swaps + "]");
	}

	private static int[] firstApproach(int[] arr) {
		// int[] arr = { 4, 10, 13, 6, 2, 15, 90, 4, 71 };
		// i == 3
		for (int i = 1; i < arr.length; i++) {
			int low = i - 1;
			int high = i;
			while (low >= 0 && high > 0) {
				if (arr[low] > arr[high]) {
					int temp = arr[high];
					arr[high] = arr[low];
					arr[low] = temp;
					swaps++;
				}
				low--;
				high--;
				comparisons++;
			}
		}
		return arr;

	}

	// Best approach Comparisons [7] and swaps [12]
	private static int[] secondApproach(int[] arr) {
		// int[] arr = { 4, 10, 13, 6, 2, 15, 90, 4, 71 };
		// i == 3
		for (int i = 1; i < arr.length; i++) {
			int low = i - 1;
			int high = i;
			while (low >= 0 && arr[high] < arr[low]) {
				int temp = arr[high];
				arr[high] = arr[low];
				arr[low] = temp;
				swaps++;
				low--;
				high--;
			}
			comparisons++;
		}
		return arr;

	}

	private static int[] thirdApproach(int[] a) {
		int in, out;
		for (out = 1; out < a.length; out++) {
			int temp = a[out];
			in = out;
			while (in > 0 && a[in - 1] >= temp) {
				a[in] = a[in - 1];
				--in;
				swaps++;
			}
			a[in] = temp;
			comparisons++;
		}
		return a;
	}
}
