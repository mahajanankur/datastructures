/**
 * 
 */
package com.sb.datastructures.linkedlist;

/**
 * @author ankur.mahajan
 * @written 16-Feb-2019
 */
public class DoublyLinkedList<E> {

	class Link {

		E item;

		Link next;

		Link previous;

		public Link(E item) {
			this.item = item;
		}
	}

	// Make them protected so that List Iterator class can use it.
	Link first;

	Link last;

	private int size;

	public DoublyLinkedList() {
		first = null;
		last = null;
		size = 0;
	}

	public void addFirst(E item) {
		Link newLink = new Link(item);
		if (isEmpty())
			last = newLink;
		else
			first.previous = newLink;
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
		newLink.previous = last;
		last = newLink;
		size++;
	}

	public void addAfter(E after, E item) {
		Link newLink = new Link(item);
		Link prev = findLinkByElement(after);
		if (null != prev) {
			Link next = prev.next;
			if (null == next) {
				last = newLink;
			}
			else {
				newLink.next = next;
				next.previous = newLink;
			}
			prev.next = newLink;
			newLink.previous = prev;
		}
		size++;
	}

	private Link findLinkByElement(E element) {
		Link current = first;
		while (null != current) {
			if (current.item.equals(element)) {
				return current;
			}
			current = current.next;
		}

		return null;

	}

	public E findFirst() {
		return null == first ? null : first.item;
	}

	public E findLast() {
		return null == last ? null : last.item;
	}

	public E findAfter(E after) {
		Link link = findLinkByElement(after);
		return null == link ? null : (null == link.next ? null : link.next.item);
	}

	public E find(E item) {
		Link link = findLinkByElement(item);
		return null == link ? null : link.item;
	}

	public E deleteFirst() {
		if (isEmpty()) {
			throw new RuntimeException("List is empty.");
		}
		Link temp = first;
		// If the list is having only one element then point last to null.
		if (null == first.next)
			last = null;
		first = first.next;
		// First previous should point to null.
		first.previous = null;
		size--;
		return temp.item;
	}

	public E deleteLast() {
		if (isEmpty()) {
			throw new RuntimeException("List is empty.");
		}
		Link temp = last;
		if (null == last.previous)
			first = null;
		last = last.previous;
		last.next = null;
		size--;
		return temp.item;
	}

	public E deleteAfter(E after) {
		if (isEmpty()) {
			throw new RuntimeException("List is empty.");
		}
		Link prev = findLinkByElement(after);
		Link linkToDelete = null == prev ? null : (null == prev.next ? null : prev.next);
		if (null == linkToDelete)
			throw new RuntimeException("Link not exist.");
		if (null != linkToDelete.next) {
			Link next = linkToDelete.next;
			next.previous = prev;
			prev.next = next;
		}
		else {
			prev.next = null;
			last = prev;
		}

		size--;

		return null == linkToDelete ? null : linkToDelete.item;
	}

	public boolean isEmpty() {
		return (null == first);
	}

	public int size() {
		return size;
	}

	public String toStringFromFirst() {
		StringBuilder builder = new StringBuilder();
		Link current = first;
		while (null != current) {
			if (null != current.next)
				builder.append(current.item).append(" -> ");
			else
				builder.append(current.item).append(" -> null");
			current = current.next;
		}
		return builder.toString();
	}

	public String toStringFromLast() {
		StringBuilder builder = new StringBuilder();
		Link current = last;
		while (null != current) {
			if (null != current.previous)
				builder.append(current.item).append(" ---> ");
			else
				builder.append(current.item).append(" ---> null");
			current = current.previous;
		}
		return builder.toString();
	}

	public ListIterator<E> getListIterator() {
		return new ListIterator<>(this);
	}
}
