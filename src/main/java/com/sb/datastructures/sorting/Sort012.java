/**
 * 
 */
package com.sb.datastructures.sorting;

/**
 * @author ankur.mahajan
 * @written 11-Dec-2018
 * 
 *          https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */
public class Sort012 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 2, 0, 2, 0, 0 };
		firstApproach(arr);

	}

	private static void firstApproach(int[] arr) {
		int low = 0;
		int mid = 0;
		int high = arr.length - 1;
		int temp = 0;

		while (high >= mid) {

			switch (arr[mid]) {
			case 0:
				temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			default:
				temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
				break;
			}
		}

		for (int j = 0; j < arr.length; j++) {
			if (j == arr.length - 1)
				System.out.print(arr[j]);
			else
				System.out.print(arr[j] + ", ");
		}
	}

}
