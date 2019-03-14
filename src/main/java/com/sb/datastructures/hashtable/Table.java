/**
 * 
 */
package com.sb.datastructures.hashtable;

/**
 * @author ankur.mahajan
 * @written 13-Mar-2019
 */
public interface Table<K, V> {

	final int capacity = 16;

	boolean put(K key, V value);

	V find(K key);

	boolean delete(K key);

	/**
	 * @param key
	 * @return hashFunction
	 */
	default int getHashFunction(K key) {
		int hashcode = getHashcode(key);
		int hashFunction = hashcode % capacity;
		return hashFunction;
	};

	/**
	 * @param key
	 * @return hashcode
	 */
	default int getHashcode(K key) {
		String strValue = key.toString();
		int length = strValue.length();
		int hashcode = 0;
		for (int i = length - 1; i >= 0; i--) {
			hashcode += strValue.charAt(i);
		}
		return hashcode;

	}

}
