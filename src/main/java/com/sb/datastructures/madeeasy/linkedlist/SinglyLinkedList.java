/**
 * 
 */
package com.sb.datastructures.madeeasy.linkedlist;

import com.sb.datastructures.List;

/**
 * @author ankur.mahajan
 * @written 01-May-2019
 */
public class SinglyLinkedList<T> implements List<T> {

	static class Link<T> {

		T content;

		Link<T> next;

		public Link(T content) {
			this.content = content;
		}
	}

	private Link<T> first;

	private Link<T> last;

	private int size;

	public SinglyLinkedList() {
		first = null;
		last = null;
		size = 0;

	}

	// 1-> 2 -> 3 -> null
	// AddFirst
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
		first = link;
		size++;
		return true;
	}

	public boolean addLast(T e) {
		Link<T> link = new Link<T>(e);
		if (isEmpty())
			first = link;
		else
			last.next = link;

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
		int currentInd = 0;
		Link<T> currentLink = first;
		while (index > currentInd) {
			currentLink = currentLink.next;
			currentInd++;
		}
		return currentLink;
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

	public T removeFirst() {
		if (isEmpty())
			throw new RuntimeException("List is empty.");
		Link<T> temp = first;
		first = first.next;
		return temp.content;
	}

	public T removeLast() {
		if (isEmpty())
			throw new RuntimeException("List is empty.");
		Link<T> temp = last;
		return null;
	}

	@Override
	public T remove(int index) {
		if (isEmpty())
			throw new RuntimeException("List is empty.");
		Link<T> preLink = null;
		Link<T> temp = null;
		if (index == 0) {
			temp = first;
			first = first.next;

		} else if (index == size - 1) {
			preLink = getLink(index - 1);
			temp = preLink.next;
			preLink.next = null;

		} else {
			preLink = getLink(index - 1);
			temp = preLink.next;
			preLink.next = preLink.next.next;
		}
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

	private void checkRange(int index) {
		if (index >= size) {
			throw new RuntimeException("Index out of bound.");
		}
	}

}
