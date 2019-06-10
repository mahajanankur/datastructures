/**
 * 
 */
package com.sb.datastructures.revision.linkedlist;

/**
 * @author ankur.mahajan
 * @written 14-Mar-2019
 */
public class LinkedList<E> {

	static class Link<E> {
		E element;

		Link<E> next;

		Link(E element) {
			this.element = element;
		}
	}

	private Link<E> first;

	private int size;

	public LinkedList() {
		size = 0;
		first = null;
	}

	public boolean addFirst(E element) {
		Link<E> newLink = new Link<E>(element);
		newLink.next = first;
		first = newLink;
		size++;
		return true;
	}
}
