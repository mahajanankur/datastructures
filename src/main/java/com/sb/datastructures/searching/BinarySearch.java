/**
 * 
 */
package com.sb.datastructures.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ankur.mahajan
 * @written 05-Sep-2018
 */
public class BinarySearch {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		firstApproach();
		// secondApproach();

	}

	private static int binarySearchAlgo2(int[] array, int search) {
		int lowerBound = 0;
		int upperBound = array.length - 1;
		while (upperBound >= lowerBound) {
			int middleBound = (lowerBound + upperBound) / 2;
			if (array[middleBound] == search) {
				return middleBound;
			} else {
				if (array[middleBound] > search)
					upperBound = middleBound - 1;
				else
					lowerBound = middleBound + 1;
			}
		}

		return -1;
	}

	private static void firstApproach() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int search = Integer.parseInt(br.readLine());
		//int[] array = {1, 3, 6, 8, 9, 15, 19, 23};
		int[] array = {10, 28, 5, 45, 78, 87, 4, 0, 67, 8, 10, 19, 56};
		Arrays.sort(array);
		int start = array.length - 1;
		int low = 0;
		int index = binarySearchAlgo(array, search, low, start);
		// int index = binarySearchAlgo2(array, search);
		System.out.println(index);
		br.close();
	}

	private static int binarySearchAlgo(int[] array, int search, int low, int high) {
		if (low <= high) {
			int middleIndex = (low + high) / 2;
			if (array[middleIndex] == search) {
				return middleIndex;
			}
			if (array[middleIndex] > search) {
				return binarySearchAlgo(array, search, low, middleIndex - 1);
			} else if (array[middleIndex] < search) {
				return binarySearchAlgo(array, search, middleIndex + 1, high);
			}
		}
		return -1;

	}

}
