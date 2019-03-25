/**
 * 
 */
package com.sb.datastructures.hashtable;

/**
 * @author ankur.mahajan
 * @written 14-Mar-2019
 * 
 *          In open addressing, collisions are resolved by looking for an open
 *          cell in the hash table. A different approach is to install a linked
 *          list at each index in the hash table. A data item’s key is hashed to
 *          the index in the usual way, and the item is inserted into the linked
 *          list at that index. Other items that hash to the same index are
 *          simply added to the linked list; there’s no need to search for empty
 *          cells in the primary array.
 * 
 *          The load factor (the ratio of the number of items in a hash table to
 *          its size) is typically different in separate chaining than in open
 *          addressing. In separate chaining it’s normal to put N or more items
 *          into an N cell array; thus, the load factor can be 1 or greater.
 *          There’s no problem with this; some locations will simply contain two
 *          or more items in their lists.
 * 
 *          Use sorted Linked list if deletion and searching is priority and
 *          used normal linked list if insertion is priority.
 * 
 * 
 */
public class HashTableWithSeparateChaining<K, V> implements Table<K, V> {

	private HashTableWithSeparateChaining<? super K, ? super V>.LinkedList[] entries;

	private int size;

	@SuppressWarnings("unchecked")
	public HashTableWithSeparateChaining() {
		size = 0;
		entries = (HashTableWithSeparateChaining<? super K, ? super V>.LinkedList[]) new HashTableWithSeparateChaining<?, ?>.LinkedList[capacity];
		for (int i = 0; i < entries.length; i++) {
			entries[i] = new LinkedList();
		}
	}

	@Override
	public boolean put(K key, V value) {
		int hashFunction = Table.super.getHashFunction(key);
		size++;
		return entries[hashFunction].addFirst(key, value);
	}

	@Override
	public V find(K key) {
		int hashFunction = Table.super.getHashFunction(key);
		return (V) entries[hashFunction].find(key);
	}

	@Override
	public boolean delete(K key) {
		int hashFunction = Table.super.getHashFunction(key);
		return entries[hashFunction].delete(key);
	}

	/**
	 * @author ankur.mahajan
	 * @written 14-Mar-2019
	 */
	class LinkedList {

		/**
		 * @author ankur.mahajan
		 * @written 14-Mar-2019
		 */
		class Link {
			K key;

			V value;

			Link next;

			Link(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}

		private Link first;

		private int listSize;

		public LinkedList() {
			listSize = 0;
			first = null;
		}

		/**
		 * @param element
		 * @return {@link Boolean}
		 */
		boolean addFirst(K key, V value) {
			Link newLink = new Link(key, value);
			newLink.next = first;
			first = newLink;
			listSize++;
			return true;
		}

		/**
		 * @param key
		 * @return V
		 */
		V find(K key) {
			Link current = first;

			while (null != current) {
				if (current.key.equals(key)) {
					return current.value;
				}
				current = current.next;
			}
			return null;
		}

		/**
		 * @param key
		 * @return boolean
		 */
		boolean delete(K key) {
			boolean deleted = false;
			Link current = first;
			Link previous = null;
			while (null != current) {
				previous = current;
				if (current.key.equals(key)) {
					if (current == first) {
						first = current.next;
					}
					else {
						previous.next = current.next;
					}
					deleted = true;
					size--;
					break;
				}
				current = current.next;
			}

			return deleted;
		}

	}

}
