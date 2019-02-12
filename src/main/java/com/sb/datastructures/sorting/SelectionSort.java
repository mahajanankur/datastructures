/**
 * 
 */
package com.sb.datastructures.sorting;

import java.util.Arrays;

/**
 * @author ankur.mahajan
 * @written 05-Sep-2018
 */
public class SelectionSort {

	private static int comparisons;

	private static int swaps;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 24, 1, 78, 65, 3, 9, 67, 43 };
		int[] sortedArray = firstApproach(array);
		Arrays.stream(sortedArray).forEach(System.out::println);
		System.out.println("Comparisons [" + comparisons + "] and swaps [" + swaps + "]");

	}

	// Comparisons [28] and swaps [8]
	private static int[] firstApproach(int[] array) {
		// int[] sortedArray = new int[array.length];
		int minimum = 0;
		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			minimum = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (minimum > array[j]) {
					minimum = array[j];
					minIndex = j;
				}
				comparisons++;
			}
			array[minIndex] = array[i];
			array[i] = minimum;
			swaps++;
		}
		return array;
	}

}
