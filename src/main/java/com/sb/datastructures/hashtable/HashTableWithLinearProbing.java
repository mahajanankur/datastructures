/**
 * 
 */
package com.sb.datastructures.hashtable;

/**
 * @author ankur.mahajan
 * @written 11-Mar-2019
 * 
 *          Linear probing is a hash collision approach. It comes under OPEN
 *          Addressing. In this when a collision occur we find next empty index
 *          linearly.
 *          In a linear probe, if the primary hash index is x, subsequent probes
 *          go to x+1, x+2, x+3, and so on.
 */
public class HashTableWithLinearProbing<K, V> implements Table<K, V> {

	/**
	 * @author ankur.mahajan
	 * @written 12-Mar-2019
	 * @param <K>
	 * @param <V>
	 */
	static class Entry<K, V> {

		K key;

		V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

	private Entry<?, ?>[] entry;

	private final int capacity = 16;

	private int count;

	public HashTableWithLinearProbing() {
		count = 0;
		entry = new Entry<?, ?>[capacity];
	}

	/**
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean put(K key, V value) {
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		int hashFunction = getHashFunction(key);
		while (null != entry[hashFunction] && !entry[hashFunction].key.equals(-1)) {
			++hashFunction;
			// Wrap it around the size of the array.
			hashFunction %= capacity;
		}
		entry[hashFunction] = newEntry;
		count++;
		return true;
	}

	/**
	 * @param key
	 * @return
	 */
	// @SuppressWarnings("unchecked")
	public V find(K key) {
		int hashFunction = getHashFunction(key);
		while (null != entry[hashFunction]) {
			if (entry[hashFunction].key.equals(key)) {
				return (V) entry[hashFunction].value;
			}
			++hashFunction;
			// Wrap it around the size of the array.
			hashFunction %= capacity;
		}
		return null;
	}

	public boolean delete(K key) {
		int hashFunction = getHashFunction(key);
		Entry<Integer, V> newEntry = new Entry<Integer, V>(-1, null);
		while (null != entry[hashFunction]) {
			if (entry[hashFunction].key.equals(key)) {
				// Set new Entry as this.
				entry[hashFunction] = newEntry;
				return true;
			}
			++hashFunction;
			// Wrap it around the size of the array.
			hashFunction %= capacity;
		}

		return false;
	}

	/**
	 * @param key
	 * @return
	 */
	public int getHashFunction(K key) {
		// if (key instanceof String) {
		String stringKey = key.toString();
		int hashcode = 0;
		for (int i = stringKey.length() - 1; i >= 0; i--) {
			hashcode += stringKey.charAt(i);
		}

		int hashFunction = hashcode % capacity;

		// }
		return hashFunction;
	}

}
