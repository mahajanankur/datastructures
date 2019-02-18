/**
 * 
 */
package com.sb.datastructures.sorting;

import java.util.Arrays;

import com.sb.datastructures.linkedlist.SortedLinkedList;

/**
 * @author ankur.mahajan
 * @written 16-Feb-2019
 */
public class SortArrayUsingSortedLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 2, 0, 56, 3, 67, 1, -1, 54, -190 };
		sortArray(arr);
	}

	private static void sortArray(int[] arr) {
		SortedLinkedList<Integer> sortedList = new SortedLinkedList<>();
		for (int i : arr) {
			sortedList.add(i);
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sortedList.deleteFirst();
		}

		Arrays.stream(arr).forEach(System.out::println);

	}

}
