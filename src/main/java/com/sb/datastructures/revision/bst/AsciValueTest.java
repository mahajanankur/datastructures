/**
 * 
 */
package com.sb.datastructures.revision.bst;

import java.util.Arrays;

/**
 * @author ankur.mahajan
 * @written 16-Jun-2019
 */
public class AsciValueTest<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Float a = 10.00f;
		if (a instanceof Number) {
			System.out.println(a);
		}
		
		AsciValueTest<Integer> fis = new AsciValueTest<>();
		System.out.println("Asci value of 10 is : " + fis.getAsciValue(10));
		System.out.println("Asci value of 120 is : " + fis.getAsciValue(120));
		System.out.println("Asci value of 1000000001 is : " + fis.getAsciValue(1000000001));
		System.out.println("Asci value of 999999999 is : " + fis.getAsciValue(999999999));
		
		
		AsciValueTest<String> two = new AsciValueTest<>();

		AsciValueTest<Object> thre = new AsciValueTest<>();

		AsciValueTest<Double> four = new AsciValueTest<>();
	}

	public int getAsciValue(T con) {
		char[] charArray = con.toString().toCharArray();
		int number = 0;
		for (int i = 0; i < charArray.length; i++) {
			number += charArray[i];
		}
		return number;
	}

}
