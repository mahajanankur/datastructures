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

	/**
	 * Horner’s expression states that an expression like
	 * var4*n4 + var3*n3 + var2*n2 + var1*n1 + var0*n0
	 * can be written as
	 * (((var4*n + var3)*n + var2)*n + var1)*n + var0
	 * 
	 * @param key
	 * @return hashFunction
	 */
	default int getBestHashFunction(K key) {
		String str = key.toString();
		int hashFuction = 0;

		for (int i = 0; i < str.length(); i++) {
			int letter = str.charAt(i);
			hashFuction = (31 * hashFuction + letter) % capacity;
		}

		return hashFuction;
	}

}
