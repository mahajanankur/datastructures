/**
 * 
 */
package com.sb.datastructures.madeeasy.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankur.mahajan
 * @written 30-Apr-2019
 */
public class AllBinaryStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int length = 3;
		String[] res = new String[length];
		binaryStringsByRecursion(length, res);

	}

	private static void binaryStringsByRecursion(int length, String[] res) {
		if (length < 1)
			System.out.println(res);
		//res[length-1] = 0;
		binaryStringsByRecursion(length-1, res);
		
	}

}
