/**
 * 
 */
package com.sb.datastructures.linkedlist;

import com.sb.datastructures.linkedlist.DoublyLinkedList.Link;

/**
 * @author ankur.mahajan
 * @written 18-Feb-2019
 * 
 *          More methods to add.
 *          reset()—Sets the iterator to the start of the list
 *          nextLink()—Moves the iterator to the next link
 *          getCurrent()—Returns the link at the iterator
 *          atEnd()—Returns true if the iterator is at the end of the list
 *          insertAfter()—Inserts a new link after the iterator
 *          insertBefore()—Inserts a new link before the iterator
 *          deleteCurrent()—Deletes the link at the iterator
 */
public class ListIterator<E> {

	private DoublyLinkedList<E>.Link current;

	private DoublyLinkedList<E>.Link previous;

	private DoublyLinkedList<E> list;

	public ListIterator(DoublyLinkedList<E> list) {
		this.list = list;
		reset();
	}

	public void reset() {
		current = list.first;
		previous = null;

	}

	public boolean hasNext() {
		// return null == current ? false : (null == current.next ? false :
		// true);
		return null == current ? false : true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public E next() {
		Link temp = current;
		previous = current;
		current = current.next;
		return (E) temp.item;
	}

	public boolean addAfter(E item) {
		list.addAfter((E) current.item, item);
		return true;
	}
}
