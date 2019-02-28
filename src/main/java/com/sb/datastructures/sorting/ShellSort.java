/**
 * 
 */
package com.sb.datastructures.sorting;

import java.util.Arrays;

/**
 * @author ankur.mahajan
 * @written 27-Feb-2019
 * 
 *          Shell sort has Best O(n^3/2)
 *          average O(n*log(n)^2)
 *          and worst O(n2) complexity.
 */
public class ShellSort {

	private static int comparisons;

	private static int swaps;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 24, 1, 78, 65, 3, 9, 67, 43 };
		int[] sortedArray = firstApproach(array);
		Arrays.stream(sortedArray).forEach(n -> System.out.println(n));

		System.out.println("Comparisons [" + comparisons + "] and swaps [" + swaps + "]");

	}

	// Comparisons [?] and swaps [?]
	private static int[] firstApproach(int[] array) {
		int gap = array.length / 2;

		int low = 0;
		int high = gap;
		
		

		return array;
	}

}
