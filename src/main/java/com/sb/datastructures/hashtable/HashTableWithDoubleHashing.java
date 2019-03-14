/**
 * 
 */
package com.sb.datastructures.hashtable;

/**
 * @author ankur.mahajan
 * @written 14-Mar-2019
 * 
 *          Double Hashing is the best and proffered technique in open
 *          addressing approach. In this a step constant (prime number and less
 *          the array size) is taken.
 * 
 *          To eliminate secondary clustering as well as primary clustering, we
 *          can use another approach: double hashing. Secondary clustering
 *          occurs because the algorithm that
 *          generates the sequence of steps in the quadratic probe always
 *          generates the same steps: 1, 4, 9, 16, and so on. What we need is a
 *          way to generate probe sequences that depend on the key instead of
 *          being the same for every key. Then numbers with different keys that
 *          hash to the same index will use different probe sequences.
 * 
 *          stepSize = constant - (key % constant);
 *          Where constant is prime and smaller than the array size.
 */
public class HashTableWithDoubleHashing<K, V> implements Table<K, V> {

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

	private Entry<?, ?>[] entries;

	// Take step constant a prime number smaller than the capacity of array so
	// that probing can check each array index for emptiness otherwise only
	// certain indexes will be checked.
	private static final int STEP_CONSTANT = 11;

	private int count;

	public HashTableWithDoubleHashing() {
		entries = new Entry<?, ?>[capacity];
		count = 0;
	}

	@Override
	public boolean put(K key, V value) {
		int hashFunction = Table.super.getHashFunction(key);
		int stepSize = getStepSize(key);
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		while (null != entries[hashFunction] && !entries[hashFunction].key.equals(-1)) {
			hashFunction += stepSize;
			hashFunction %= capacity;
		}
		entries[hashFunction] = newEntry;
		count++;
		return true;
	}

	@Override
	public V find(K key) {
		int hashFunction = Table.super.getHashFunction(key);
		int stepSize = getStepSize(key);
		while (null != entries[hashFunction]) {
			if (entries[hashFunction].key.equals(key)) {
				return (V) entries[hashFunction].value;
			}
			hashFunction += stepSize;
			hashFunction %= capacity;
		}
		return null;
	}

	@Override
	public boolean delete(K key) {
		int hashFunction = Table.super.getHashFunction(key);
		int stepSize = getStepSize(key);
		Entry<Integer, V> newEntry = new Entry<Integer, V>(-1, null);
		while (null != entries[hashFunction]) {
			if (entries[hashFunction].key.equals(key)) {
				entries[hashFunction] = newEntry;
				return true;
			}
			hashFunction += stepSize;
			hashFunction %= capacity;
		}
		return false;
	}

	/**
	 * @param key
	 * @return stepSize
	 */
	private int getStepSize(K key) {
		int stepSize = STEP_CONSTANT - ((int) key % STEP_CONSTANT);
		return stepSize;
	}

}
