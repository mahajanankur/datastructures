/**
 * 
 */
package com.sb.datastructures.madeeasy.linkedlist;

import com.sb.datastructures.List;

/**
 * @author ankur.mahajan
 * @written 01-May-2019
 */
public class DoublyLinkedList<T> implements List<T> {

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

	public DoublyLinkedList() {
		size = 0;
		first = null;
		last = null;
	}

	@Override
	public boolean add(T e) {
		return addLast(e);
	}

	public boolean addFirst(T e) {
		Link<T> link = new Link<T>(e);
		if (isEmpty()) {
			last = link;
		}
		link.next = first;
		first.prev = link;
		size++;
		return true;
	}

	public boolean addLast(T e) {
		Link<T> link = new Link<T>(e);
		if (isEmpty()) {
			first = link;
		} else {
			last.next = link;
			link.prev = last;
		}
		last = link;
		size++;
		return true;
	}

	@Override
	public T get(int index) {
		return getLink(index).content;
	}

	private Link<T> getLink(int index) {
		if (isEmpty())
			throw new RuntimeException("List is empty.");
		checkRange(index);
		int initPointer = 0;
		Link<T> current = first;
		while (index > initPointer++) {
			current = current.next;
		}
		return current;
	}

	private void checkRange(int index) {
		if (index >= size)
			throw new RuntimeException("Index out of bound.");
	}

	public T getFirst() {
		if (isEmpty())
			throw new RuntimeException("List is empty.");
		return first.content;
	}

	public T getLast() {
		if (isEmpty())
			throw new RuntimeException("List is empty.");
		return last.content;
	}

	@Override
	public T remove(int index) {
		if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Link<T> temp = getLink(index);
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			size--;
			return temp.content;
		}
	}

	public T removeFirst() {
		if (isEmpty())
			throw new RuntimeException("List is empty.");
		Link<T> temp = first;
		first = first.next;
		if (null != first)
			first.prev = null;
		size--;
		return temp.content;
	}

	public T removeLast() {
		if (isEmpty())
			throw new RuntimeException("List is empty.");
		Link<T> temp = last;
		last = last.prev;
		last.next = null;
		size--;
		return temp.content;
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
