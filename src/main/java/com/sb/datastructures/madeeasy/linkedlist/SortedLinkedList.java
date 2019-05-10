/**
 * 
 */
package com.sb.datastructures.madeeasy.linkedlist;

/**
 * @author ankur.mahajan
 * @written 09-May-2019
 */
public class SortedLinkedList<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortedLinkedList<Integer> list = new SortedLinkedList<>();
		list.add(10);
		list.add(5);
		list.add(100);
		list.add(1);
		list.add(96);
		list.add(2);
		list.add(0);
		System.out.println(list);
	}

	static class Link<T> {

		T content;

		Link<T> next;

		Link<T> previous;

		public Link(T content) {
			this.content = content;
		}

	}

	private Link<T> first;

	private Link<T> last;

	private int size;

	public SortedLinkedList() {
		size = 0;
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public boolean add(T t) {
		Link<T> link = new Link<T>(t);
		return addLink(link);
	}

	public boolean addLink(Link<T> link) {
		Link<T> current = first;
		Link<T> prev = null;
		while (null != current && compareContent(link.content, current)) {
			prev = current;
			current = current.next;
		}
		if (prev == null) {
			first = link;
		} else {
			prev.next = link;
		}
		link.next = current;
		size++;
		return true;
	}

	public Link<T> get(T content) {

		return null;
	}

	private boolean compareContent(T content, Link<T> current) {
		if (content instanceof Number) {
			return (Integer) content > (Integer) current.content ? true : false;
		}
		return false;
	}

}
