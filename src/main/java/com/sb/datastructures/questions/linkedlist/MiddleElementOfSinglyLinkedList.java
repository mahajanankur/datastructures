/**
 * 
 */
package com.sb.datastructures.questions.linkedlist;

/**
 * @author ankur.mahajan
 * @written 10-Apr-2019
 */
public class MiddleElementOfSinglyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> l = new LinkedList<String>();
		l.addFirst("a");
		l.addFirst("b");
		l.addFirst("c");
		l.addFirst("d");
		l.addFirst("e");
		// l.addFirst("f");
		// l.addFirst("g");
		// l.addFirst("h");
		System.out.println(l.middleByIteration());
		System.out.println(l.middleByTwoPointers());
	}

	static class LinkedList<T> {

		/**
		 * @author ankur.mahajan
		 * @written 10-Apr-2019
		 * @param <T>
		 */
		static class Node<T> {
			T content;

			Node<T> next;

			/**
			 * @param content
			 */
			public Node(T content) {
				super();
				this.content = content;
			}

		}

		Node<T> first;

		// Node<T> middle;

		int size;

		public LinkedList() {
			first = null;
			size = 0;
			// middle = null;
		}

		/**
		 * @return
		 */
		public boolean isEmpty() {
			return size == 0 ? true : false;
		}

		/**
		 * @return
		 */
		public int size() {
			return size;
		}

		/**
		 * @param e
		 * @return
		 */
		public boolean addFirst(T e) {
			Node<T> n = new Node<T>(e);
			n.next = first;
			first = n;
			size++;
			return true;
		}

		/**
		 * @return
		 */
		public T getFirst() {
			if (isEmpty())
				return null;
			return first.content;
		}

		public T middleByIteration() {
			Node<T> middle = null;
			Node<T> current = first;
			int loop = 0;
			while (size / 2 > loop++) {
				middle = current.next;
				current = middle;
			}

			return null != middle ? middle.content : null;
		}

		public T middleByTwoPointers() {
			Node<T> slow = first;
			Node<T> fast = first;
			// Run slow pointer by 1 and fast pointer by 2, when the fast
			// pointer reaches last the slow pointer will be at middle.
			while (null != fast.next) {
				slow = slow.next;
				fast = fast.next.next;
			}

			return slow.content;
		}
	}

}
