/**
 * 
 */
package com.sb.datastructures.map;

/**
 * @author ankur.mahajan
 * @written 14-Jun-2019
 */
public class HashMap<K, V> implements Map<K, V> {

	static class Entry<K, V> {
		K key;
		V value;
		int hashcode;
		Entry<K, V> next;

		public Entry(K key, V value, int hashcode) {
			super();
			this.key = key;
			this.value = value;
			this.hashcode = hashcode;
		}

	}

	private LinkedList[] entryArray;

	private int size;

	private int CAPACITY = 16;

	// private float LOAD_FACTOR = 0.75f;

	@SuppressWarnings("unchecked")
	public HashMap() {
		size = 0;
		entryArray = (HashMap<K, V>.LinkedList[]) new HashMap<?, ?>.LinkedList[CAPACITY];
	}

	/**
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean put(K key, V value) {
		int hashfunction = Map.super.hashfunction(key, CAPACITY);
		HashMap<K, V>.LinkedList linkedList = entryArray[hashfunction];
		Entry<K, V> oldEntry = null;
		if (null == linkedList) {
			linkedList = new LinkedList();
			entryArray[hashfunction] = linkedList;
		} else {
			oldEntry = linkedList.get(key);
		}
		// Add and get from LinkedList
		if (null != oldEntry) {
			oldEntry.value = value;
		} else {
			Entry<K, V> nEntry = new Entry<K, V>(key, value, hashfunction);
			linkedList.addLast(nEntry);
			size++;
		}

		return true;
	}

	public V get(K key) {
		return null;
	}

	public int size() {
		return size;
	}

	/**
	 * @author ankur.mahajan
	 * @written 14-Jun-2019
	 */
	class LinkedList {

		Entry<K, V> first;

		Entry<K, V> last;

		public LinkedList() {
			first = null;
			last = null;
		}

		/**
		 * @param element
		 * @return boolean
		 */
		boolean addLast(Entry<K, V> element) {
			if (null == first) {
				first = element;
			} else {
				last.next = element;
			}
			last = element;
			return true;
		}

		/**
		 * @param key
		 * @return
		 */
		Entry<K, V> get(K key) {
			Entry<K, V> current = first;
			while (null != current) {
				if (current.key.equals(key)) {
					return current;
				}
				current = current.next;
			}
			return null;
		}

	}

}
