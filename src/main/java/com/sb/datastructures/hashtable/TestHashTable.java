/**
 * 
 */
package com.sb.datastructures.hashtable;

/**
 * @author ankur.mahajan
 * @written 12-Mar-2019
 */
public class TestHashTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int old = 4;
		// System.out.println(Integer.toBinaryString(old));
		// int newCapacity = (old << 1) + 1;
		// System.out.println(newCapacity);
		// testHashTableWithLinearProbing();
		// testHashTableWithQuadraticProbing();
		// testHashTableWithDoubleHashing();
		testHashTableWithSeparateChaining();

	}

	private static void testHashTableWithSeparateChaining() {
		HashTableWithSeparateChaining<Integer, String> table = new HashTableWithSeparateChaining<>();
		table.put(10, "ankur");
		table.put(20, "jatin");
		table.put(30, "atu");
		table.put(10, "happu");

		System.out.println("Delete Key 10 : " + table.delete(10));

		System.out.println("Find Key 10 : " + table.find(10));

	}

	private static void testHashTableWithDoubleHashing() {
		HashTableWithDoubleHashing<Integer, String> table = new HashTableWithDoubleHashing<>();
		table.put(10, "ankur");
		table.put(20, "jatin");
		table.put(30, "atu");
		table.put(10, "happu");

		System.out.println("Delete Key 10 : " + table.delete(10));

		System.out.println("Find Key 10 : " + table.find(10));

	}

	private static void testHashTableWithQuadraticProbing() {
		HashTableWithQuadraticProbing<Integer, String> table = new HashTableWithQuadraticProbing<>();
		table.put(10, "ankur");
		table.put(20, "jatin");
		table.put(30, "atu");
		table.put(10, "happu");

		System.out.println("Delete Key 10 : " + table.delete(10));

		System.out.println("Find Key 10 : " + table.find(10));

	}

	private static void testHashTableWithLinearProbing() {
		HashTableWithLinearProbing<Integer, String> table = new HashTableWithLinearProbing<>();
		table.put(10, "ankur");
		table.put(20, "jatin");
		table.put(30, "atu");
		table.put(10, "happu");

		System.out.println("Delete Key 10 : " + table.delete(10));

		System.out.println("Find Key 10 : " + table.find(10));
		// table.find(50);

	}

}
