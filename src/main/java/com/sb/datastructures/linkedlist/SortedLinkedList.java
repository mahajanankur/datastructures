/**
 * 
 */
package com.sb.datastructures.linkedlist;

/**
 * @author ankur.mahajan
 * @written 16-Feb-2019
 * 
 *          Currently it only supports Integer values.
 */
public class SortedLinkedList<E extends Number> {

	class Node {

		E item;

		Node next;

		public Node(E item) {
			this.item = item;
		}
	}

	private Node first;

	private int size;

	public SortedLinkedList() {
		first = null;
		size = 0;
	}

	public void add(E item) {
		Node newNode = new Node(item);
		Node current = first;
		Node previous = null;

		while (null != current && (Integer) item > (Integer) current.item) {
			previous = current;
			current = current.next;
		}

		// If previous is null means item will go at 0 index first will be
		// newNode.
		if (null == previous)
			first = newNode;
		else
			previous.next = newNode;
		newNode.next = current;
		size++;
	}

	public E deleteFirst() {
		if (null != first) {
			Node temp = first;
			first = first.next;
			size--;
			return temp.item;
		}
		return null;
	}

	public E find(E element) {
		Node current = first;
		int index = 0;
		while (null != current) {
			if (element.equals(current.item)) {
				System.out.println("Index : " + index);
				return current.item;
			}
			current = current.next;
			index++;
		}
		return null;
	}

	public E delete(int index) {

		return null;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node current = first;
		while (current != null) {
			if (null != current.next)
				builder.append(current.item).append(" -> ");
			else
				builder.append(current.item).append(" -> null");
			current = current.next;
		}
		return builder.toString();
	}
}
