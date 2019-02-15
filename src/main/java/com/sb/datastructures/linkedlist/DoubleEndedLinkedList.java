/**
 * 
 */
package com.sb.datastructures.linkedlist;

/**
 * @author ankur.mahajan
 * @written 15-Feb-2019
 * 
 *          The double-ended list is called the FirstLastList.
 */
public class DoubleEndedLinkedList<E> {

	class Link {

		E item;

		Link next;

		Link(E item) {
			this.item = item;
		}
	}

	private Link first;

	private Link last;

	private int size;

	public DoubleEndedLinkedList() {
		size = 0;
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return (null == first);
	}

	public int size() {
		return size;
	}

	public void addFirst(E item) {
		Link newLink = new Link(item);
		if (isEmpty())
			last = newLink;
		newLink.next = first;
		first = newLink;
		size++;
	}

	public void addLast(E item) {
		Link newLink = new Link(item);
		if (isEmpty())
			first = newLink;
		else
			last.next = newLink;
		last = newLink;
		size++;
	}

	public E displayFirst() {
		if (null != first) {
			return first.item;
		}
		return null;
	}

	public void displayAll() {
		Link current = first;
		while (current != null) {
			System.out.println(current.item);
			current = current.next;
		}
	}

	public E deleteFirst() {
		Link temp = first;
		// If the list is having only one element then point last to null.
		if (null == first.next)
			last = null;
		first = first.next;
		size--;
		return temp.item;
	}

	public E deleteLast() {
		System.out.println("Implement Later");
		return null;
	}
}
