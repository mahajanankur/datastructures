/**
 * 
 */
package com.sb.datastructures.stacks;

/**
 * @author ankur.mahajan
 * @written 11-Feb-2019
 */
public class BracketChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();

	}

	private static void firstApproach() {
		String s = "a{b(c]d}e";
		StackA<Character> stack = new StackA<>(s.length());
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			Character pop = null;
			switch (charArray[i]) {
			case '(':
			case '{':
			case '[':
				stack.push(charArray[i]);
				break;

			case ')':
				pop = stack.pop();
				if (pop != '(') {
					throw new RuntimeException("No opening for )");
				}
				break;
			case '}':
				pop = stack.pop();
				if (pop != '{') {
					throw new RuntimeException("No opening for }");
				}
				break;
			case ']':
				pop = stack.pop();
				if (pop != '[') {
					throw new RuntimeException("No opening for ]");
				}
				break;
			}
		}
		System.out.println("String is correct.");

	}

}
