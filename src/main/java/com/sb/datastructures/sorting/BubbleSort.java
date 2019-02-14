/**
 * 
 */
package com.sb.datastructures.sorting;

import java.util.Arrays;

/**
 * @author ankur.mahajan
 * @written 05-Sep-2018
 * 
 *          Bubble sort has O(n2) complexity.
 */
public class BubbleSort {

	private static int comparisons;

	private static int swaps;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 24, 1, 78, 65, 3, 9, 67, 43 };
		int[] sortedArray;
		// sortedArray = firstApproach(array);
		// TODO - More better in performance.
		sortedArray = secondApproach(array);
		Arrays.stream(sortedArray).forEach(n -> System.out.println(n));

		System.out.println("Comparisons [" + comparisons + "] and swaps [" + swaps + "]");

	}

	// More better in performance. Ignore last element because in every complete
	// iteration the largest number on right.
	// Comparisons [27] and swaps [12]
	private static int[] secondApproach(int[] array) {
		for (int i = array.length - 1; i > 1; i--) {

			for (int j = 0; j < i; j++) {
				int temp = 0;
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swaps++;
				}
				comparisons++;
			}
		}
		return array;
	}

	// Comparisons [56] and swaps [12]
	private static int[] firstApproach(int[] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				int temp = 0;
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swaps++;
				}
				comparisons++;
			}
		}
		return array;
	}

}
