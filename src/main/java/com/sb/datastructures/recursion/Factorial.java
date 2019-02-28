/**
 * 
 */
package com.sb.datastructures.recursion;

/**
 * @author ankur.mahajan
 * @written 18-Feb-2019
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int number = 4;
		System.out.println(firstApproach(number));

	}

	private static int firstApproach(int number) {
		if (number == 0)
			return 1;
		return number * firstApproach(number - 1);
	}

}
