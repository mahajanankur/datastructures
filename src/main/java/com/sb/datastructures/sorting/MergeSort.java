/**
 * 
 */
package com.sb.datastructures.sorting;

/**
 * @author ankur.mahajan
 * @written 07-Sep-2018
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 24, 1, 78, 65, 3, 9, 67, 43 };
		int[] sortedArray = sort(array, 0, array.length - 1);
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.println(sortedArray[i]);
		}

	}

	private static int[] sort(int[] array, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			// convert into small arrays till the size become one sort first
			// half
			sort(array, left, middle);
			// sort second half
			sort(array, middle + 1, right);

			return merge(array, left, right, middle);
		}

		return null;
	}

	private static int[] merge(int[] array, int left, int right, int middle) {
		int nL = middle - left + 1;
		int nR = right - middle;

		int[] arrayLeft = new int[nL];
		int[] arrayRight = new int[nR];
		// form left array.
		for (int i = 0; i < nL; i++) {
			arrayLeft[i] = array[left + i];
		}
		// form right array.
		for (int i = 0; i < nR; i++) {
			arrayRight[i] = array[middle + 1 + i];
		}

		int i = 0, j = 0;
		int k = left;

		while (i < nL && j < nR) {
			if (arrayLeft[i] >= arrayRight[j]) {
				array[k] = arrayRight[j];
				j++;
			}
			else {
				array[k] = arrayLeft[i];
				i++;
			}
			k++;
		}

		while (i < nL) {
			array[k] = arrayLeft[i];
			i++;
			k++;
		}
		while (j < nR) {
			array[k] = arrayRight[j];
			j++;
			k++;
		}
		return array;
	}

}
