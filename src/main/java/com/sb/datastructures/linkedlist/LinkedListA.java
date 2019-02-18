/**
 * 
 */
package com.sb.datastructures.linkedlist;

/**
 * @author ankur.mahajan
 * @written 14-Feb-2019
 */
public class LinkedListA<E> {

	private class Link {

		public E data;

		public Link next;

		public Link(E data) {
			this.data = data;
		}
	}

	private Link first;

	private int size;

	public LinkedListA() {
		first = null;
		size = 0;
	}

	public void insertFirst(E data) {
		Link link = new Link(data);
		link.next = first;
		first = link;
		size++;
	}

	public E deleteFirst() {
		Link temp = first;
		first = first.next;
		size--;
		return temp.data;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public E peekFirst() {
		if (null != first) {
			return first.data;
		}
		return null;
	}

	public void displayAll() {
		Link current = first;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	public E find(E element) {
		for (Link i = first; i != null; i = i.next) {
			if (i.data.equals(element)) {
				return i.data;
			}
		}

		return null;

	}

	public E delete(E element) {
		Link currentElemet = null;
		Link previousElemet = null;
		for (Link i = first; i != null; i = i.next) {
			// Return null, if next is null this means the element is not found
			// and don't look further.
			if (null == i.next)
				return null;
			if (i.data.equals(element)) {
				currentElemet = i;
				break;
			}
			else {
				previousElemet = i;
			}
		}
		// If the current link is the first link. In this case the link is
		// deleted by changing first to point to first.next
		if (first == currentElemet)
			first = first.next;
		else
			previousElemet.next = currentElemet.next;
		size--;
		return (currentElemet == null ? null : currentElemet.data);

	}

	public int size() {
		return size;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		Link current = first;
		while (null != current) {
			if (current.next != null)
				builder.append(current.data).append(" -> ");
			else
				builder.append(current.data).append(" -> null");
			current = current.next;
		}
		return builder.toString();
	}

}
