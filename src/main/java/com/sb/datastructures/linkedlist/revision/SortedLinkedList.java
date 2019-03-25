/**
 * 
 */
package com.sb.datastructures.linkedlist.revision;

/**
 * @author ankur.mahajan
 * @written 14-Mar-2019
 */
public class SortedLinkedList<E> {

	static class Link<E> {
		E element;

		Link<E> next;

		Link(E element) {
			this.element = element;
		}
	}

	private Link<E> first;

	private int size;

	public SortedLinkedList() {
		size = 0;
		first = null;
	}

	public boolean add(E element) {
		Link<E> newLink = new Link<E>(element);
		Link<E> current = first;
		Link<E> previous = null;

		while (null != current && (int) element < (int) current.element) {
			previous = current;
			current = current.next;
		}

		if (null == previous)
			first = newLink;
		else
			previous.next = newLink;
		newLink.next = current;
		return true;
	}
}
