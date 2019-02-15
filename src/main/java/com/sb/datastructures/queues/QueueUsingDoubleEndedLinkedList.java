/**
 * 
 */
package com.sb.datastructures.queues;

import com.sb.datastructures.linkedlist.DoubleEndedLinkedList;

/**
 * @author ankur.mahajan
 * @written 15-Feb-2019
 */
public class QueueUsingDoubleEndedLinkedList<E> {

	private DoubleEndedLinkedList<E> list;

	public QueueUsingDoubleEndedLinkedList() {
		list = new DoubleEndedLinkedList<>();
	}

	public void enqueue(E item) {
		list.addLast(item);
	}

	public E dequeue() {
		return list.deleteFirst();
	}

	public E peek() {
		return list.displayFirst();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int size() {
		return list.size();
	}
}
