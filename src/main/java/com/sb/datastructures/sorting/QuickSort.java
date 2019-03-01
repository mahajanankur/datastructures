/**
 * 
 */
package com.sb.datastructures.sorting;

import java.util.Arrays;

/**
 * @author ankur.mahajan
 * @written 28-Feb-2019
 */
public class QuickSort {

	private static int comparisons;

	private static int swaps;

	private static int[] array = { 24, 1, 78, 65, 3, 9, 67, 43 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int left = 0;
		int right = array.length - 1;
		// simplePivotPartionaingQuickSort(left, right);
		medianOf3PivotPartionaingQuickSort(left, right);

		System.out.println("After Quick Sorting.");
		Arrays.stream(array).forEach(n -> System.out.println(n));

		System.out.println("Comparisons [" + comparisons + "] and swaps [" + swaps + "]");

	}

	private static void medianOf3PivotPartionaingQuickSort(int left, int right) {
		// Base condition
		if (left >= right) {
			return;
		}

		int pivot = medianOf3(left, right);

		int partitionIndex = partitionArray(left, right, pivot);

		// sort left half
		medianOf3PivotPartionaingQuickSort(left, partitionIndex - 1);

		// Sort right half
		medianOf3PivotPartionaingQuickSort(partitionIndex + 1, right);
	}

	private static int medianOf3(int left, int right) {
		int center = (left + right) / 2;
		// Compare left with right
		if (array[left] > array[right])
			swap(left, right);
		// Compare left with center
		if (array[left] > array[center])
			swap(left, center);
		// Compare right with center
		if (array[right] > array[center])
			swap(right, center);

		// Swap center with right to place it on last element of array.
		swap(center, right);
		return array[right];
	}

	private static void simplePivotPartionaingQuickSort(int left, int right) {
		// Base condition
		if (left >= right) {
			return;
		}

		int pivot = array[right];
		int partitionIndex = partitionArray(left, right, pivot);

		// sort left half
		simplePivotPartionaingQuickSort(left, partitionIndex - 1);

		// Sort right half
		simplePivotPartionaingQuickSort(partitionIndex + 1, right);
	}

	/**
	 * This method is used to partition the array based on pivot value.
	 * 
	 * @param left
	 * @param right
	 * @param pivot
	 * @return index
	 */
	private static int partitionArray(int left, int right, int pivot) {
		int leftPointer = left - 1;
		// Exclude pivot so take the last index as right pointer
		int rightPointer = right;
		while (true) {
			while (leftPointer < right && array[++leftPointer] < pivot) {
				comparisons++;
				// Do nothing, only check the pointer where number is greater
				// than pivot.
			}
			while (rightPointer > left && array[--rightPointer] > pivot) {
				comparisons++;
				// Do nothing, only check the pointer where number is greater
				// than pivot.
			}
			if (rightPointer <= leftPointer)
				break;
			else 			// Swap the elements
				swap(leftPointer, rightPointer);
		}
		// place pivot to the actual position by swapping it to last element of
		// left array.
		swap(leftPointer, right);
		return leftPointer;
	}

	/**
	 * @param leftPointer
	 * @param rightPointer
	 */
	private static void swap(int leftPointer, int rightPointer) {
		int temp = array[leftPointer];
		array[leftPointer] = array[rightPointer];
		array[rightPointer] = temp;
		swaps++;
	}

}
