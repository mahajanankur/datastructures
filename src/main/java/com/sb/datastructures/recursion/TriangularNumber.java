/**
 * 
 */
package com.sb.datastructures.recursion;

/**
 * @author ankur.mahajan
 * @written 18-Feb-2019
 */
public class TriangularNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int position = 2;
		System.out.println(firstApproach(position));

	}

	private static int firstApproach(int position) {
		if (position == 1)
			return 1;
		return position + firstApproach(position - 1);
	}

}
