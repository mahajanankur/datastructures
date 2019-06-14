/**
 * 
 */
package com.sb.datastructures.revision.stack;

/**
 * @author ankur.mahajan
 * @written 10-Jun-2019
 */
public class AirthmaticExpressionCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String exp = "(2 *2) + 3 - (2 -8)";
		char[] charArray = exp.toCharArray();
		firstApproach(charArray);

	}

	private static void firstApproach(char[] charArray) {
		Stack<Double> values = new Stack<>(charArray.length);
		Stack<String> expression = new Stack<>(charArray.length);
		
		

	}

}
