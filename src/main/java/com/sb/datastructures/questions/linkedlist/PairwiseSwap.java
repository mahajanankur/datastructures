/**
 * 
 */
package com.sb.datastructures.questions.linkedlist;

/**
 * @author ankur.mahajan
 * @written 03-Jun-2019
 */
public class PairwiseSwap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addFirst(8);
		list.addFirst(7);
		list.addFirst(6);
		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(2);
		list.addFirst(2);
		list.addFirst(1);

		list.pairwiseSwap(list.first);

	}

	static class LinkedList<T> {

		static class Link<T> {
			T data;
			Link<T> next;
			public Link(T data) {
				this.data = data;
			}

		}

		Link<T> first;
		int size;

		public LinkedList() {
			first = null;
			size = 0;
		}

		public boolean isEmpty() {
			return size == 0 ? true : false;
		}

		public boolean addFirst(T element) {
			Link<T> nLink = new Link<T>(element);
			nLink.next = first;
			first = nLink;
			size++;
			return true;
		}

		public void pairwiseSwap(Link<T> first) {
			Link<T> current = first;

			while (true) {
				Link<T> one = current;
				Link<T> two = current.next;
				Link<T> rest = current.next.next;

				two.next = one;
				one.next = rest;

				current = rest;
			}

		}
	}

}
