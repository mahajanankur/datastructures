/**
 * 
 */
package com.sb.datastructures.recursion;

/**
 * @author ankur.mahajan
 * @written 20-Feb-2019
 */
public class PowerToANumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 10;
		int y = 2;
		System.out.println(firstApproach(x, y));

	}

	private static int firstApproach(int x, int y) {
		if (y == 0)
			return 1;
		return x * firstApproach(x, y - 1);

	}

}
