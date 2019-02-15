/**
 * 
 */
package com.sb.datastructures.stacks;

import com.sb.datastructures.linkedlist.LinkedListA;

/**
 * @author ankur.mahajan
 * @written 15-Feb-2019
 * 
 *          This class implements the stack by using LinkedList.
 */
public class StackByLinkedList<E> {

	private LinkedListA<E> list;

	public StackByLinkedList() {
		list = new LinkedListA<>();
	}

	public void push(E item) {
		list.insertFirst(item);
	}

	public E pop() {
		return list.deleteFirst();
	}

	public E peek() {

		return list.peekFirst();
	}

	public int size() {
		return list.size();
	}
}
