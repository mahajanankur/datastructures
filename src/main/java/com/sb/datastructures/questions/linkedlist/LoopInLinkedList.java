/**
 * 
 */
package com.sb.datastructures.questions.linkedlist;

/**
 * @author ankur.mahajan
 * @written 10-Apr-2019
 */
public class LoopInLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedList<String> a = new LinkedList<String>();
		a.addLast(new Node<String>("a"));
		a.addLast(new Node<String>("b"));
		a.addLast(new Node<String>("c"));
		// First create loop in the list.
		Node<String> cyclicNode = new Node<String>("d");
		// Add same object.
		a.addLast(cyclicNode);
		a.addLast(new Node<String>("e"));
		a.addLast(new Node<String>("f"));
		a.addLast(new Node<String>("g"));
		// Add same object.
		a.addLast(cyclicNode);
		System.out.println(a.isCyclic());
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
		 * @return
		 */
		public boolean isEmpty() {
			return size == 0 ? true : false;
		}

		/**
		 * @param c
		 * @return
		 */
		public boolean addLast(Node<T> node) {
			// Node<T> node = new Node<T>(c);
			if (isEmpty())
				first = node;
			else
				last.setNext(node);
			last = node;
			size++;
			return true;
		}

		public boolean isCyclic() {
			Node<T> slow = first;
			Node<T> fast = first;

			while (null != fast.getNext()) {
				slow = slow.getNext();
				fast = fast.getNext().getNext();

				if (slow.equals(fast)) {
					return true;
				}
			}
			return false;
		}
	}
}
