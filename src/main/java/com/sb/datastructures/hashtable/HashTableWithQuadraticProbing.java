/**
 * 
 */
package com.sb.datastructures.hashtable;

/**
 * @author ankur.mahajan
 * @written 13-Mar-2019
 * 
 *          This is a better approach then linear probing due to cluster forming
 *          because we have to check adjacent elements in it but In quadratic
 *          probing we find empty cell at a distance apart with h = h + n^2,
 *          where h is hash-factor and n is the iteration. In this
 *          implementation n is increment.
 */
public class HashTableWithQuadraticProbing<K, V> implements Table<K, V> {

	static class Entry<K, V> {

		K key;

		V value;

		/**
		 * @param key
		 * @param value
		 */
		public Entry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

	}

	private int count;

	private Entry<?, ?>[] entry;

	public HashTableWithQuadraticProbing() {
		count = 0;
		entry = new Entry<?, ?>[capacity];
	}

	public boolean put(K key, V value) {
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		int hashFunction = Table.super.getHashFunction(key);
		int increment = 1;
		while (null != entry[hashFunction] && !entry[hashFunction].key.equals(-1)) {
			hashFunction = (int) (hashFunction + Math.pow(increment++, 2));
			// Wrap it around the size of the array.
			hashFunction %= capacity;
		}
		entry[hashFunction] = newEntry;
		count++;
		return true;
	}

	@Override
	public V find(K key) {
		int hashFunction = Table.super.getHashFunction(key);
		int increment = 1;
		while (null != entry[hashFunction]) {
			if (entry[hashFunction].key.equals(key)) {
				return (V) entry[hashFunction].value;
			}
			hashFunction = (int) (hashFunction + Math.pow(increment++, 2));
			// Wrap it around the size of the array.
			hashFunction %= capacity;
		}
		return null;
	}

	@Override
	public boolean delete(K key) {
		Entry<Integer, V> newEntry = new Entry<Integer, V>(-1, null);
		int hashFunction = Table.super.getHashFunction(key);
		int increment = 1;
		while (null != entry[hashFunction]) {
			if (entry[hashFunction].key.equals(key)) {
				entry[hashFunction] = newEntry;
				count--;
				return true;
			}
			hashFunction = (int) (hashFunction + Math.pow(increment++, 2));
			// Wrap it around the size of the array.
			hashFunction %= capacity;
		}
		return false;
	}

}
