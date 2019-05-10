/**
 * 
 */
package com.sb.datastructures.questions.linkedlist;

/**
 * @author ankur.mahajan
 * @written 10-Apr-2019
 */
public class ReverseLinkedList {

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
		System.out.println(l.toString());
		l.reverseList();
		System.out.println(l.toString());

	}

	static class LinkedList<T> {

		Node<T> first;

		Node<T> last;

		int size;

		public LinkedList() {
			size = 0;
			first = null;
			last = null;
		}

		/**
		 * @param t
		 * @return
		 */
		public boolean addFirst(T t) {
			Node<T> n = new Node<T>(t);
			n.setNext(first);
			first = n;
			size++;
			return true;
		}

		/**
		 * @param t
		 * @return
		 */
		public boolean addLast(T t) {
			Node<T> n = new Node<T>(t);
			if (isEmpty())
				first = n;
			else
				last.setNext(n);
			last = n;
			size++;
			return true;
		}

		/**
		 * @return
		 */
		public boolean isEmpty() {
			return size == 0 ? true : false;
		}

		/**
		 * 
		 */
		public void reverseList() {
			Node<T> current = first;
			Node<T> prev = null;
			Node<T> next = first.getNext();
			while (true) {
				current.setNext(prev);
				prev = current;
				current = next;
				if (next == null)
					break;
				next = next.getNext();
			}
			first = prev;
		}

		/**
		 * @toString
		 */
		public String toString() {
			StringBuilder builder = new StringBuilder();
			Node<T> current = first;
			while (null != current) {
				if (current.getNext() != null)
					builder.append(current.getContent()).append(" -> ");
				else
					builder.append(current.getContent()).append(" -> null");
				current = current.getNext();
			}
			return builder.toString();
		}

		/**
		 * @return
		 */
		public int size() {
			return size;
		}
	}

}
