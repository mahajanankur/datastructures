/**
 * 
 */
package com.sb.datastructures.queues;

import com.sb.datastructures.linkedlist.SortedLinkedList;

/**
 * @author ankur.mahajan
 * @written 18-Feb-2019
 */
public class PriorityQueueUsingSortedLinkedList<E extends Number> {

	private SortedLinkedList<E> sortedList;

	public PriorityQueueUsingSortedLinkedList() {
		sortedList = new SortedLinkedList<>();
	}

	public boolean push(E item) {
		sortedList.add(item);
		return true;
	}

	public E pop() {
		return sortedList.deleteFirst();
	}

	public E peek() {

		return null;
	}

}
