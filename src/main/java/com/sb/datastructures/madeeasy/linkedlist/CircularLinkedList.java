/**
 * 
 */
package com.sb.datastructures.madeeasy.linkedlist;

import com.sb.datastructures.List;

/**
 * @author ankur.mahajan
 * @written 02-May-2019
 */
public class CircularLinkedList<T> implements List<T> {

	static class Link<T> {

		T content;

		Link<T> next;

		Link<T> prev;

		public Link(T content) {
			this.content = content;
		}

	}

	private Link<T> first;

	private Link<T> last;

	private int size;

	public CircularLinkedList() {
		size = 0;
		first = null;
		last = null;

	}

	//  --------------------
	// | 					|
	// -> 1 -> 2 -> 3 -> 4 -
	public boolean addFirst(T e) {
		Link<T> link = new Link<T>(e);
		if (isEmpty()) {
			last = link;
		}
		link.next = first;
		first = link;
		last.next = link;
		size++;
		return true;
	}

	public boolean addLast(T e) {
		Link<T> link = new Link<T>(e);
		if (isEmpty()) {
			first = link;
		} else {
			last.next = link;
		}
		link.next = first;
		last = link;
		size++;
		return true;
	}

	@Override
	public boolean add(T e) {
		addLast(e);
		return true;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public T removeFirst() {
		if (isEmpty())
			throw new RuntimeException("List is empty.");
		Link<T> temp = first;
		first = first.next;
		last.next = first;
		size--;
		return temp.content;
	}

	public T removeLast() {
		if (isEmpty())
			throw new RuntimeException("List is empty.");
		// TODO - Need to traverse from first, if it's not doubly linked.
		size--;
		return null;
	}
	@Override
	public T remove(int index) {
		size--;
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	@Override
	public int size() {
		return size;
	}

}
