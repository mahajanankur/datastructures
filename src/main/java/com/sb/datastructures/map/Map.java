/**
 * 
 */
package com.sb.datastructures.map;

/**
 * @author ankur.mahajan
 * @written 14-Jun-2019
 */
public interface Map<K, V> {

	boolean put(K key, V value);

	V get(K key);

	int size();

	/**
	 * @param key
	 * @param capacity
	 * @return
	 */
	default int hashfunction(K key, int capacity) {
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
