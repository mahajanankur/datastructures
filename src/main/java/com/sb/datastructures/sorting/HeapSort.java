/**
 * 
 */
package com.sb.datastructures.sorting;

import java.util.Arrays;

/**
 * @author ankur.mahajan
 * @written 20-Mar-2019
 */
public class HeapSort {

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

	private static int[] firstApproach(int[] array) {
		Heap heap = new Heap(array.length);
		// First insert element in heap.
		for (int i = 0; i < array.length; i++) {
			heap.insert(array[i]);
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = heap.remove();
		}
		return array;
	}

	/**
	 * @author ankur.mahajan
	 * @written 20-Mar-2019
	 * 
	 *          Implementation of Heap of integers by array.
	 */
	static class Heap {

		private int[] heapArray;

		private int currentIndex;

		public Heap(int size) {
			currentIndex = 0;
			heapArray = new int[size];
		}

		protected boolean insert(int element) {
			if (isFull())
				return false;
			heapArray[currentIndex] = element;
			trickleUp(currentIndex++);
			return true;
		}

		/**
		 * Remove root element.
		 * 
		 * @return
		 */
		protected int remove() {
			int root = heapArray[0];
			heapArray[0] = heapArray[--currentIndex];
			trickleDown(0);
			return root;
		}

		private void trickleDown(int index) {
			while (index < currentIndex / 2) {
				int leftChild = 2 * index + 1;
				int rightChild = leftChild + 1;

				if (heapArray[index] < heapArray[leftChild] && heapArray[leftChild] > heapArray[rightChild]) {
					int temp = heapArray[index];
					heapArray[index] = heapArray[leftChild];
					heapArray[leftChild] = temp;
					index = leftChild;
				}
				else if (heapArray[index] < heapArray[rightChild] && heapArray[leftChild] < heapArray[rightChild]) {
					int temp = heapArray[index];
					heapArray[index] = heapArray[rightChild];
					heapArray[rightChild] = temp;
					index = rightChild;
				}
				else {
					break;
				}
			}

		}

		private void trickleUp(int index) {
			int parent = (index - 1) / 2;
			int bottom = heapArray[index];

			while (index >= 0 && bottom > heapArray[parent]) {
				heapArray[index] = heapArray[parent];
				heapArray[parent] = bottom;
				index = parent;
				parent = (index - 1) / 2;
			}

		}

		/**
		 * @return boolean
		 */
		protected boolean isFull() {
			return currentIndex >= heapArray.length ? true : false;
		}
	}

}
