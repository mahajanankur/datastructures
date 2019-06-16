/**
 * 
 */
package com.sb.datastructures.map;

/**
 * @author ankur.mahajan
 * @written 14-Jun-2019
 */
public class TestHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(12, "g");
		map.put(23, "h");
		map.put(1, "d");
		map.put(4, "e");
		map.put(1, "f");
		map.put(13, "i");

		System.out.println(map.size());
		System.out.println(map.get(1));

		// TestHashMap test = new TestHashMap();
		// for (int i = 0; i < 100; i++) {
		// test.hashfunction(i, 16);
		// }

	}

	public int hashfunction(Integer key, int capacity) {
		String str = key.toString();
		char[] charArray = str.toCharArray();
		int hashfuntion = 0;
		for (int i = 0; i < charArray.length; i++) {
			int asci = charArray[i];
			hashfuntion = (31 * hashfuntion + asci) % capacity;
		}

		return hashfuntion;
	}

}
