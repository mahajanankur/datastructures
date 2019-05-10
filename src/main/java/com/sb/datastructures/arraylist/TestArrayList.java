/**
 * 
 */
package com.sb.datastructures.arraylist;

/**
 * @author ankur.mahajan
 * @written 01-May-2019
 */
public class TestArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(0);
		list.add(101);
		list.add(8);
		list.add(-10);
		list.add(010);
		
		System.out.println(list.get(2));
	}

}
