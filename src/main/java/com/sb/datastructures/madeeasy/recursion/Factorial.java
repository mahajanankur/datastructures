/**
 * 
 */
package com.sb.datastructures.madeeasy.recursion;

/**
 * @author ankur.mahajan
 * @written 30-Apr-2019
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10;
		long fact = factorialByRecursion(n);
		System.out.println(fact);
	}

	private static long factorialByRecursion(int n) {
		if (n == 0)
			return 1;
		else
			return n * factorialByRecursion(n - 1);

	}

}
