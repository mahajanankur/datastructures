/**
 * 
 */
package com.sb.datastructures.madeeasy.linkedlist;

import com.sb.datastructures.madeeasy.linkedlist.RemoveLoop.LinkedList.Link;

/**
 * @author ankur.mahajan
 * @written 08-May-2019
 */
public class RemoveLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		Link<Integer> link = new Link<Integer>(4);
		list.addLastLink(link);
		list.addLast(5);
		list.addLast(6);
		list.addLast(7);
		list.addLastLink(link);

		System.out.println(list.isLoop());
		list.removeLoop();
		System.out.println("After removal : " + list.isLoop());

	}

	static class LinkedList<T> {

		static class Link<T> {
			T content;

			Link<T> next;

			public Link(T content) {
				super();
				this.content = content;
			}

		}

		private Link<T> first;

		private Link<T> last;

		private int size;

		Link<T> slow;

		Link<T> fast;

		public LinkedList() {
			first = null;
			last = null;
			slow = null;
			fast = null;
			size = 0;
		}

		public boolean addFirst(T e) {
			Link<T> n = new Link<T>(e);
			return addFirstLink(n);
		}

		public boolean addLast(T e) {
			Link<T> n = new Link<T>(e);
			return addLastLink(n);
		}

		private boolean addLastLink(Link<T> link) {
			if (isEmpty()) {
				first = link;
			} else {
				last.next = link;
			}
			last = link;
			size++;
			return true;
		}

		public boolean addFirstLink(Link<T> link) {
			if (isEmpty()) {
				last = link;
			}

			link.next = first;
			first = link;
			size++;
			return true;
		}

		public boolean isEmpty() {
			return size == 0 ? true : false;
		}

		public boolean isLoop() {
			slow = first;
			fast = first;

			while (null != fast.next) {
				slow = slow.next;
				fast = fast.next.next;
				if (slow.equals(fast)) {
					return true;
				}
			}
			return false;
		}

		public void removeLoop() {
			Link<T> prev = null;
			slow = first;
			while (slow != null || fast != null) {
				slow = slow.next;
				prev = fast;
				fast = fast.next;
				if (slow.equals(fast)) {
					// Remove loop
					prev.next = null;
					break;
				}
			}

		}
	}

}
